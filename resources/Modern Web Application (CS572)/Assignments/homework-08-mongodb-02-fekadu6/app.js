const express = require("express");
const router = require("./router/location_router");

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());

app.use("/locations", router);

app.listen(port, _ => console.log(`Server running on port ${port}`));
