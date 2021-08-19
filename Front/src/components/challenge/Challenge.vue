<template>
  <div>
    <div>
      <CLHeader />
    </div>
    <div class="chlg-content">
      <challenge-list
        v-for="(challenge, index) in challenges.data"
        v-bind:key="index"
        :image="challenge.image"
        :title="challenge.title"
        :start_date="challenge.start_date"
        :entry_fee="challenge.entry_fee"
        :reward="challenge.reward"
        :end_date="challenge.end_date"
        :description="challenge.description"
        :id="challenge.id"
      >
      </challenge-list>
    </div>
  </div>
</template>

<script>
import CLHeader from "@/layout/CL_Header.vue";
import ChallengeList from "@/components/challenge/ChallengeList.vue";
import { mapGetters } from "vuex";

export default {
  name: "Challenge",
  components: {
    CLHeader,
    ChallengeList,
  },
  computed: {
    ...mapGetters(["challenges"]),
  },

  created() {
    this.$store.dispatch("getChallenges");
  },
};
</script>

<style scoped>
  .chlg-content {
    padding: 12px 4px 12px 14px;
    position: relative;
    color: #333;    
  }
</style>
