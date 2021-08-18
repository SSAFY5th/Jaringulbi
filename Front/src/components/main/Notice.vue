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
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              어쩌구 님이 뭐했어요!
            </p>
            <p id="post-content" class="m-0 text-start">너무 귀여워용</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              어쩌구 님이 뭐했어요!
            </p>
            <p id="post-content" class="m-0 text-start">너무 귀여워용</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              어쩌구 님이 뭐했어요!
            </p>
            <p id="post-content" class="m-0 text-start">너무 귀여워용</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              어쩌구 님이 뭐했어요!
            </p>
            <p id="post-content" class="m-0 text-start">너무 귀여워용</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              어쩌구 님이 뭐했어요!
            </p>
            <p id="post-content" class="m-0 text-start">너무 귀여워용</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
      <div class="notice-item">
        <div class="d-flex align-items-center">        
          <div id="img-circle" class="bg-secondary">
          </div>
          <div class="ms-3">
            <p id="post-title" class="p-0 my-1">
              어쩌구 님이 뭐했어요!
            </p>
            <p id="post-content" class="m-0 text-start">너무 귀여워용</p>
          </div>
        </div>
        <span id="post-time" class="text-center">
          여기를 눌러 댓글을 확인해보세요.
        </span>
      </div>
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
    height: 80px;
    background-color: #fff;
    color: #222;
    box-shadow: 0 2px 8px #ddd;
  }
  
  .main-content {
    margin-top: 80px;
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