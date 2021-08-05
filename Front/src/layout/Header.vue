<template>
  <div
    class="d-flex justify-content-between align-self-center px-3"
    style="width: 100%"
  >
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
</style>

