<template>
<!-- 자유게시판의 차지하는 범위:회색 -->
  <div class="">     
    <!-- 자유게시판 헤더 부분 -->
    <div id="board-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div>
          <span>카테고리</span>
          <b-dropdown size="sm" 
              variant="link" class="p-0" right
              toggle-class="text-decoration-none"              
              no-caret
            >
              <template #button-content>
                <b-icon icon="chevron-down" aria-hidden="true"
                  class="text-secondary"></b-icon>
              </template>
              <b-dropdown-item>               
                자유게시판
              </b-dropdown-item>
              <b-dropdown-item @click="goBuyOrNot">
                살까말까 게시판
              </b-dropdown-item>
            </b-dropdown>
        </div> 
        <div>
          <Search />
        </div>
      </div>
    </div>

    <!-- 글 리스트 출력 -->
    <div class="main-content">
      <!-- 무한 스크롤 구현 -->
      <div>
        <!-- 글 작성 버튼 -->
        <router-link :to="{ name: 'CreateFreePost' }">
          <div id="write-btn" class="">
            <span>+</span>
          </div>
        </router-link>
        <Freeboard />
      </div>      
    </div>    
  </div>  
</template>

<script>
import Search from "@/layout/Search.vue";
import Freeboard from "@/components/board/Freeboard.vue";

export default {
  name: "Board",
  components: {
    Search,
    Freeboard,
  },
  computed: {},
  data () {
    return {
      category: '자유게시판',
    };
  },
  methods: {
    goBuyOrNot() {
      this.$router.push({ name: "BuyOrNot" });
    },
  },
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
    color: #fff;
    font-size: 30pt;
    line-height: 56px;
    box-shadow: 2px 2px 6px #ccc;
  }
</style>