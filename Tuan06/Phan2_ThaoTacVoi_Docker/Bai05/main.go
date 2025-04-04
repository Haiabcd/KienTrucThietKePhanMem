package main

import (
    "fmt"
    "net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
    fmt.Fprintf(w, "Xin chao Docker - Viết Dockerfile để build và chạy một ứng dụng Go đơn giản.")
}

func main() {
    http.HandleFunc("/", handler)
    fmt.Println("Server started at :8080")
    http.ListenAndServe(":8080", nil)
}