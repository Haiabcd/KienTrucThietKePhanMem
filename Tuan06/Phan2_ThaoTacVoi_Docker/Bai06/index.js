const express = require("express");
const app = express();

app.get("/", (req, res) => {
  res.send("Hello, Docker! - Sử dụng multi-stage build trong dockerfile");
});

app.listen(3000, () => {
  console.log("Server running on port 3000");
});