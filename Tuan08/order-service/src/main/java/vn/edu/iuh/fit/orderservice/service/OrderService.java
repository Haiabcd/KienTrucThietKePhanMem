package vn.edu.iuh.fit.orderservice.service;



import vn.edu.iuh.fit.orderservice.model.Order;



public interface OrderService {
  public Order save(Order order);
  public Order getOrderById(Long id);
}