const path = require('path');

const express = require('express');
const bodyParser = require('body-parser');

const errorController = require('./controllers/error');
// const mongoConnect = require('./util/database').mongoConnect;
const mongoose = require('mongoose');

const app = express();

app.set('view engine', 'ejs');
app.set('views', 'views');

const adminRoutes = require('./routes/admin');
const shopRoutes = require('./routes/shop');
const User = require('./models/user');

app.use((req, res, next) => {
    User.findById('5e4c68b94ceeb654cc6fb342')
        .then(user => {
            req.user = user;
            next();
        })
        .catch(err => console.log(err));
});


app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

app.use('/admin', adminRoutes);
app.use(shopRoutes);

app.use(errorController.get404);

mongoose.connect('mongodb://localhost:27017/onlineshopping', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => {
        // const user = new User({
        //     name: 'Josh',
        //     email: 'josh@miu.edu',
        //     carts: []
        // });
        // user.save();
        app.listen(3000);
    }).catch(err => console.error(err));

