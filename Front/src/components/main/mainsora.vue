<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div>
    <div class="row">
      <b-button variant="info" size="lg" @click="go"
        ><b-img :src="require('@/assets/소라고동.jpg')" id="sora"></b-img>선택이
        고민될 땐 무엇이든 !
        <div>마-법의 소라고동</div>
      </b-button>
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
<style>
#sora {
  width: 60px;
  height: 60px;
  border-radius: 100px;
}
</style>