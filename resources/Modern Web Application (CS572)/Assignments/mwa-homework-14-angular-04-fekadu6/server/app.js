const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");

require("./db/database");
const accountRouter = require("./routes/account_routes");

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());

app.use(cors());

app.use("/account", accountRouter);

app.listen(port, _ => console.log(`Server is running on port ${port}`));
