const mongoClient = require('mongodb').MongoClient;
let _db;

const mongoconnect = function(callback){
    mongoClient.connect('mongodb://localhost:27017', {useUnifiedTopology: true})
    .then(client => {
        _db = client.db('onlineshopping');
        //callback(client);
        callback();
    })
    .catch(err => {
        console.log(err);
        throw new Error('DB connection failed...');
    });
}

const getDb = () => {
    if(_db) {
        return _db;
    } else {
        throw new Error('Db connect failed');
    }
}

//module.exports = mongoconnect;
exports.mongoconnect = mongoconnect;
exports.getDb = getDb;