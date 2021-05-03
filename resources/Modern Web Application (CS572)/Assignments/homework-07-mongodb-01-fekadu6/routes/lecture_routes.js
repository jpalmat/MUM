const express = require("express");
const MongoClient = require("mongodb").MongoClient;

const client = new MongoClient("mongodb://localhost:27017");

let db, collection;

client.connect(err => {
  db = client.db("homework07");
  collection = db.collection("lectures");
});

const router = express.Router();

router.post("/Add", (req, res) => {
  var newDoc = req.body;
  console.log(newDoc);
  collection.insertOne(newDoc, (err, docInserted) => {
    res.end("Congrats, data successfully submitted " + docInserted);
  });
});

router.get("/Find", (req, res) => {
  collection.find({}).toArray(function(error, documents) {
    if (error) throw error;

    res.send(documents);
  });
});

router.get("/FindOne/:course", (req, res) => {
  const query = { course: req.params.course };
  collection.find(query).toArray((error, documents) => {
    if (error) throw error;

    //console.log(req.params.course, documents);
    res.send(documents);
  });
});

router.delete("/Delete/:course", (req, res) => {
  const query = { course: req.params.course };
  collection.deleteOne(query);
  res.send(`Course successfully deleted`);
});

router.get("/search/:q", (req, res) => {
  const query = { course: { $regex: req.params.q } };

  collection.find(query).toArray((error, documents) => {
    if (error) throw error;

    res.send(documents);
  });
});

module.exports = router;
