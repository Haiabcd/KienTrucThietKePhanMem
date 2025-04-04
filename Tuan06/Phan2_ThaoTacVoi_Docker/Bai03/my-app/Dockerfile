# Sử dụng node:18-alpine làm base image
FROM node:18-alpine

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt các dependencies của ứng dụng
RUN npm install

# Sao chép tất cả mã nguồn vào trong container
COPY . .

# Build ứng dụng React
RUN npm run build

# Cài đặt Nginx để phục vụ các file build
FROM nginx:alpine

# Sao chép các file đã build vào thư mục của Nginx
COPY --from=0 /app/build /usr/share/nginx/html

# Mở cổng 80 để Nginx có thể phục vụ ứng dụng
EXPOSE 80

# Chạy Nginx trong container
CMD ["nginx", "-g", "daemon off;"]
