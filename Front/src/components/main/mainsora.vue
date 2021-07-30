<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div>
    <div class="row">
      <b-col lg="4" class="pb-2"></b-col>
      <b-col lg="4" class="pb-2"
        ><b-button variant="info" size="lg" @click="go"
          >소라고동 클릭</b-button
        ></b-col
      >
      <b-col lg="4" class="pb-2"></b-col>
    </div>
  </div>
</template>
<script>
//// import { mapGetters } from "vuex";
export default {
  name: "",
  computed: {},
  data() {
    return {};
  },

  methods: {
    go() {
      this.$router.push("/sora");
    },
  },
};
</script>
<style></style>