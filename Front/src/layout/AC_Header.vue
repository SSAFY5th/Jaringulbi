<template>
  <div>
    <router-view />
    <div id="acheader">
      <div>
        <b-nav tabs fill>
          <b-nav-item
            ><router-link to="/account">가계부</router-link></b-nav-item
          >
          <b-nav-item><router-link to="/budget">예산</router-link></b-nav-item>
          <b-nav-item><router-link to="graph">통계</router-link></b-nav-item>
        </b-nav>
      </div>
    </div>
  </div>
</template>
 
<script>
export default {
  name: "Acheader",
  computed: {},
  data() {
    return {};
  },
  methods: {
    account() {
      this.$router.push("/account");
    },
    budget() {
      this.$router.push("/budget");
    },
    graph() {
      this.$router.push("/graph");
    },
  },
};
</script>
<style scoped>
</style>