const Product = require('../models/product');

exports.getAddProduct = (req, res, next) => {
    res.render('admin/add-product', {
        pageTitle: 'Add Product',
        path: '/admin/add-product'
    });
};

exports.getProducts = (req, res, next) => {
    Product.fetchAll()
        .then(products => {
            res.render('admin/products', {
                pageTitle: 'Products',
                path: '/admin/products',
                prods: products
            });
        })
        .catch(err => console.log(err));

};

exports.postAddProduct = (req, res, next) => {
    const title = req.body.title;
    const imageUrl = req.body.imageUrl;
    const price = req.body.price;
    const description = req.body.description;
    const product = new Product(null, title, imageUrl, price, description, req.user._id);
    product.save()
        .then(result => {
            res.redirect('/');
        })
        .catch(err => console.log(err));
};

exports.getEditProduct = (req, res, next) => {
    const prodId = req.params.prodId;
    Product.findById(prodId)
        .then(product => {
            res.render('admin/edit-product', {
                product: product,
                pageTitle: 'Edit Product',
                path: '/admin/products',
            });
        })
        .catch(err => console.log(err));

}

exports.postEditProduct = (req, res, next) => {
    const id = req.body._id;
    const title = req.body.title;
    const imageUrl = req.body.imageUrl;
    const price = req.body.price;
    const description = req.body.description;
    const product = new Product(id, title, imageUrl, price, description);
    product.update()
        .then(result => {
            console.log(result, "----------------");
            res.redirect('/admin/products');
        })
        .catch(err => console.log(err));

}

exports.postDeleteProduct = (req, res, next) => {
    Product.deleteById(req.body._id)
        .then(result => {
            console.log(result, '**********');
            res.redirect('/admin/products');
        })
        .catch(err => console.log(err));

}