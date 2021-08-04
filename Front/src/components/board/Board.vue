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
  height: 85px;
  background-color: #fff;
  box-shadow: 0 2px 8px #ddd;
}

.main-content {  
  margin-top: 85px;
  
}
</style>