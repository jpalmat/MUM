const express = require('express');
const fs = require('fs');
const path = require('path');

const router = express.Router();

router.all('/', (req, res, next)=>{
    res.send('This is / page');
});

//error handling
router.get('/error-demo', (req, res, next)=>{
    throw new Error('This is an error');
});
module.exports = router;