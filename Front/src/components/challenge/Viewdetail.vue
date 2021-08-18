<template>
  <div class="detail">
    <div>
      <b-img :src="require('@/assets/소라고동.jpg')" id="image"></b-img>
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
        <b-button class="btn" title="상세 설명" @click="description">
          <div>상세 설명</div>
        </b-button>

        <b-button class="btn" title="후기" @click="review">
          <div>후기</div>
        </b-button>
      </b-button-group>
    </div>
    <div>
      <description :v-show="true"></description
      ><review :v-show="false"></review>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Description from "@/components/challenge/Description.vue";
import Review from "@/components/challenge/Review.vue";

export default {
  name: "Viewdetail",
  computed: {
    ...mapGetters(["challenge"]),
  },
  components: {
    Description,
    Review,
  },
  created() {
    console.log(this.id);
    this.$store.dispatch("getChallenge", { id: this.id });
  },

  data() {
    return {
      id: Number(this.$route.params.id),
      dshow: "true",
      rshow: "false",
      period: "",
      start: "",
      title: "",
      entry_fee: "",
      reward: "",
      description: "",
      ChallengeUserNum: "",
    };
  },
  methods: {
    review() {},
  },
};
</script>

<style>
.detail {
  text-align: left;
}
</style>