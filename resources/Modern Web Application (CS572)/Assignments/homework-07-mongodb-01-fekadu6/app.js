const express = require("express");
const path = require("path");

const app = express();

const routePath = require("./routes/lecture_routes.js");

const port = process.env.PORT || 3000;

app.use(express.json());
app.use("/lectures", routePath);

app.listen(port, _ => console.log(`The server started on port ${port}`));
