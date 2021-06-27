const Product = require('../models/product');
const cart = require('../models/carts');

exports.getAllProducts = (req, res, next) => {
    const products = Product.findAll();
    // console.log(products);
    res.render('index', { name: 'Josh', prods: products, path: '/', pageTitle: 'Home' });
};

exports.getProductDetail = (req, res, next) => {
    const products = Product.findById(req.params.prodId);
    res.render('product-detail', { prod: products[0], pageTitle: 'Product Detail', path: '/', name: 'Edward' });
}

exports.addToCart = (req, res, next) => {
    const addProductId = Product.findById(req.body.id)[0];

    cart.save(addProductId);
    console.log(cart.getCart());
    res.redirect('/cart');
}

exports.getCart = (req, res, next) => {
    res.render('cart', {cart: cart.getCart(), pageTitle: 'Shoping cart detail', path: '/cart', name: 'Jimmy'});
}

exports.deleteInCart = (req, res, next) => {
    cart.delete(req.body.productid);
    res.redirect('/cart');
}