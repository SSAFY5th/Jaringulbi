<template>
  <div>
    <div class="post-wrap"  v-for="post in BuynotPostList" :key="post.id">
      <!--  v-for="post in freepost" :key="post.id" -->
      <div class="d-flex justify-content-between align-items-center">
        <div class="d-flex align-items-center">
          <div id="img-circle" class="d-inline-block">
            <img src="https://picsum.photos/48/48" alt="프로필사진">
          </div>      
          <span class="d-inline-block ms-2">{{ post.user_id }}</span>
          
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
      



      <!-- ///////////////////////////////////////////////////// -->
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
        <span>3</span>
      </div>
    </div>
  </div> 

  </div>
</template>

<script>

export default {
  name: "BuyOrNot",
  components: {
  },
  computed: {},
  data () {
    return {};
  },
  methods: {

  },
}
</script>


<style scoped>
  .post-wrap {
    padding: 10px 14px 12px 14px;
    border-bottom: solid 1px #eee;
    color: #444;
  }
</style>