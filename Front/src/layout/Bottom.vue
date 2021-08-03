<template>
  <div class="d-flex justify-content-between px-5" id="nav-icon">
    <div>
      <router-link :to="{ name: 'Accountbook' }" class="text-dark">
        <b-icon icon="vector-pen" aria-hidden="true"></b-icon>
      </router-link>      
    </div>
    <div>
      <router-link :to="{ name: 'Board' }" class="text-dark">
        <b-icon icon="facebook" aria-hidden="true"></b-icon>       
      </router-link>
    </div>
    <div>
      <router-link :to="{ name: 'Home' }" class="text-dark">
        <b-icon icon="house-fill" aria-hidden="true"></b-icon>
      </router-link>
    </div>
    <div>
      <router-link :to="{ name: 'Challenge' }" class="text-dark">
        <b-icon icon="flag-fill" aria-hidden="true"></b-icon>
      </router-link>
    </div>
    <div>
      <router-link :to="{ name: 'Login' }" class="text-dark">
        <b-icon icon="person" aria-hidden="true"></b-icon>
      </router-link>
    </div>
  </div>
</template>
 
<script>
export default {
  name: "Bottom",
  computed: {},
  data() {
    return {};
  },
  methods: {
    user() {
      this.$router.push("/login");
    },
    home() {
      this.$router.push("/");
    },
  },
};
</script>
 
<style scoped>
#nav-icon {
  width: 100%;
  font-size: 16pt;
}
</style>