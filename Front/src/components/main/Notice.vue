<template>
  <div>
    <!-- 헤더 -->
    <div id="notice-header">
      <div
        class="d-flex justify-content-between align-self-center px-3"
        style="width: 100%"
      >
        <div class="">
          <router-link :to="{ name: 'Home' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <div class="text-center">
          <span>알림</span>
        </div>
        <div class="d-flex">
          <a
            href="#"
            class="text-secondary text-decoration-none"
          >
            <b-icon icon="trash" aria-hidden="false"></b-icon>
          </a>
        </div>
      </div>
    </div>

    <div class="main-content">
      <router-link
        :to="{ name: 'BuyOrNotDetail', params: { id: 20 }}"
        class="text-decoration-none text-dark m-0 p-0"
      >
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
            <img
              src="https://jaringulbi.s3.ap-northeast-2.amazonaws.com/profile/lsh.jpg"
              alt="프로필 사진"
              class="img-fluid"
            >
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              애옹집사 님이 댓글을 남겼습니다.
            </p>
            <p id="post-content" class="m-0 text-start">5만원이면 무난하죠</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>      
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
            <img
              src="https://jaringulbi.s3.ap-northeast-2.amazonaws.com/profile/seeggp.jpg"
              alt="프로필 사진"
              class="img-fluid"
            >
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              시급좀올려주세요 님이 댓글을 남겼습니다.
            </p>
            <p id="post-content" class="m-0 text-start">어느정도 친한친구인데요?</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
            <img
              src="https://jaringulbi.s3.ap-northeast-2.amazonaws.com/profile/htr.jpg"
              alt="프로필 사진"
              class="img-fluid"
            >
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              서버요정 님이 댓글을 남겼습니다.
            </p>
            <p id="post-content" class="m-0 text-start">생일전에 싸워라</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "Notice",
}
</script>

<style scoped>
  #notice-header {
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
    position: relative;
    color: #333;
  }

  .notice-item {
    padding: 10px 14px 12px 14px;
    width: 100%;
    border-bottom: solid 1px #eee;
    /* text-align: left; */
  }
</style>