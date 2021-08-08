<template>
<div>  
  <div class="free-post"><!--  v-for="post in freepost" :key="post.id" -->
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

    <!-- 글 -->
    <a href="http://localhost:8080/board/1" class="text-decoration-none text-dark">
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
        <img src="https://picsum.photos/392/180" alt="프로필사진">
      </div>
    </a>
    <!-- <router-link :to="{ name: 'FreeboardDetail', params: { id: post.id } }"> 각각 pk -->

    <!-- 좋아요, 리플 수 -->
    <div class="text-end text-secondary">
      <div class="d-inline-block me-3">
        <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
        <span>0</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
        <span>1</span>
      </div>
    </div>
  </div>
  <div class="free-post"><!--  v-for="post in freepost" :key="post.id" -->
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

    <!-- 글 -->
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
    <!-- <router-link :to="{ name: 'FreeboardDetail', params: {id: post.id} }"> 각각 pk -->

    <!-- 좋아요, 리플 수 -->
    <div class="text-end text-secondary">
      <div class="d-inline-block me-3">
        <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
        <span>0</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
        <span>1</span>
      </div>
    </div>
  </div>
  <div class="free-post"><!--  v-for="post in freepost" :key="post.id" -->
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

    <!-- 글 -->
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
    <!-- <router-link :to="{ name: 'FreeboardDetail', params: {id: post.id} }"> 각각 pk -->

    <!-- 좋아요, 리플 수 -->
    <div class="text-end text-secondary">
      <div class="d-inline-block me-3">
        <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
        <span>0</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
        <span>1</span>
      </div>
    </div>
  </div>
  <div class="free-post"><!--  v-for="post in freepost" :key="post.id" -->
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

    <!-- 글 -->
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
      <img src="https://picsum.photos/392/150" alt="프로필사진">
    </div>
    <!-- <router-link :to="{ name: 'FreeboardDetail', params: {id: post.id} }"> 각각 pk -->

    <!-- 좋아요, 리플 수 -->
    <div class="text-end text-secondary">
      <div class="d-inline-block me-3">
        <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
        <span>0</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
        <span>1</span>
      </div>
    </div>
  </div>
  <div class="free-post"><!--  v-for="post in freepost" :key="post.id" -->
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

    <!-- 글 -->
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
    <!-- <router-link :to="{ name: 'FreeboardDetail', params: {id: post.id} }"> 각각 pk -->

    <!-- 좋아요, 리플 수 -->
    <div class="text-end text-secondary">
      <div class="d-inline-block me-3">
        <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
        <span>0</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
        <span>1</span>
      </div>
    </div>
  </div>
  <div class="free-post"><!--  v-for="post in freepost" :key="post.id" -->
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

    <!-- 글 -->
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
    <!-- <router-link :to="{ name: 'FreeboardDetail', params: {id: post.id} }"> 각각 pk -->

    <!-- 좋아요, 리플 수 -->
    <div class="text-end text-secondary">
      <div class="d-inline-block me-3">
        <b-icon icon="heart-fill" aria-hidden="false" class="me-2"></b-icon>
        <span>0</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false"  class="me-2"></b-icon>
        <span>1</span>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "Freeboard",
  components: {
  },
  computed: {},
  data () {
    return {
      content: '',
      freePostList: [],
    };
  },
  methods: {
    getFreePostList: function () {
      const url = "http://localhost:80/board"
      axios.get(url)
      .then(response => {
        console.log(response.data)
        this.freePostList = response.data
      }).catch(err => {
        console.log(err)
      })
    },
  },
  created: function () {
    this.getFreePostList()
  }
}
</script>

<style scoped>
  .free-post {
    padding: 10px 14px 12px 14px;
    border-bottom: solid 1px #eee;
    color: #444;
  }

</style>