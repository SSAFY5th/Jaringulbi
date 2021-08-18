<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div id="font">
    <div id="header" class="bg-light">
      <Header></Header>
    </div>
    <div class="main-content">
      <Report></Report>
      <Mainsora></Mainsora>
      <div class="bg-warning">
        <p id="post-title" class="text-start">커뮤니티</p>
        <div></div>
        <div></div>
        <div>
          <p id="post-title" class="text-start">챌린지</p>
        </div>
      </div>
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
  .main-content {
    padding: 10px 14px 12px 14px;

  }
</style>