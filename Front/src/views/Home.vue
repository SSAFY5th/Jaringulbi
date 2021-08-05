<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div>
    <div id="header">
      <Header></Header>
    </div>
    <div class="main-content">
      <Report></Report>
      <Mainsora></Mainsora>
    </div>
  </div>
</template>

<script>
import Header from "@/layout/Header.vue";
import Report from "@/components/main/Report.vue";
import Mainsora from "@/components/main/Mainsora.vue";

// import { mapGetters } from "vuex";
export default {
  name: "Home",
  components: {
    Header,
    Report,
    Mainsora,
  },
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
  /* box-shadow: 0 2px 8px #ddd; */
}

.main-content {
  margin-top: 85px;
}

#title {
  text-align: left;
}
</style>