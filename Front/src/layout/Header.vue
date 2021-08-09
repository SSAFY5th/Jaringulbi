<template>
  <div
    id="header"
    class="d-flex justify-content-between align-items-center px-3"
    style="width: 100%"
  >
    <div>
      <router-link :to="{ name: 'Home' }">
        <b-img :src="require('@/assets/logo.png')" id="fish"></b-img>
      </router-link>
    </div>
    <div><Search /></div>
  </div>
</template>

<script>
import Search from "@/layout/Search.vue";

export default {
  name: "Header",
  components: {
    Search,
  },
  methods: {},
};
</script>

<style scoped>
#header {
  position: absolute;
  left: 0;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 80px;
  background-color: #fff;
  /* box-shadow: 0 2px 8px #ddd; */
}

#fish {
  height: 44px;
  width: 44px;
  /* left: 21px;
  top: 22px; */
}
</style>

