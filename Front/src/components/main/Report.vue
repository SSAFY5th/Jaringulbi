<template>
  <div></div>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },

  methods: {
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    },
  },
};
</script>
<style >
.margin {
  margin: 15px;
}
</style>