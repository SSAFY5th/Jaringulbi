<template>
  <div>
    <!-- 글쓰기 헤더 부분 -->
    <div id="post-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div class="">
          <!-- <router-link :to="{ name: 'FreeboardDetail', params: { id: post.id }}" class="text-dark"> -->
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
            @click="onUpdatePost">
            수정
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
            v-model="title"
          >
        </div>
        <br />
        <div>
          <textarea
            name="" id=""
            cols="30" rows="20"
            class="form-control"
            placeholder="여기에 당신의 이야기를 써보세요"  
            v-model="contents"
          >
          </textarea>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "UpdateFreePost",
  data: function () {
    return {
      title: '',
      contents: '',
      category: 1,
    }
  },
  methods: {
    onUpdatePost: function () {
      const id = this.$route.params.id
      let msg = ''
      msg = '제목 또는 내용을 입력해주세요.'
      if (this.title.length == 0 || this.contents.length == 0)
        alert(msg)

      else
        http.put("board/" + id, {        
          // category: this.category,
          title: this.title,
          contents: this.contents,
          user_id: this.$store.state.user.id,
          category: this.category,
        })
        .then(response => {
          console.log(response.data)
          // this.freePostList = response.data
          this.$router.push({ name: 'FreeboardDetail', params: { id: id } })
        }).catch(err => {
          console.log(err)
        });        
    }
  },
  created: function () {

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