<template>
  <tiny-slider :mouse-drag="true" :loop="false" items="2" gutter="20">
    <div>Slider item #1</div>
    <div>Slider item #2</div>
    <div>Slider item #3</div>
    <div>Slider item #4</div>
    <div>Slider item #5</div>
    <div>Slider item #6</div>
  </tiny-slider>
</template>

<script>
import VueTinySlider from "vue-tiny-slider";
export default {
  components: {
    "tiny-slider": VueTinySlider,
  },
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
<style>
.margin {
  margin: 15px;
}
</style>