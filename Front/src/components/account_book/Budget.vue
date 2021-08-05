<template>
  <div>
    <div><acheader></acheader></div>
    <div>
      <b-card class="float2">
        <b-aspect> 1 </b-aspect>
      </b-card>
      <b-card class="float2">
        <b-aspect> 2 </b-aspect>
      </b-card>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
//// import { mapGetters } from "vuex";
export default {
  components: {
    Acheader,
  },
  name: "",
  computed: {},
  data() {
    return {};
  },
  methods: {},
};
</script>
<style scoped>
.float2 {
  display: inline-block;
  width: 30%;
}
</style>
