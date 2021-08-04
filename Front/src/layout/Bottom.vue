<template>
  <div class="footer">
    <b-button-group id="footer_btn">
      <b-button variant="info" title="가계부" @click="account">
        <b-icon icon="vector-pen" aria-hidden="true"></b-icon>
        <div>가계부</div>
      </b-button>
      <b-button variant="info" title="커뮤니티" @click="community">
        <b-icon icon="facebook" aria-hidden="true"></b-icon>
        <div>커뮤니티</div>
      </b-button>
      <b-button variant="info" title="홈" @click="home">
        <b-icon icon="house-fill" aria-hidden="true"></b-icon>
        <div>메인</div>
      </b-button>
      <b-button variant="info" title="챌린지" @click="challenge">
        <b-icon icon="flag-fill" aria-hidden="true"></b-icon>
        <div>챌린지</div>
      </b-button>
      <b-button variant="info" title="프로필" @click="user">
        <b-icon icon="person" aria-hidden="true"></b-icon>
        <div>프로필</div>
      </b-button>
    </b-button-group>
  </div>
</template>
 
<script>
export default {
  name: "bottom",
  computed: {},
  data() {
    return {};
  },
  methods: {
    user() {
      this.$router.push("/login");
    },
    home() {
      this.$router.push("/");
    },
    account() {
      this.$router.push("/accountbook");
    },
  },
};
</script>
 
<style scoped>
.footer {
  position: fixed;
  bottom: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 65px;
  padding: 0;
  color: white;
}
#footer_btn {
  width: 420px;
}
</style>