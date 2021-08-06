<template>
  <div>
    <!-- 헤더 부분 -->
    <div id="post-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div>
          <router-link :to="{ name: 'Board' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <div>
          <Search />
          <!-- <span class="text-secondary">등록</span> -->
        </div>
      </div>
    </div>

    <div class="main-content">
      <!-- 글 본문 -->
      <div class="post-detail">
        <!-- 작성자 이름 -->
        <div class="d-flex justify-content-between align-items-center">
          <div class="d-flex align-items-center">
            <div id="img-circle" class="d-inline-block">
              <img src="https://picsum.photos/48/48" alt="프로필사진">
            </div>      
            <span class="d-inline-block ms-2">작성자 이름</span>
            <!-- {{ post.user_id }} -->
          </div>
            
          <div class="d-inline-block">
            <span class="text-secondary">2시간</span>
            <!-- {{ post.created_time }} -->
          </div>      
        </div>
        <!-- 내용 -->
        <div>
          <div class="text-start mt-2">
            오늘 완전 득템!! 제목제목
            <!-- {{ post.title }} -->
          </div>
          <div class="text-start my-2">
            <!-- {{ post.contents }} -->
            Lorem, ipsum dolor sit amet consectetur adipisicing elit.
            Quod nihil error maiores unde aliquid delectus fugit! Maiores facere,
            ab voluptatum,vero ut eos optio sit nisi perspiciatis impedit.
          </div>
          <div class="mb-2">
            <!-- 이미지가 있다면 {{ post.image }}-->
            <img src="https://picsum.photos/392/180" alt="이미지">
          </div>
        </div>
      </div>

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
              Lorem, ipsum dolor Maxime, odit sit animi.
              <!-- {{ comment.contents }} -->
            </div>
          </div>
        </div>
      </div>

    </div>    
  </div>
</template>

<script>
import Search from "@/layout/Search.vue";

export default {
  name: "Freeboard",
  components: {
    Search
  },
  computed: {},
  data () {
    return {};
  },
  methods: {},
}
</script>


<style scoped>
  .post-detail {
    padding: 10px 14px 12px 14px;
    border-bottom: solid 1px #eee;
    color: #444;
  }

  .post-comment {
    padding: 10px 14px 12px 14px;
    width: 100%;
    border-bottom: solid 1px #eee;
    text-align: left;
  }
</style>