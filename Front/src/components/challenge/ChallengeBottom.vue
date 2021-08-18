<template>
  <div id="bottom">
    <div v-if="$store.state.show">
      <div>
        <b-button @click="join">참가하기</b-button>
        <div></div>
      </div>
    </div>
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

#bottom {
  position: fixed;
  width: 100%;
  height: 65px;
}
</style>