<template>
  <div>
    <div id="components-demo">
      <button-counter></button-counter>
    </div>
  </div>
</template>

<script>
import Vue from "vue";

const app = Vue.createApp({});

// button-counter라는 새로운 전역 컴포넌트 정의
app.component("button-counter", {
  data() {
    return {
      count: 0,
    };
  },
  template: `
    <button>
      You clicked me {{ count }} times.
    </button>`,
});
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