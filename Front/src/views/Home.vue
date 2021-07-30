<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div class="row">
    <div class="col-xs-6 col-md-2"></div>
    <div class="col-xs-6 col-md-4">로고</div>
    <div class="col-xs-6 col-md-4">
      <div>
        <div>자린굴비<search></search></div>
      </div>
      <report></report>
      <mainsora></mainsora>
      <div><bottom></bottom></div>
    </div>
    <div class="col-xs-6 col-md-2"></div>
  </div>
</template>
<script>
import Search from "@/layout/Search.vue";
import Bottom from "@/layout/Bottom.vue";
import Report from "@/components/main/report.vue";
import Mainsora from "@/components/main/mainsora.vue";

// import { mapGetters } from "vuex";
export default {
  name: "",
  components: { Search, Bottom, Report, Mainsora },
  computed: {},
  data() {
    return {};
  },
  methods: {},
};
</script>
<style scoped>
#title {
  text-align: left;
}
</style>