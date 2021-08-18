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
    <div>{{ this.$store.state.challenge.description }}</div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Viewdetail",
  computed: {
    ...mapGetters(["challenge"]),
  },

  created() {
    console.log(this.id);
    this.$store.dispatch("getChallenge", { id: this.id });
  },

  data() {
    return {
      id: Number(this.$route.params.id),
      period: "",
      start: "",
      title: "",
      entry_fee: "",
      reward: "",
      description: "",
      ChallengeUserNum: "",
    };
  },
  methods: {},
};
</script>

<style>
.detail {
  text-align: left;
}
</style>