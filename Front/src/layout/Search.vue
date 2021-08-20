<template>
  <div>
    <div class="d-flex search">
      <div class="me-3">
        <router-link :to="{ name: 'Notice' }" class="text-dark">
          <b-icon icon="bell-fill" aria-hidden="false"></b-icon>
        </router-link>
      </div>
      <div>
        <router-link :to="{ name: 'SearchPage' }"  class="text-dark">
          <b-icon icon="search" aria-hidden="false"></b-icon>
        </router-link>
      </div>
    </div>
  </div>
</template>
<script>
// import { mapGetters } from "vuex";
// export default {
//   name: "",
//   computed: {},
//   data() {
//     return {};
//   },
//   created() {},
//   methods: {},
// };
</script>
<style scoped>
  .search {
    font-size: 16pt;
    color: #333;
  }
</style>
