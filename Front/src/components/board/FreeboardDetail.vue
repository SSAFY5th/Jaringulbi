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
            <!-- -->
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
            {{ title }}
          </div>
          <div class="text-start my-2">
            {{ contents }}
             nisi perspiciatis impedit.
          </div>
          <div class="mb-2">
            <!-- 이미지가 있다면 {{ post.image }}-->
            <img src="https://picsum.photos/392/180" alt="이미지">
          </div>
        </div>
      </div>   

      <div class="comment-wrap">
        <Comment />
      </div>

      <div class="comment-form">
        <CreateComment />
      </div>


    </div>    
  </div>
</template>

<script>
import Search from "@/layout/Search.vue";
import Comment from "@/components/board/comment/Comment.vue";
import CreateComment from "@/components/board/comment/CreateComment.vue";

export default {
  name: "Freeboard",
  components: {
    Search,
    Comment,
    CreateComment
  },
  computed: {},
  data () {
    return {};
  },
  methods: {},
  created: function () {
    // const post.id = this.$route.params.id
  }
}
</script>


<style scoped>
  .post-detail {
    padding: 10px 14px 12px 14px;
    border-bottom: solid 1px #eee;
    color: #444;    
  }

  .comment-wrap {
    margin-bottom: 59px;
  }

  .comment-form {    
    padding: 10px 14px 12px 14px;
    border-top: solid 1px #eee;
    border-bottom: solid 1px #eee;
    background-color: #fff;
    position: fixed;
    bottom: 65px;
    z-index: 3;
    display: flex;
    width: 100%;
    max-width: 420px;
    height: 60px;
  }
</style>