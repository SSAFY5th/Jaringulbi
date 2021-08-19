<template>
  <div class="participate-btn" @click="join">
    <p>참가하기</p>
  </div>
</template>

<script>
// import http from "@/util/http-common";

export default {
  name: "challenge-bottom",
  props: {
    id: {
      type: Number,
    },
  },
  components: {},
  data() {
    return {
      challenge_id: Number(this.$route.params.id),
      user_id: this.$store.state.user.id,
    };
  },

  methods: {
    join() {
      this.$store.dispatch("enter", {
        challenge_id: this.challenge_id,
        user_id: this.user_id,
      });

      alert("참가가 완료되었습니다!");
    },
  },
};
</script>

<style scoped>
.mint-btn {
  background-color: #9be4e4;
  color: #7a69e6;
}
.mint-btn:hover {
  background-color: #9be4e4;
  color: #fff;
}

.participate-btn {
  /* display: flex; */
  width: 100%;
  max-width: 420px;
  height: 58px;
  cursor: pointer;
  text-align: center;
  background-color: #9be4e4;
  color: #fff;
  font-weight: 600;
  font-size: 19px;
  line-height: 54px;
  text-align: center;
}
</style>