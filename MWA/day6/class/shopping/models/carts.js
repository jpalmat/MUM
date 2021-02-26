let cart = null;

module.exports = class Cart {
    static save(product) {
        console.log('the product is ' +product);
        if(cart) { //cart not null
            const existingproductIndex = cart.products.findIndex(p => p.id == product.id); //try check product is existing in cart
            
            if(existingproductIndex>0) {
                const existingProduct = cart.products[existingproductIndex];
                existingProduct.qty+= 1;
                cart.totalPrice+=product.price;
            } else { //no exist
                product.qty = 1;
                cart.products.push(product);
                cart.totalPrice += product.price;
            }
        } else { //cart null
            cart = {products: [], totalPrice: 0};
            product.qty = 1;
            cart.products.push(product);
            cart.totalPrice = product.price;
        }
    }

    static getCart(){
        return cart;
    }

    static delete(productid) {
        const products = cart.products;
        const isExisting = products.findIndex(p => p.id == productid);
        if(isExisting > 0) {
            products.splice(isExisting, 1);
        }
    }
}