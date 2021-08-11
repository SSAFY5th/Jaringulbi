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
            <span class="d-inline-block ms-2">{{ user_id }}</span>
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
            {{ title }}
          </div>
          <div class="text-start my-2">
            {{ contents }}
          </div>
          <div class="mb-2">
            <!-- 이미지가 있다면 {{ post.image }}-->
            <img src="https://picsum.photos/392/180" alt="이미지">
          </div>

          <!-- 좋아요, 리플 수 -->
          <div class="text-end text-secondary">
            <div class="d-inline-block me-3">
              <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
              <span>{{ upCount }}</span>
            </div>
            <div class="d-inline-block">
              <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
              <span>{{ commentCount }}</span>
            </div>
          </div>
        </div>
      </div>   

      <div class="comment-wrap">
        <ul v-if="commentList.length" class="p-0">
          <li v-for="comment in commentList" :key="comment.id">
            <Comment 
              :comment="comment"
            />
          </li>
        </ul>
        <p v-else class="mt-4">아직 댓글이 없습니다.</p>
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
import http from "@/util/http-common";

export default {
  name: "Freeboard",
  components: {
    Search,
    Comment,
    CreateComment
  },
  computed: {},
  data () {
    return {
      title: '',
      contents: '',
      user_id: '',
      upCount: '',
      commentCount: '',
      commentList: [],
    };
  },
  methods: {
    // getFreePostList: function () {
    //   http.get("board/")
    //   .then(response => {
    //     console.log(response.data)
    //     this.freePostList = response.data
    //     // context.commit("setFreeboard", response.data);     
    //   }).catch(err => {
    //     console.log(err)
    //   });
    // },
  },
  created: function () {
    const id = this.$route.params.id
    http.get("board/" + id)
      .then(response => {
        console.log(response.data)
        this.title = response.data.title
        this.contents = response.data.contents
        this.user_id = response.data.user_id
        this.commentCount = response.data.commentCount
        this.upCount = response.data.upCount
        this.commentList = response.data.comment
        // this.user_id = this.$store.state.user.login_id
        // context.commit("setFreeboard", response.data);     
      }).catch(err => {
        console.log(err)
      });

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

  .comment-wrap > p {
    color: #999
  }

  .comment-wrap > ul > li {
    list-style: none;
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