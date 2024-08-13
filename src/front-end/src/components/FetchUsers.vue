<template>
  <div>
    <h1>User Information</h1>
    <div>
      <button @click="fetchUsers">Fetch Users</button>
    </div>
    <div id="user-list">
      <div v-for="user in users" :key="user.user_id">
        <p><strong>ID:</strong> {{ user.user_id }}</p>
        <p><strong>Username:</strong> {{ user.username }}</p>
        <p><strong>Email:</strong> {{ user.email }}</p>
        <p><strong>First Name:</strong> {{ user.first_name }}</p>
        <p><strong>Last Name:</strong> {{ user.last_name }}</p>
        <p><strong>Created At:</strong> {{ user.created_at }}</p>
        <p><strong>Updated At:</strong> {{ user.updated_at }}</p>
        <hr>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      users: []
    };
  },
  methods: {
    async fetchUsers() {
      try {
        const response = await fetch('/store/api/users');
        if (!response.ok) {
          throw new Error('Network response was not ok ' + response.statusText);
        }
        const users = await response.json();
        this.users = users;
      } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
      }
    }
  }
};
</script>

<style scoped>

</style>
