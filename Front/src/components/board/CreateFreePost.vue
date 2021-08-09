<template>
  <div>
    <!-- 글쓰기 헤더 부분 -->
    <div id="post-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div class="">
          <router-link :to="{ name: 'Board' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <div class="text-center">
          <span>글쓰기</span>
        </div> 
        <div class="d-flex">
          <a href="#"
            class="text-secondary text-decoration-none" 
            @click="onCreatePost">
            등록
          </a>
        </div>
      </div>
    </div>

    <!-- 본문 글쓰기 부분 -->
    <div class="main-content">
      <div class="free-post-form pt-2">
        <div class="category">
          자유게시판
        </div>
        <div>
          <input 
            type="text" class="form-control"
            placeholder="제목"
          >
        </div>
        <br />
        <div>
          <textarea
            name="" id=""
            cols="30" rows="20"
            class="form-control"
            placeholder="여기에 당신의 이야기를 써보세요"  
          >

          </textarea>
        </div>
          <!-- <label for="id">ID</label>
          <input type="text" id="id" name="id" v-model="id" ref="id" />
          <br />
          <label for="name">이름</label>
          <input
            type="text"
            id="name"
            name="name"
            v-model="name"
            ref="name"
          /><br />          -->
          <label for="address">태그 입력 부분</label><br />
          <input
            type="text"
            id="address"
            name="address"
            v-model="address"
            ref="address"
          /><br />
          <!-- <button @click="checkValue" class="btn" id="btn_group">가입</button>
          <button @click="home" class="btn" id="btn_group">홈으로</button> -->
        </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "CreateFreePost",
  data: function () {
    return {
      category: '',
      title: '',
      contents: '',
      user_id: '',
    }
  },
  methods: {
    onCreatePost: function () {
      http.post("/board", {        
        category: this.category,
        title: this.title,
        contents: this.contents,
        user_id: this.user_id,
      })
      .then(response => {
        console.log(response.data)
        // this.freePostList = response.data
        this.$router.push({ name: 'Board' })
      }).catch(err => {
        console.log(err)
      });        
    }
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
    height: 80px;
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