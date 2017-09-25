<template>
  <div class="hello">
    <h1>Any Old Time record store catalog</h1>

    <input v-model="searchTerm" placeholder="Search..." class="form-control">
    <table class="table">
      <thead>
      <tr>
        <th>Artist Name</th>
        <th>Title</th>
        <th>Condition</th>
        <th>Price</th>
      </tr>
      </thead>

      <tr v-for="record of records">
        <td>{{ record.artistName }}</td>
        <td>{{ record.title }}</td>
        <td>{{ record.condition }}</td>
        <td>€ {{ record.priceInEuro }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    data: () => ({
      searchTerm: "",
      records: []
    }),

    watch: {
      searchTerm: function(searchTerm) {
        const baseUrl = "http://localhost:8090";

        axios.get(baseUrl + '/records?q=' + searchTerm)
          .then(response => {
            console.log(response)
            console.log(this.records)
            this.records = response.data
            console.log(this.records)
          })
          .catch(error => {
            console.log(error)
          })
      }
    }
  }
</script>
