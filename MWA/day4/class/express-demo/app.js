const express = require('express');

const app = express();

app.enable('case sensitive routing');
app.enable('etag');
app.set('env', 'development');

app.use((req, res, next) => {
    console.log('this is middleware, always is called');
    next();
});

app.use('/users', (req, res, next) => {
    res.send('hello from user');
});

app.use('/', (req, res, next) => {
    res.send('hello from express');
})

app.listen(3000, function() {
    console.log('server running on 3000');
});