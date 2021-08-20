<template>
  <div>
    <div>
      <CLHeader />
    </div>
    <div class="mychlg-content">
      <div class="d-flex summary-box align-items-center justify-content-evenly">
        <div class="d-inline-block me-5">
          <p id="post-username">챌린지</p>
          <span id="post-title"
            >{{ this.$store.state.myChallenge.length }}개</span
          >
        </div>
        <div class="d-inline-block">
          <p id="post-username">누적 굴비 수</p>
          <span id="post-title">{{ this.$store.state.user.fish_count }}개</span>
        </div>
      </div>

      <div class="challenge-wrap">
        <!-- MyChallengeList.length -->
        <my-challenge-list
          v-for="(challenge, index) in myChallenge"
          :key="index"
          :image="challenge.image"
          :title="challenge.title"
          :start_date="challenge.start_date"
          :entry_fee="challenge.entry_fee"
          :reward="challenge.reward"
          :end_date="challenge.end_date"
          :description="challenge.description"
          :id="challenge.id"
          :status="challenge.status"
        >
        </my-challenge-list>
      </div>
    </div>
  </div>
</template>
<script>
import CLHeader from "@/layout/CL_Header.vue";
import MyChallengeList from "@/components/challenge/MyChallengeList.vue";
import http from "@/util/http-common";
import { mapGetters } from "vuex";

export default {
  name: "MyChallenge",
  components: {
    CLHeader,
    MyChallengeList,
  },
  computed: {
    ...mapGetters(["myChallenge"]),
  },

  created() {
    const check = this.$store.state.myChallenge.id;
    const id = this.$store.state.user.id;
    this.$store.dispatch("getmyChallenge", { id: id });
    console.log(check);
  },
  data() {
    return {};
  },
  methods: {
    getMyChallengeList: function () {
      http
        .get("challenge/mychallenge/")
        .then((response) => {
          console.log(response.data);
          this.myChallengeList = response.data;
          // this.username = this.$store.state.user.login_id
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>
<style scoped>
.mychlg-content {
  margin-bottom: 60px;
  padding: 15px 14px 12px 14px;
  margin-top: 65px;
  position: relative;
  color: #333;
}

.summary-box {
  width: 100%;
  height: 120px;
  border: solid 1px #eee;
}

.challenge-wrap {
  border-bottom: solid 1px #eee;
  /* color: #444; */
}

.challenge-wrap > p {
  color: #999;
}

.challenge-wrap > ul > li {
  list-style: none;
}
</style>