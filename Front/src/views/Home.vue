<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div id="font">
    <div id="header" class="">
      <Header></Header>
    </div>
    <div class="main-content">
      <Report></Report>
      <Mainsora></Mainsora>
      
      <div class="">
        <p id="main-title" class="text-start mb-2">커뮤니티</p>
        <div class="mb-4">
          <div class="freeboard">
            <router-link :to="{ name: 'Board' }"
              class="text-decoration-none m-0 p-0"
            >
              <div class="freeboard-btn">
                <b-icon icon="chat-square-text" aria-hidden="false"></b-icon>
              </div>
              <span id="post-content">
                자유게시판
              </span>
            </router-link>
          </div>
          <div class="buyornot">
            <router-link :to="{ name: 'BuyOrNot' }"
              class="text-decoration-none m-0 p-0"
            >
              <div class="buyornot-btn">
                <b-icon icon="cart-x" aria-hidden="false"></b-icon>
              </div>
              <span id="post-content">
                살까말까 게시판
              </span>
            </router-link>
          </div>
        </div>
        <div>
          <div class="d-flex justify-content-between mb-3">
            <span id="main-title" class="align-self-center">챌린지</span>
            <span class="align-self-center">
              <router-link :to="{ name: 'Challenge' }"
              class="text-decoration-none m-0 p-0"
              id="post-upcount"
              >
                전체보기
              </router-link>
            </span>
          </div>
          <div class="mb-3">
            <div class="challeng-btn bg-secondary d-inline-block">
              챌린지
            </div>
            <div class="challeng-btn bg-secondary d-inline-block">
              챌린지
            </div>
            <div class="challeng-btn bg-secondary d-inline-block">
              챌린지
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

// import { mapGetters } from "vuex";
export default {
  name: "Home",
  components: {
    Header,
    Report,
    Mainsora,
  },
  computed: {},
  data() {
    return {};
  },
  methods: {},
};
</script>

<style scoped>
  .main-content {
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

  .challeng-btn {
    width: 124px;
    height: 124px;
    border-radius: 62px;
    line-height: 120px;
  }
</style>