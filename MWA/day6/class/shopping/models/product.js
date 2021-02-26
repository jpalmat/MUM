const products = [];
const getDb = require('../util/database').getDb;
const ObjectId = require('mongodb').ObjectID;

class Product {

    constructor(id, title, price, imageURL, description) {
        this._id = id;
        this.title = title;
        this.price = price;
        this.imageURL = imageURL;
        this.description = description;
    }

    save() {
        const db = getDb();
        db.collection('products').insertOne(this)
            .then(result => {
                         console.log(result.result);
                         client.close();
                        })
            .catch(err => console.log(err));
    }

    static findAll() {
        const db = getDb();
        return db.collection('products')
            .find()
            .toArray();
        //return products;
    }

    static findById(prodId) {
        //return products.filter(p => p.id == prodId);
        
        const db = getDb();
        return db.collection('products')
            .findOne({_id: new ObjectId(prodId)});
    }

    update() {
        const db = getDb();
        return db.collection('products')
            .updateOne({ _id: new ObjectId(this._id) }, {
                $set: {
                    title: this.title,
                    price: this.price,
                    imageURL: this.imageURL,
                    description: this.description
                }
            });
    }

    static deleteById(prodId) {
        const db = getDb();
        return db.collection('products')
            .remove({ _id: new ObjectId(prodId) });
    }
}

module.exports = Product;