<template>
  <div>
    <div class="post-wrap"  v-for="post in buynotPostList" :key="post.id">
      <!--  v-for="post in freepost" :key="post.id" -->
      <div class="d-flex justify-content-between align-items-center">
        <div class="d-flex align-items-center">
          <div id="img-circle" class="d-inline-block">
            <img src="https://picsum.photos/48/48" alt="프로필사진">
          </div>      
          <span class="d-inline-block ms-2" id="post-username">
            {{ post.nickname }}
          </span>          
        </div>          
        <div class="d-inline-block">
          <span id="post-time">2시간</span>
          <!-- {{ post.created_time }} -->
        </div>      
      </div>

      <!-- 글 -->
      <router-link
        :to="{ name: 'BuyOrNotDetail', params: { id: post.id }}"
        class="text-decoration-none text-dark m-0 p-0"
      > 
      <!-- ///////////////////////////////////////////////////// -->
        <div class="my-2" id="receipt-wrap">
          <p id="post-title" class="mt-3">RECEIPT</p>
          <hr class="mx-2">
          <div class="text-start ms-3" id="post-title">
            <!-- 제목 -->
            {{ post.title }}
          </div>
          <div class="text-start mt-1 ms-3" id="post-content">
            {{ post.contents }}        
          </div>
          <hr class="mx-2">
          <div class="text-start ms-3 mb-3">
            <span id="post-content">Total.</span>
            <span id="post-title"> {{ post.price }} 원</span>
          </div>
          <div>
            <!-- 이미지가 있다면 {{ post.image }}-->
            <img src="https://picsum.photos/392/180" alt="이미지">
          </div>
        </div>
    </router-link>

    <!-- 좋아요, 리플 수 -->
    <div class="text-end" id="post-upcount">
      <div class="d-inline-block me-3">
        <b-icon icon="hand-thumbs-up" aria-hidden="false" class="me-2"></b-icon>
        <span>{{ post.upCount }}</span>
      </div>
      <div class="d-inline-block me-3">
        <b-icon icon="hand-thumbs-down" aria-hidden="false" class="me-2"></b-icon>
        <span>{{ post.downCount }}</span>
      </div>
      <div class="d-inline-block">
        <b-icon icon="chat-left" aria-hidden="false" class="me-2"></b-icon>
        <span>{{ post.commentCount }}</span>
      </div>
    </div>
  </div> 

  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "BuyOrNot",
  components: {
  },
  data () {
    return {
      buynotPostList: [],
      username: '',
    };
  },
  methods: {
    getBuynotPostList: function () {
      http.get("buyornot/")
      .then(response => {
        console.log(response.data)
        this.buynotPostList = response.data
        // this.username = this.$store.state.user.login_id
      }).catch(err => {
        console.log(err)
      });
    },
  },
  created: function () {
    this.getBuynotPostList()
  }
}
</script>


<style scoped>
  .post-wrap {
    padding: 10px 14px 12px 14px;
    border-bottom: solid 1px #eee;
    color: #444;
  }
  
  #receipt-wrap {
    border: solid 1px #ccc;
    overflow: hidden;
  }
</style>