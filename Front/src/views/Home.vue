<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div>
    <Header></Header>
    <div class="main-content">
      <div class="report-wrap mb-2 d-flex">
        <!-- justify-content-evenly -->
        <div class="align-self-center report-img">
          <router-link :to="{ name: 'Mypage' }">
            <img alt="프로필" :src="image" id="profile-img" />
          </router-link>
        </div>
        <div class="text-start align-self-center">
          <p class="report-text m-0">이번 주는</p>
          <span class="puple-text">544,350원</span>
          <span class="report-text"> 썼어요</span>
          <p id="post-upcount" class="m-0">8월 1주차 (08.01 ~ 08.07)</p>
        </div>
      </div>
      <Report></Report>

      <div class="main-section-wrap">
        <div class="mb-4">
          <Mainsora></Mainsora>
        </div>
        <p id="main-title" class="text-start mb-2">커뮤니티</p>
        <div class="mb-4">
          <div class="freeboard">
            <router-link
              :to="{ name: 'Board' }"
              class="text-decoration-none m-0 p-0"
            >
              <div class="freeboard-btn">
                <b-icon icon="chat-square-text" aria-hidden="false"></b-icon>
              </div>
              <span id="post-content"> 자유게시판 </span>
            </router-link>
          </div>
          <div class="buyornot">
            <router-link
              :to="{ name: 'BuyOrNot' }"
              class="text-decoration-none m-0 p-0"
            >
              <div class="buyornot-btn">
                <b-icon icon="cart-x" aria-hidden="false"></b-icon>
              </div>
              <span id="post-content"> 살까말까 게시판 </span>
            </router-link>
          </div>
        </div>
        <div>
          <div class="d-flex justify-content-between mb-3">
            <span id="main-title" class="align-self-center">챌린지</span>
            <span class="align-self-center">
              <router-link
                :to="{ name: 'Challenge' }"
                class="text-decoration-none m-0 p-0"
                id="post-upcount"
              >
                전체보기
              </router-link>
            </span>
          </div>
          <div class="d-flex">
            <div
              class="chlg-btn-wrap"
              v-for="challenge in challenges.data.slice(0, 3)"
              :key="challenge.id"
            >
              <div class="challenge-btn d-inline-block">
                <router-link
                  :to="{
                    path: `/challenge/detail/${challenge.id}`,
                    query: { name: challenge.image },
                  }"
                >
                  <img
                    alt="챌린지"
                    class="chlg-img"
                    :src="challenge.image"
                    style="object-fit: cover"
                  />
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "@/layout/Header.vue";
import Report from "@/components/main/Report.vue";
import Mainsora from "@/components/main/Mainsora.vue";
import { mapGetters } from "vuex";

export default {
  name: "Home",
  components: {
    Header,
    Report,
    Mainsora,
  },
  data() {
    return {
      image: this.$store.state.user.image,
      challengesImg: this.chlgImg,
    };
  },
  computed: {
    ...mapGetters(["challenges"]),
  },
  methods: {},
  created() {
    if (!this.$store.state.show) {
      this.$router.push({ name: "Login" });
    }
    this.$store.dispatch("getChallenges");
    let chlgImg = [];
    chlgImg = this.challenges.data;
    chlgImg = chlgImg.slice(0, 3);
    console.log(chlgImg);
  },
};
</script>

<style scoped>
.report-wrap {
  width: 100%;
  height: 180px;
  border-bottom: solid 1px #eee;
}

.report-img {
  width: 40%;
}

.puple-text {
  color: #7a69e6;
  font-weight: 600;
  font-size: 21px;
}

.report-text {
  font-size: 21px;
  /* text-align: left; */
}

.main-section-wrap {
  padding: 10px 14px 12px 14px;
}

.freeboard {
  width: 50%;
  /* background-color: aquamarine; */
  display: inline-block;
}

.freeboard-btn {
  height: 124px;
  margin-right: 5px;
  background-color: #eee;
  cursor: pointer;
  border-radius: 12px;
  line-height: 120px;
  font-size: 30pt;
  /* color: #9be4e4; */
  color: #7a69e6;
}

.freeboard-btn:hover {
  background-color: #9be4e4;
  cursor: pointer;
  color: #fff;
  transition: 800ms cubic-bezier(0.19, 1, 0.22, 1);
}

.buyornot {
  width: 50%;
  display: inline-block;
}

.buyornot-btn {
  height: 124px;
  margin-left: 5px;
  background-color: #eee;
  cursor: pointer;
  border-radius: 12px;
  line-height: 120px;
  font-size: 30pt;
  /* color: #9be4e4; */
  color: #7a69e6;
}

.buyornot-btn:hover {
  background-color: #9be4e4;
  cursor: pointer;
  color: #fff;
  transition: 800ms cubic-bezier(0.19, 1, 0.22, 1);
}

.chlg-btn-wrap {
  width: 33%;
  /* display: inline-block; */
}

.challenge-btn {
  width: 100%;
  max-width: 120px;
  height: 100%;
  max-height: 120px;
  border-radius: 60px;
  /* line-height: 118px;     */
  background-color: #eee;
  overflow: hidden;
}

.chlg-img {
  object-fit: cover;
}
</style>