<template>

  <ShoppingCartPage/>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import ShoppingCartPage from './components/ShoppingCartPage.vue'

export default {
  name: 'App',
  components: {
    /*HelloWorld,*/ ShoppingCartPage
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
