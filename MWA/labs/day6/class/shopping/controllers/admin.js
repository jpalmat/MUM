const Product = require('../models/product');
const User = require('../models/user');

exports.getProductForm = (req, res, next) => {
    res.render('add-product', { name: 'Tina', path: '/admin/add-product', pageTitle: 'Add Product' });
}

exports.postProduct = (req, res, next) => {
    const title = req.body.title;
    const imageUrl = req.body.imageURL;
    const price = req.body.price;
    const description = req.body.description;

    const prod = new Product(null, title, price, imageUrl, description);
    prod.save();

    res.redirect('/');
}

exports.editProductPage = (req, res, next) => {
    Product.findById(req.params.prodId)
        .then(product => {
            res.render('edit-product', { product: product, path: '/', pageTitle: 'Edit Product', name: 'Tina' });
        }).catch(err => console.log(err));

}

exports.editProductPost = (req, res, next) => {
    const updatedProduct = new Product(req.body.id, req.body.title, req.body.price, req.body.imageURL, req.body.description);
    updatedProduct.update()
        .then(result => {
            res.redirect('/products/' + updatedProduct._id);
        })
        .catch(err => console.log(err));
    // res.redirect('/');
}

exports.deleteProduct = (req, res, next) => {
    Product.deleteById(req.body.id)
        .then(result => {
            res.redirect('/');
        })
        .catch(err => console.log(err));

}

exports.getUserForm = (req, res, next) => {
    res.render('add-user', { name: 'Jimmy', path: '/admin/add-user', pageTitle: 'Add User' });
}

exports.postUser = (req, res, next) => {
    const user = new User(req.body.name, req.body.email, [], '5e49bdefce95301ad0fa9870');
    user.save();
    res.redirect('/');
}