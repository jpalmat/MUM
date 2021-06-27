const { ObjectID } = require('mongodb');
const getDb = require('../util/database').getDb;

class User {
    constructor(username, email, cart, id) {
        this.username = username;
        this.email = email;
        this.cart = cart; // {items: []}
        this._id = id;
    }

    save() {
        const db = getDb();
        return db.collection('users')
            .insertOne(this);
    }

    update() {
        const db = getDb();
        return db.collection('users').updateOne({ _id: new ObjectID(this._id) }, { $set: { username: this.username, email: this.email } });
    }

    static findAll() {
        const db = getDb();
        return db.collection('users')
            .find()
            .toArray();
    }

    static findById(userId) {
        const db = getDb();
        return db.collection('users').findOne({ _id: new ObjectID(userId) });
    }

    static deleteById(userId) {
        const db = getDb();
        return db.collection('users').findOneAndDelete({ _id: new ObjectID(userId) });
    }

    addToCart(product) {
        if (this.cart === undefined) {
            this.cart = { items: [] };
        }
        const cartProductIndex = this.cart.items.findIndex(cp => {
            return cp.productId.toString() === product._id.toString();
        });
        let newQuantity = 1;
        const updatedCartItems = [...this.cart.items];

        if (cartProductIndex >= 0) {
            newQuantity = this.cart.items[cartProductIndex].quantity + 1;
            updatedCartItems[cartProductIndex].quantity = newQuantity;
        } else {
            updatedCartItems.push({
                productId: new ObjectID(product._id),
                quantity: newQuantity
            });
        }
        const updatedCart = {
            items: updatedCartItems
        };
        const db = getDb();
        return db
            .collection('users')
            .updateOne(
                { _id: new ObjectID(this._id) },
                { $set: { cart: updatedCart } }
            );
    }

    getCart() {
        const db = getDb();
        const productIds = this.cart.items.map(i => {
            return i.productId;
        });
        return db
            .collection('products')
            .find({ _id: { $in: productIds } })
            .toArray()
            .then(products => {
                return products.map(p => {
                    return {
                        ...p,
                        quantity: this.cart.items.find(i => {
                            return i.productId.toString() === p._id.toString();
                        }).quantity
                    };
                });
            });
    }

    deleteItemFromCart(productId) {
        const updatedCartItems = this.cart.items.filter(item => {
            return item.productId.toString() !== productId.toString();
        });
        const db = getDb();
        return db
            .collection('users')
            .updateOne(
                { _id: new ObjectID(this._id) },
                { $set: { cart: { items: updatedCartItems } } }
            );
    }

    addOrder() {
        const db = getDb();
        return this.getCart()
            .then(products => {
                const order = {
                    items: products,
                    user: {
                        _id: new ObjectID(this._id),
                        name: this.name
                    }
                };
                return db.collection('orders').insertOne(order);
            })
            .then(result => {
                this.cart = { items: [] };
                return db
                    .collection('users')
                    .updateOne(
                        { _id: new ObjectID(this._id) },
                        { $set: { cart: { items: [] } } }
                    );
            });
    }

    getOrders() {
        const db = getDb();
        return db
            .collection('orders')
            .find({ 'user._id': new ObjectID(this._id) })
            .toArray();
    }

}

module.exports = User;