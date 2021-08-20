<template>
  <div>
    <!-- 글쓰기 헤더 부분 -->
    <div id="post-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div class="">
          <!-- <router-link :to="{ name: 'BuyOrNotDetail', params: { id: post.id }}" class="text-dark"> -->
          <router-link
          :to="{ name: 'BuyOrNotDetail', params: { id: PostContents.id }}"
          class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <!-- <div class="text-center">
          <span>글쓰기</span>
        </div>  -->
        <div class="d-flex">
          <a href="#"
            class="text-secondary text-decoration-none" 
            @click="onUpdatePost">
            수정
          </a>
        </div>
      </div>
    </div>

    <!-- 본문 글쓰기 부분 -->
    <div class="main-content">
      <div class="form-area mt-2">
        <div class="category">
          고민중인 소비를 입력해주세요.
        </div>
        <div class="mb-2">
          <input 
            type="text" class="form-control"
            placeholder="상품명"
            v-model="PostContents.title"
          >
        </div>
        <div class="mb-3">
          <input
            type="text"
            class="form-control form-control-sm"
            placeholder="가격"
            v-model="PostContents.price"
          /> 
        </div>
        <div class="mb-3">
          <textarea
            name="" id=""
            cols="30" rows="12"
            class="form-control"
            placeholder="여기에 고민 중인 이유를 써보세요"
            v-model="PostContents.contents"
          >
          </textarea>
        </div>
        <div class="">
          <input
            type="file"
            id="formFileSm"
            class="form-control form-control-sm"
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "UpdateBuyOrNot",
  data: function () {
    return {      
      PostContents: [],
      title: '',
      contents: '',
      category: 1,
    }
  },
  methods: {
    getPostContents: function () {
      const id = this.$route.params.id
      http.get("buyornot/" + id)
      .then(response => {
        this.PostContents = response.data
        // console.log(response.data)
        // this.user_id = this.$store.state.user.login_id   
      }).catch(err => {
        console.log(err)
      });
    },
    onUpdatePost: function () {
      const id = this.$route.params.id
      let msg = ''
      msg = '제목 또는 내용을 입력해주세요.'
      if (this.PostContents.title.length == 0 || this.PostContents.contents.length == 0)
        alert(msg)

      else
        http.put("buyornot/" + id, {
          title: this.PostContents.title,
          contents: this.PostContents.contents,
          user_id: this.$store.state.user.id,
          category: this.category,
        })
        .then(() => {
          // console.log(response.data)
          this.$router.push({ name: 'BuyOrNotDetail', params: { id: id } })
        }).catch(err => {
          console.log(err)
        });        
    }
  },
  created: function () {
    this.getPostContents()
  }
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
    height: 65px;
    background-color: #fff;
    color: #222;
    box-shadow: 0 2px 8px #ddd;
  }

  .category {
    height: 50px;
    line-height: 50px;
    border-bottom: solid 1px #eee;
  }

</style>