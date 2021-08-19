<template>
  <div>
    <div v-html="description"></div>
  </div>
</template>

<script>
export default {
  computed: {
    description() {
      return this.$store.state.challenge.description.replaceAll("#", "<br>");
    },
  },

  data() {
    return {};
  },
};
</script>

<style>
</style>