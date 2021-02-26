const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const path = require('path');

const app = express();

//false: queryString
//true qs
app.use(bodyParser.urlencoded({extented: true}));

app.get('/', '/add-product', (req, res, next) =>{
    fs.createReadStream(path.join(__dirname, 'views', 'add-product.html')).pipe(res);
});

app.post('/save-product', (req, res, next) =>{
    console.log('save product');
    console.log(req.body);
    res.send('Save successfully');
});

app.all('/', (req, res, next)=>{
    res.send('This is / page');
});

app.listen(3000);