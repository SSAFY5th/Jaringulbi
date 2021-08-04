<template>
  <div>
    <!-- 글쓰기 헤더 부분 -->
    <div id="post-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div>
          <router-link :to="{ name: 'Board' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <div>
          <span>글쓰기</span>
        </div> 
        <div>
          <span class="text-secondary">등록</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CreateFreePost",
}
</script>

<style>
  #post-header {
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

</style>