const getDb = require('../util/database').getDb;
const ObjectId = require('mongodb').ObjectID;

class User {
    constructor(username, email, cart, id) {
        this.username = username;
        this.email = email;
        this.cart = cart; // {items: []}
        this._id = id;
    }

    save() {
        console.log(this);
        const db = getDb();
        return db.collection('users')
            .insertOne(this);
    }

    static findById(userId) {
        const db = getDb();
        return db.collection('users')
            .findOne({_id: new ObjectId(prodId)});
    }
}

module.exports = User;