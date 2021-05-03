const MongoClient = require("mongodb").MongoClient;
const express = require("express");
const router = express.Router();

const client = new MongoClient("mongodb://localhost:27017");

let db, collection;

client.connect(err => {
  db = client.db("mumlocator");
  collection = db.collection("locations");

  collection.createIndex({ location: "2d" });
});

router.post("/add", (req, res) => {
  collection.insertOne(req.body, (err, confirmation) => {
    res.end(`Data is successfully added: ${confirmation}`);
  });
});

router.get("/find/:category", (req, res) => {
  console.log(req.params);
  collection
    .find({
      $and: [
        { category: req.params.category },
        { location: { $near: [-91.9772066, 41.0182551] } }
      ]
    })
    .toArray((err, data) => {
      res.json(data);
    });
});

module.exports = router;
