const mongoose = require("mongoose");

mongoose.connect("mongodb://localhost:27017/user-account-api", {
  useNewUrlParser: true,
  useCreateIndex: true,
  useUnifiedTopology: true
});

// const User = mongoose.model("Account", {
//   email: { type: String },
//   password: { type: String }
// });
