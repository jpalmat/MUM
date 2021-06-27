const mongoClient = require('mongodb').MongoClient;

mongoClient.connect('mongodb://localhost:27017')
    .then(client => {
        console.log('conected...');
        const db = client.db('testdb');
        db.collection('products').find().each(function(err, doc){
            console.log(doc);
            client.close();
        })
    }).catch(err => console.log(err));