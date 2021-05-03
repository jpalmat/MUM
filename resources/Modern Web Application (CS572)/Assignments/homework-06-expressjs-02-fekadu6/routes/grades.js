const express = require("express");

const grades = [{ id: 1, name: "Fi", course: "CS572", grade: 95 }];

const router = express.Router();

//get grade by id
router.get("/api/:id", (req, res) => {
  console.log(req.params.id);
  res.send(
    JSON.stringify(grades.filter(element => element.id == req.params.id))
  );
});

//get all grades
router.get("/api", (req, res) => {
  res.send(JSON.stringify(grades));
});

//post grade
router.post("/api", (req, res) => {
  const data = req.body || "";
  //Validate the data elements
  if (!data.id || !data.name || !data.course || !data.grade) {
    res.send("Error: data not in a correct format");
  }

  //create a new grade object
  const newGrade = {
    id: req.body.id,
    name: req.body.name,
    course: req.body.course,
    grade: req.body.grade
  };

  grades.push(newGrade);

  res.send(JSON.stringify(grades));
});

//delete grade by id
router.delete("/api/:id", (req, res) => {
  const arr = grades.filter(element => element.id == req.params.id);
  res.send("Successfully deleted: " + JSON.stringify(arr));
});

module.exports = router;
