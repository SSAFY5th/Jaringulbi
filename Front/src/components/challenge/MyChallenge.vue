<template>
  <div>
    <div id="challenge-header">
      <CLHeader />
    </div>
    <div class="main-content">
      <div
        class="d-flex summary-box
        align-items-center
        justify-content-evenly"
      >
        <div class="d-inline-block me-5">
          <p id="post-username">챌린지</p>
          <span id="post-title">6개</span>
        </div>
        <div class="d-inline-block">
          <p id="post-username">누적 굴비 수</p>
          <span id="post-title">17개</span>
        </div>
      </div>
    
      <div class="challenge-wrap">
        <!-- MyChallengeList.length -->
        <ul v-if="MyChallengeList" class="p-0">
          <li v-for="myChallenge in myChallengeList" :key="myChallenge.id">
            <MyChallengeList 
              :myChallenge="myChallenge"
              v-on:contents="getMyChallengeList"
            />
          </li>
        </ul>
        <p v-else class="mt-5">아직 참여중인 챌린지가 없습니다.</p>
      </div>
    </div>
  </div>
</template>
<script>
import CLHeader from "@/layout/CL_Header.vue";
import MyChallengeList from "@/components/challenge/MyChallengeList.vue";
import http from "@/util/http-common";

export default {
  name: "MyChallenge",
  components: {
    CLHeader,
    MyChallengeList,
  },
  data () {
    return {
      myChallengeList: [],
    }
  },
  methods: {
    getMyChallengeList: function () {
      http.get("challenge/mychallenge/")
      .then(response => {
        console.log(response.data)
        this.myChallengeList = response.data
        // this.username = this.$store.state.user.login_id
      }).catch(err => {
        console.log(err)
      });
    },
  },
  created() {
    this.getMyChallengeList()
  }
};
</script>
<style scoped>
  #challenge-header {
    position: fixed;
    top: 0;
    z-index: 999;
    display: flex;
    width: 100%;
    max-width: 420px;
    height: 80px;
    background-color: #fff;
    box-shadow: 0 2px 8px #ddd;
  }

  .main-content {
    margin-top: 80px;
    margin-bottom: 60px;
    padding: 15px 14px 12px 14px;
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
    color: #999
  }

  .challenge-wrap > ul > li {
    list-style: none;
  }
</style>