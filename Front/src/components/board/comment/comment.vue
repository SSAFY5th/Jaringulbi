<template>
  <div>
    <!-- 리플 출력부분 -->
      <div class="post-comment">
        <!-- 리플 작성자 이름 -->
        <div class="d-flex">
          <div id="img-circle" class="bg-warning" style="width:48px;">
            <img src="https://picsum.photos/48/48" alt="프로필사진">
          </div>

          <div class="ms-2 flex-fill">
            <div class="d-flex justify-content-between">
              <span>작성자 이름</span>
              <!-- {{ comment.user_id }} -->
              <span class="text-secondary">1시간</span>
              <!-- {{ comment.created_time }} -->
            </div>            
            <!-- 리플 내용 -->
            <div class="mt-1">
              Lorem, ipsum dolor Maxime, odit sit animi.
              <!-- {{ comment.contents }} -->
            </div>
          </div>
        </div>
      </div>
      <div class="post-comment">
        <!-- 리플 작성자 이름 -->
        <div class="d-flex">
          <div id="img-circle" class="bg-warning" style="width:48px;">
            <img src="https://picsum.photos/48/48" alt="프로필사진">
          </div>

          <div class="ms-2 flex-fill">
            <div class="d-flex justify-content-between">
              <span>작성자 이름</span>
              <!-- {{ comment.user_id }} -->
              <span class="text-secondary">45분</span>
              <!-- {{ comment.created_time }} -->
            </div>            
            <!-- 리플 내용 -->
            <div class="mt-1">
              잘 보고 갑니다
              <!-- {{ comment.contents }} -->
            </div>
          </div>
        </div>
      </div>
      <div class="post-comment">
        <!-- 리플 작성자 이름 -->
        <div class="d-flex">
          <div id="img-circle" class="bg-warning" style="width:48px;">
            <img src="https://picsum.photos/48/48" alt="프로필사진">
          </div>

          <div class="ms-2 flex-fill">
            <div class="d-flex justify-content-between">
              <span>작성자 이름</span>
              <!-- {{ comment.user_id }} -->
              <span class="text-secondary">30분</span>
              <!-- {{ comment.created_time }} -->
            </div>            
            <!-- 리플 내용 -->
            <div class="mt-1">
              Lorem, ipsum dolor Maxime, odit sit anwqkdoem, ipsum dolor Maxime, odit sit animi.
              <!-- {{ comment.contents }} -->
            </div>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: "Comment",
}
</script>

<style scoped>
  .post-comment {
    padding: 10px 14px 12px 14px;
    width: 100%;
    border-bottom: solid 1px #eee;
    text-align: left;
  }
</style>