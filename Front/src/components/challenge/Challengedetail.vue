<template>
  <div class="detail">
    <div>
      <img alt="list" :src="this.image" id="image" />
    </div>
    <div style="font-weight: bold; font-size: 20pt">
      {{ this.$store.state.challenge.title }}
    </div>
    <div>{{ this.$store.state.challenge.start }}</div>
    <div>{{ this.$store.state.challenge.period }} 동안 진행</div>
    <div>참가인원 {{ this.$store.state.challenge.ChallengeUserNum }}</div>
    <div>참가비 {{ this.$store.state.challenge.entry_fee }}</div>

    <br />
    <div id="acheader">
      <b-button-group id="acbutton">
        <b-button class="btn" title="상세 설명" @click="descript">
          <div>상세 설명</div>
        </b-button>

        <b-button class="btn" title="후기" @click="review">
          <div>후기</div>
        </b-button>
      </b-button-group>
    </div>
    <div>
      <description v-show="dshow"></description><review v-show="rshow"></review>
    </div>
    <div><challenge-bottom class="comment-form1"></challenge-bottom></div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Description from "@/components/challenge/Description.vue";
import Review from "@/components/challenge/Review.vue";
import ChallengeBottom from "@/components/challenge/ChallengeBottom.vue";

export default {
  name: "Viewdetail",
  computed: {
    ...mapGetters(["challenge"]),
  },
  components: {
    Description,
    Review,
    ChallengeBottom,
  },
  created() {
    console.log(this.id);
    this.$store.dispatch("getChallenge", { id: this.id });
  },

  data() {
    return {
      id: Number(this.$route.params.id),
      dshow: true,
      rshow: "",
      period: "",
      start: "",
      title: "",
      entry_fee: "",
      reward: "",
      description: "",
      ChallengeUserNum: "",
      image: this.$route.query.name,
    };
  },
  methods: {
    descript() {
      this.dshow = true;
      this.rshow = false;
    },
    review() {
      this.dshow = false;
      this.rshow = true;
    },
  },
};
</script>

<style>
.detail {
  text-align: left;
}

.comment-form1 {
  padding: 10px 14px 12px 14px;
  border-top: solid 1px #eee;
  border-bottom: solid 1px #eee;
  background-color: #fff;
  position: fixed;
  bottom: 65px;
  z-index: 3;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 60px;
}
</style>