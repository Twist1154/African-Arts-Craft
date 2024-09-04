<template>
  <div class="cart-container">
    <!-- Back to Shop Button -->
    <div class="header">
      <button @click="goBack" class="back-button">← Back to Shop</button>
      <h1>Shopping Cart</h1>
    </div>

    <!-- Cart Items -->
    <div class="cart-items">
      <div v-for="product in products" :key="product.id" class="cart-item">
        <img :src="product.image" :alt="product.name"/>
        <div class="item-details">
          <h2>{{ product.name }}</h2>
          <p>{{ product.color }}</p>
          <h3>{{ formatPrice(product.price) }}</h3>
        </div>
        <button @click="removeItem(product.id)" class="remove-button">✖</button>
      </div>
    </div>

    <!-- Cart Summary -->
    <div class="cart-summary">
      <h2>Cart Summary</h2>
      <div v-for="product in products" :key="product.id" class="summary-item">
        <span>{{ product.name }}</span>
        <span>{{ formatPrice(product.price) }}</span>
      </div>
      <div class="total-price">
        <span>Total:</span>
        <span>{{ formatPrice(totalPrice) }}</span>
      </div>
      <button class="checkout-button">Proceed to Checkout</button>
    </div>
  </div>
</template>

<script>
import Live_Edge_Mesquite_Slab_Dining_Table_2_large from "@/assets/Live_Edge_Mesquite_Slab_Dining_Table_2_large.webp";
import Low_Cost_Wooden_Pallet_Adirondack_Chair from "@/assets/Low_Cost_Wooden_Pallet_Adirondack_Chair.webp";
import woodChair from "@/assets/woodChair.jpg";

export default {
  data() {
    return {
      products: [
        {
          id: 1,
          name: "Stem-chair",
          color: "Brown",
          price: 1200,
          image: woodChair,
        },
        {
          id: 2,
          name: "Slab Dining Table",
          color: "Brown",
          price: 8000,
          image: Live_Edge_Mesquite_Slab_Dining_Table_2_large,
        },
        {
          id: 3,
          name: "Pallet Chair",
          color: "Light Brown",
          price: 550,
          image: Low_Cost_Wooden_Pallet_Adirondack_Chair,
        },
      ],
    };
  },
  computed: {
    totalPrice() {
      return this.products.reduce((total, product) => total + product.price, 0);
    },
  },
  methods: {
    formatPrice(price) {
      return `R${price.toFixed(2)}`;
    },
    removeItem(productId) {
      this.products = this.products.filter(product => product.id !== productId);
    },
    goBack() {
      // a logic method to apply when going back to the shop page
    },
  },
};
</script>

<style scoped>

.cart-container {
  display: flex;
  flex-direction: column;
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fafafa;
  border-radius: 10px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

/* Header */
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding-bottom: 20px;
  border-bottom: 1px solid #ddd;
}

.back-button {
  background-color: #1e90ff;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.back-button:hover {
  background-color: #007acc;
}

h1 {
  font-size: 32px;
  color: #333;
}

/* Cart Items */
.cart-items {
  margin: 20px 0;
}

.cart-item {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 15px;
  padding: 15px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
}

.cart-item img {
  width: 100px;
  height: 100px;
  border-radius: 10px;
  margin-right: 20px;
}

.item-details {
  flex-grow: 1;
}

.item-details h2 {
  font-size: 24px;
  margin: 0 0 5px;
  color: #333;
}

.item-details p {
  font-size: 16px;
  color: #777;
}

.item-details h3 {
  font-size: 20px;
  color: #555;
}

.remove-button {
  background-color: transparent;
  border: none;
  font-size: 24px;
  color: #ff4d4d;
  cursor: pointer;
  transition: color 0.3s;
}

.remove-button:hover {
  color: #ff1a1a;
}

/* Cart Summary */
.cart-summary {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
}

.cart-summary h2 {
  font-size: 28px;
  margin-bottom: 20px;
  color: #333;
}

.summary-item {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
  font-size: 18px;
  color: #555;
}

.total-price {
  display: flex;
  justify-content: space-between;
  font-size: 24px;
  margin-top: 20px;
  color: #333;
  font-weight: bold;
}

.checkout-button {
  display: block;
  width: 100%;
  padding: 15px;
  margin-top: 20px;
  background-color: #28a745;
  color: #fff;
  text-align: center;
  border: none;
  border-radius: 5px;
  font-size: 20px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.checkout-button:hover {
  background-color: #218838;
}
</style>


