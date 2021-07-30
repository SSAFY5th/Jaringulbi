<template>
  <div class="footer">
    <b-button-group>
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
  },
};
</script>
 
<style scoped>
.footer {
  position: absolute;

  left: 0;

  bottom: 0;

  width: 100%;
  margin-left: 270px;
  padding: 15px 0;

  color: white;
}
</style>