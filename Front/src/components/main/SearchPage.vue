<template>
  <div>
    <!-- 헤더 -->
    <div id="search-header">
      <div
        class="d-flex align-self-center px-3"
        style="width: 100%"
      >
        <div class="me-3">
          <router-link :to="{ name: 'Home' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <div class="flex-fill">        
          <input
            type="text"
            name="search"
            class="form-control form-control-sm"
            placeholder="검색어를 입력해주세요"
          >          
        </div>
        <div class="ms-2">
          <a
            href="#"
            class="text-dark text-decoration-none"
          >
          <b-icon icon="search" aria-hidden="false"></b-icon>
          </a>
        </div>
      </div>
    </div>

    <div class="main-content">
      <p id="post-title" class="text-start">인기 검색어</p>
      <div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">짠테크</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">저축</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">주식</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">가계부</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">투자</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">펀딩</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">핫딜</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">비트코인</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">돈</span>
        </div>
        <div class="popular px-3 me-2">
          <span class="m-0 p-0">이벤트</span>
        </div>
      </div>
      <hr>
      <p id="post-title" class="text-start">카테고리</p>
      <div>
        자유게시판 | 살까말까
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchPage",
}
</script>

<style scoped>
  #search-header {
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

  .main-content {
    margin-top: 65px;
    padding: 15px 14px 12px 14px;
    position: relative;
    color: #333;
  }

  .popular {
    height: 36px;
    line-height: 32px;
    background-color: #fff;
    display: inline-block;
    border: solid 1px #ddd;
    border-radius: 18px;
    margin-bottom: 14px;
    cursor: pointer;
  }
</style>