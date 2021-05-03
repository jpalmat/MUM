const jwt = require("jsonwebtoken");

module.exports = (req, res, next) => {
  try {
    const token = req.headers.authorization.split(" ")[1];
    jwt.verify(token, "my_secret_private_key");
    next();
  } catch (e) {
    res.status(401).json({ message: "Authentication failed" });
  }
  //"Bearer my_secret_private_key"
};
