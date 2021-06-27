const Product = require('./product').Product; //exports.Product = Product;
// const Product = require('./product'); //module.exports

// const prod = new Product('pizza');
console.log(Product.getName());
Product.setName('pizza');
console.log(Product.getName());

const prod2 = require('./product').Product;
console.log(prod2.getName());