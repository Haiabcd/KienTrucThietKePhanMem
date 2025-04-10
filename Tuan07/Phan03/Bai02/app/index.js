const express = require('express');
const { MongoClient } = require('mongodb');

const app = express();
const port = 3000;
const mongoUrl = 'mongodb://mongo:27017';
const dbName = 'mydb';

app.use(express.json());

app.post('/data', async (req, res) => {
  const client = new MongoClient(mongoUrl);
  try {
    await client.connect();
    const db = client.db(dbName);
    const result = await db.collection('data').insertOne(req.body);
    res.status(201).send(result);
  } catch (err) {
    res.status(500).send(err);
  } finally {
    await client.close();
  }
});

app.listen(port, () => {
  console.log(`Node.js app listening at http://localhost:${port}`);
});
