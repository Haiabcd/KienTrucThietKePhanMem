package vn.edu.iuh.fit.orderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.orderservice.model.Order;
import vn.edu.iuh.fit.orderservice.repository.OrderRepository;
import vn.edu.iuh.fit.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "productServiceCircuitBreaker", fallbackMethod = "productServiceFallback")
    @Retry(name = "productServiceRetry")
    @RateLimiter(name = "productServiceRateLimiter")
    @Override
    public Order createOrder(Order order) {
        Long productId = order.getProduct();
        String productServiceUrl = "http://localhost:8001/api/product/" + productId;

        try {
            ResponseEntity<Map> productResponse = restTemplate.getForEntity(productServiceUrl, Map.class);

            if (!productResponse.getStatusCode().is2xxSuccessful()) {
                return null;
            }

            Map<String, Object> responseBody = productResponse.getBody();
            if (responseBody == null || responseBody.get("data") == null) {
                return null;
            }

            return orderRepository.save(order);

        } catch (ResourceAccessException e) {
            System.err.println("Unable to connect to the product service: " + e.getMessage());
            throw new IllegalStateException("Product service is currently unavailable");
        } catch (Exception e) {
            System.err.println("Error while processing product information: " + e.getMessage());
            throw new IllegalArgumentException("Invalid product data or product not found");
        }
    }

    public Order productServiceFallback(Order order, Throwable cause) {
        System.err.println("Fallback triggered due to: " + cause.getMessage());
        throw new RuntimeException("Fallback: Unable to process the order due to product service failure");
    }



    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
