<template>
  <div>
    <!-- 헤더 부분 -->
    <div id="chlg-header">
      <div
        class="d-flex justify-content-between align-self-center px-3"
        style="width: 100%"
      >
        <div class="">
          <router-link :to="{ name: 'Challenge' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <!-- <div class="text-center">
          <span>글쓰기</span>
        </div> -->
        <!-- <div class="d-flex">
          <a
            href="#"
            class="text-secondary text-decoration-none"
            @click="onCreatePost"
          >
            등록
          </a>
        </div> -->
      </div>
    </div>

    <div class="main-content text-start">
      <div class="chlg-wrap">     
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
      </div>
    </div>    
      <div class="comment-form1" v-if="$store.state.show">
        <ChallengeBottom />
      </div>
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
#chlg-header {
  position: fixed;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 80px;
  background-color: #fff;
  color: #222;
  box-shadow: 0 2px 8px #ddd;
}

.chlg-wrap {
  padding: 10px 14px 12px 14px;
  margin-bottom: 55px;
}

.comment-form1 {
  /* padding: 10px 14px 12px 14px; */
  /* border-top: solid 1px #eee; */
  border-bottom: solid 1px #eee;
  /* background-color: #9be4e4; */
  background-color: #fff;
  position: fixed;
  bottom: 65px;
  z-index: 3;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 58px;
}
</style>