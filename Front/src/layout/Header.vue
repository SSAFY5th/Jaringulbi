<template>
  <div
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
#fish {
  height: 44px;
  width: 44px;
  /* left: 21px;
  top: 22px; */
}
</style>

