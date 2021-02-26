const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const path = require('path');

const adminRoutes = require('./admin');
const shopRoutes = require('./shop');

const app = express();

//false: queryString
//true qs
app.use(bodyParser.urlencoded({extented: true}));

//serving static resources video 66
app.use(express.static(path.join(__dirname, 'public')));

app.use(adminRoutes);
app.use(shopRoutes);

//404 page not found video 63
app.use((req, res, next)=>{
    res.status(404).send('Page not fpund');
});

//error handling video 64
app.use((err, req, res, next)=>{
    res.status(500).send('something wrong');
});

app.listen(3000);