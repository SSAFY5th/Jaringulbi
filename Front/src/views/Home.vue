<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div>
    <div id="header">
      <Header></Header>
      <search></search>
    </div>
    <div class="main-content">
      <div><Report></Report></div>
      <div><Mainsora></Mainsora></div>
      <bottom></bottom>
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
#header {
  position: absolute;
  left: 0;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 85px;
  background-color: #fff;
}

.main-content {
  margin-top: 85px;
}

#title {
  text-align: left;
}
</style>