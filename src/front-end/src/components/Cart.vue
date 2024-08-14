<template>
  <div class="container">
    <div class="left-column">
      <h2>Back to shop</h2>
      <hr>
      <h2>Shopping Cart</h2>
      <div v-for="item in cartItems" :key="item.cart_item_id" class="product">
        <img :src="item.imageUrl" alt="Product Image">
        <h2>{{ item.name }}</h2>
        <p>Color: {{ item.color }}</p>
        <h2>{{ item.price }}</h2>
      </div>
    </div>
    <div class="right-column">
      <h2>Cart</h2>
      <hr>
      <h2>Items</h2>
      <div v-for="item in cartItems" :key="'total-' + item.cart_item_id">
        <h2>{{ item.price }}</h2>
      </div>
      <h2>Total Price = {{ totalPrice }}</h2>
      <a href="#" class="cart-button">Checkout Payment</a>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      cartItems: [
        {
          cart_item_id: 1,
          imageUrl: 'ERD.jpg',
          name: 'Stem-chair',
          color: 'Brown',
          price: 'R1 200'
        },
        {
          cart_item_id: 2,
          imageUrl: 'Live_Edge_Mesquite_Slab_Dining_Table_2_large.jpg',
          name: 'Slab Dining Table',
          color: 'Brown',
          price: 'R8 000'
        },
        {
          cart_item_id: 3,
          imageUrl: 'Low-Cost-Wooden-Pallet-Adirondack-Chair.jpg',
          name: 'Pallet Chair',
          color: 'Light Brown',
          price: 'R550'
        }
      ]
    };
  },
  computed: {
    totalPrice() {
      return this.cartItems.reduce((sum, item) => sum + parseFloat(item.price.replace('R', '').replace(',', '')), 0);
    }
  }
};
</script>

<style scoped>
body {
  font-family: 'Arial', sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f0f0f0;
}

.container {
  display: flex;
  justify-content: space-between;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.left-column {
  width: 60%;
  padding: 20px;
  text-align: center;
  font-size: 24px;
}

.right-column {
  width: 30%;
  padding: 20px;
  text-align: center;
  font-size: 24px;
}

.product {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  padding: 20px;
  background-color: #d9d9d9;
  border-radius: 10px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

.product img {
  width: 100px;
  height: 100px;
  background-color: #ccc;
  border-radius: 5px;
}

.product h2 {
  margin: 0;
}

.product p {
  margin: 0;
}

.cart-button {
  display: block;
  margin: 20px auto;
  padding: 10px 20px;
  background-color: #001f3f;
  color: #fff;
  text-decoration: none;
  border-radius: 5px;
}
</style>

