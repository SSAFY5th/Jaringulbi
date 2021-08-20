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

    <div class="chlg-cover-img">
      <img :src="this.image" alt="챌린지 이미지" />
    </div>
    <div class="text-start">
      <div class="chlg-wrap">     
        <div style="font-weight: bold; font-size: 24px;">
          {{ this.$store.state.challenge.title }}
        </div>
        <div class="mt-2" style="color:#7a69e6; font-weight: 600;">
          {{ this.$store.state.challenge.start }}
        </div>
        <div id="post-content"
          style="border-bottom:solid 1px #eee;"
          class="pb-3"
        >
          {{ this.$store.state.challenge.period }} 동안 진행
        </div>
        
        <div class="d-flex align-items-center mt-3">
          <span id="post-upcount" class="me-3">참가인원</span> 
          <span id="post-title">
            {{ this.$store.state.challenge.ChallengeUserNum }} 명
          </span>
        </div>
        <div class="d-flex align-items-center">
          <span id="post-upcount" class="me-4">참가비</span>          
          <span id="post-title">
            {{ this.$store.state.challenge.entry_fee }} 굴비
          </span>          
        </div>
        <div class="d-flex align-items-center pb-3"
          style="border-bottom:solid 1px #ddd;"
        >
          <span id="post-upcount" class="me-4">보상</span>          
          <span id="post-title" style="color:#7a69e6;">
            {{ this.$store.state.challenge.reward }} 굴비
          </span>          
        </div>

        <div class="mt-2 mb-3 chlg-detail-tab">          
          <div class="d-flex justify-content-around">
            <div>
              <span @click="descript" class="">
                상세 설명
              </span>        
            </div>
            <div>
              <span @click="review" class="">
                후기
              </span>          
            </div>
          </div>
        </div>
        <div style="font-size:15px; color: #444;">
          <Description v-show="dshow" />          
          <Review v-show="rshow" />
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

<style scope>
#chlg-header {
  position: fixed;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 65px;
  background-color: #fff;
  color: #222;
  box-shadow: 0 2px 8px #ddd;
}

.chlg-cover-img {
  margin-top: 65px;
  width: 100%;
  height: 260px;
  overflow: hidden;
}

.chlg-cover-img img {
  width:100%;
  height:100%;
  object-fit:cover;
}

.chlg-wrap {
  padding: 10px 14px 12px 14px;
  margin-bottom: 55px;
}

.chlg-detail-tab span {
  font-weight: 600;
  color: #666;
  cursor: pointer;
}

.chlg-detail-tab span:hover {
  color: #7a69e6;
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