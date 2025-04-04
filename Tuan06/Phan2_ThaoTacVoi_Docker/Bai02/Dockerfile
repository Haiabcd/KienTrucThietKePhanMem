# Sử dụng Python 3.9 làm base image
FROM python:3.9

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file requirements.txt và cài đặt thư viện
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# Sao chép mã nguồn vào container
COPY . .

# Mở cổng 5000
EXPOSE 5000

# Lệnh để chạy ứng dụng Flask
CMD ["python", "app.py"]
