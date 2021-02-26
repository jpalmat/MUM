const { ObjectID } = require('mongodb');
const getDb = require('../util/database').getDb;

class Product {
  constructor(_id, title, imageUrl, price, description, userId) {
    this._id = _id;
    this.title = title;
    this.imageUrl = imageUrl;
    this.price = price;
    this.description = description;
    this.userId = userId;
  }

  save() {
    const _db = getDb();
    return _db.collection('products')
      .insertOne(this);
  }

  update() {
    const _db = getDb();
    console.log(this, '++++');
    // return _db.collection('products').findOneAndUpdate({ _id: new ObjectID(this._id)}, { $set: { title: this.title, imageUrl: this.imageUrl, price: this.price, description: this.description } });
    return _db.collection('products').updateOne({ _id: new ObjectID(this._id) }, { $set: { title: this.title, imageUrl: this.imageUrl, price: this.price, description: this.description } });
  }

  static fetchAll() {
    const _db = getDb();
    return _db.collection('products')
      .find()
      .toArray();
  }

  static findById(prodId) {
    const _db = getDb();
    return _db.collection('products').findOne({ _id: new ObjectID(prodId) });
  }

  static deleteById(prodId) {
    const _db = getDb();
    return _db.collection('products').findOneAndDelete({ _id: new ObjectID(prodId) });
  }

};

module.exports = Product;