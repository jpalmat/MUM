const express = require('express');
const fs = require('fs');
const path = require('path');
const router = express.Router();
const rootDir = require('./path');


router.get('/add-product', (req, res, next) =>{
    fs.createReadStream(path.join(rootDir, 'views', 'add-product.html')).pipe(res);
});

router.post('/add-product', (req, res, next) =>{
    console.log('save product');
    console.log(req.body);
    res.send('Save successfully');
});

module.exports = router;