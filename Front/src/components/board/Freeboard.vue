<template>
<div>  
  <div class="post-wrap"  v-for="post in freePostList" :key="post.id">
    <!--  v-for="post in freepost" :key="post.id" -->
    <div class="d-flex justify-content-between align-items-center">
      <div class="d-flex align-items-center">
        <div id="img-circle" class="d-inline-block">
          <img src="https://picsum.photos/48/48" alt="프로필사진">
        </div>      
        <span class="d-inline-block ms-2">{{ post.nickname }}</span>
        
      </div>
        
      <div class="d-inline-block">
        <span class="text-secondary">2시간</span>
        <!-- {{ post.created_time }} -->
      </div>      
    </div>

    <!-- 글 -->

    <router-link
      :to="{ name: 'FreeboardDetail', params: { id: post.id }}"
      class="text-decoration-none text-dark m-0 p-0"
    >    
    <!-- <a href="http://localhost:8080/board/1" class="text-decoration-none text-dark"> -->
      <div class="text-start mt-2">
        <!-- 오늘 완전 득템!! 제목제목 -->
        {{ post.title }}
      </div>
      <div class="text-start my-2">
        {{ post.contents }}
        
      </div>
      <div class="mb-2">
        <!-- 이미지가 있다면 {{ post.image }}-->
        <img src="https://picsum.photos/392/180" alt="프로필사진">
      </div>
    </router-link>

    <!-- 좋아요, 리플 수 -->
    <div class="text-end text-secondary">
      <div class="d-inline-block me-3">
        <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
        <span>{{ post.upCount }}</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
        <span>{{ post.commentCount }}</span>
      </div>
    </div>
  </div> 
</div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "Freeboard",
  components: {
  },
  computed: {},
  data () {
    return {
      freePostList: [],
      username: '',
    };
  },
  methods: {
    getFreePostList: function () {
      http.get("board/")
      .then(response => {
        // console.log(response.data)
        this.freePostList = response.data
        // this.username = this.$store.state.user.login_id
      }).catch(err => {
        console.log(err)
      });
    },
  },
  created: function () {
    this.getFreePostList()
  }
}
</script>

<style scoped>
  .post-wrap {
    padding: 10px 14px 12px 14px;
    border-bottom: solid 1px #eee;
    color: #444;
  }

</style>