<template>
  <div>
    <div><CLHeader></CLHeader></div>
    <div>모든 챌린지</div>

    <div>
      <ChallengeList
        v-for="(challenge, index) in challenges"
        :key="index"
        :id="challenge.id"
        :start_date="challenge.start_date"
        :end_date="challenge.end_date"
        :contents="challenge.contents"
        :entry_fee="challenge.entry_fee"
        :reward="challenge.reward"
        :image="challenge.image"
        :description:="challenge.description"
      ></ChallengeList>
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
    this.$store.dispatch("getChallengs");
  },
};
</script>
<style>
</style>