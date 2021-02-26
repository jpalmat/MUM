const express = require('express');
const path = require('path');
const shopController = require('../controllers/shop');

const router = express.Router();

router.get('/', shopController.getAllProducts);

router.get('/products/:prodId', shopController.getProductDetail);

router.get('/error-demo', (req, res, next) => {
    throw new Error('This is to test Error handling in express');
});

router.post('/addToCart', shopController.addToCart);

router.get('/cart', shopController.getCart)

router.post('/delete-cart', shopController.deleteInCart)

module.exports = router;