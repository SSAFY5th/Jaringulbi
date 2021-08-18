<template> 
  <!-- 리플 출력부분 -->
  <div class="post-comment">
    <!-- 리플 작성자 이름 -->
    <div class="d-flex">
      <div id="img-circle" class="bg-light" style="width: 48px">
        <img src="https://picsum.photos/48/48" alt="프로필사진" />
      </div>

      <div class="ms-2 flex-fill">
        <div class="d-flex justify-content-between">
          <span class="align-self-center" id="post-username">
            {{ comment.nickname }}
          </span>          
          <div>
          <span id="post-time">            
          {{ comment.commented_time.date.year }}.
          {{ comment.commented_time.date.month }}.
          {{ comment.commented_time.date.day }}
          </span>
          <!-- 본인일때만 삭제 가능함 -->
            <b-dropdown size="sm" id="dropdown-right" right
              v-if="$store.state.user.id === comment.user_id" 
              variant="link" class="p-0"
              toggle-class="text-decoration-none"              
              no-caret
            >
              <template #button-content>
                <b-icon icon="three-dots-vertical" aria-hidden="true"
                  class="text-secondary"></b-icon>
              </template>
              <b-dropdown-item @click="onUpdateComment(comment)"                
              >
                수정
              </b-dropdown-item>
              <b-dropdown-item @click="deleteComment(comment)">
                삭제
              </b-dropdown-item>
            </b-dropdown>
          </div>
        </div>
        <!-- 리플 내용 -->
        <div class="mt-1" id="post-content">
          <div v-show="!onUpdateCommentClicked">
            {{ comment.contents }}
          </div>
          <!-- 수정 버튼 누르면 이 자리에 input 박스가 생깁니다 -->
          <div v-show="onUpdateCommentClicked" class="input-group input-group-sm">
            <input type="text"
              class="form-control" 
              v-model="comment.contents"
              @keyup.enter="updateComment(comment)"
            >
            <button class="btn mint-btn"
              @click="updateComment(comment)" type="button"
            >
              수정
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>  
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "Comment",
  props: {
    comment: {
      type: Object,
    },
  },
  data: function() {
    return {
      onUpdateCommentClicked: false,
      contents: '',
    }
  },
  methods: {
    onUpdateComment() {
      this.onUpdateCommentClicked = !this.onUpdateCommentClicked
    },
    updateComment: function (comment) {
      let msg = ''
      msg = '내용을 입력해주세요.'
      if (this.comment.contents.length == 0)
        alert(msg)

      else
        http.put("comment/" + comment.id, {
          contents: this.comment.contents,
          user_id: this.$store.state.user.id,
        })
        .then(() => {
          // this.$emit('contents')
          this.onUpdateCommentClicked = !this.onUpdateCommentClicked
        }).catch(err => {
          console.log(err)
        });        
    },
    deleteComment: function (comment){
      // user_id: this.$store.state.user.id,        
      http.delete("comment/" + comment.id)
      .then(() => {
        // this.$router.go()
        this.$emit('contents')
      }).catch(err => {
        console.log(err)
      });      
    },
  }
};
</script>

<style scoped>
  .post-comment {
    padding: 10px 14px 12px 14px;
    width: 100%;
    border-bottom: solid 1px #eee;
    text-align: left;  
  }

  .mint-btn {
    background-color: #9be4e4;
    color: #7a69e6;
  }

  .mint-btn:hover {
    background-color: #9be4e4;
    color: #fff;
  }
</style>