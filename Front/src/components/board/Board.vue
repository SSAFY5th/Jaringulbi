<template>
<!-- 자유게시판의 차지하는 범위:회색 -->
  <div class="">     
    <!-- 자유게시판 헤더 부분 -->
    <div id="board-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div>
          <span>자유게시판 / 살까말까</span> 
        </div> 
        <div>
          <Search />
        </div>
      </div>
    </div>

    <!-- 글 리스트 출력 -->
    <!-- 위에 카테고리 분류(board_category)로 v-if 등으로 카테고리 처리해서 보여주기 -->
    <div class="main-content">
      <!-- 무한 스크롤 구현 -->
      <!-- 글 작성 버튼 -->
      <router-link :to="{ name: 'CreateFreePost' }">
        <div id="write-btn" class="">
          <span>+</span>
        </div>
      </router-link>
      <div>
        <Freeboard />
      </div>
      <div>
        <BuyOrNot />
      </div>
    </div>    
  </div>  
</template>

<script>
import Search from "@/layout/Search.vue";
import Freeboard from "@/components/board/Freeboard.vue";
import BuyOrNot from "@/components/board/BuyOrNot.vue";

export default {
  name: "Board",
  components: {
    Search,
    Freeboard,
    BuyOrNot,
  },
  computed: {},
  data () {
    return {};
  },
  methods: {},
}
</script>

<style scoped>
  #board-header {
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

  #write-btn {
    position: fixed;    
    left: calc(50vw + 120px);
    bottom: 85px;
    z-index: 3;
    width: 60px;
    height: 60px;
    border-radius: 30px;
    background-color: #9be4e4;
    color: #7a69e6;
    font-size: 30pt;
    line-height: 60px;
  }
</style>