<template>
  <div>
    <!-- 헤더 부분 -->
    <div id="post-header">
      <div class="d-flex justify-content-between align-self-center px-3" style="width:100%">
        <div>
          <router-link :to="{ name: 'BuyOrNot' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
        <div>
          <Search />
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
              <b-img :src="BuynotDetail.profile" class="img-fluid"></b-img>
            </div>      
            <span class="d-inline-block ms-2" id="post-username">
              {{ BuynotDetail.nickname }}
            </span>
            <!-- -->
          </div>
            
          <div class="d-inline-block">
            <span id="post-time">
              {{ created_time.year }}.
              {{ created_time.month }}.
              {{ created_time.day }}
            <!-- {{ created_time }} -->
            </span>
            <!-- 본인일때만 삭제 가능함 -->
            <b-dropdown size="sm" id="dropdown-right" right
              v-if="$store.state.user.id === BuynotDetail.user_id" 
              variant="link" class="p-0"
              toggle-class="text-decoration-none"              
              no-caret
            >
              <template #button-content>
                <b-icon icon="three-dots-vertical" aria-hidden="true"
                  class="text-secondary"></b-icon>
              </template>
              <b-dropdown-item
                v-bind:title="BuynotDetail.title"
                v-bind:contents="BuynotDetail.contents"
                @click="goUpdate(BuynotDetail)"
              >                
                수정
              </b-dropdown-item>
              <b-dropdown-item @click="deletePost(BuynotDetail)">
                삭제
              </b-dropdown-item>
            </b-dropdown>
          </div>      
        </div>
        <!-- 내용 -->
        <div class="mt-2">
          <div class="" id="receipt-wrap">
            <p id="post-title" class="mt-3">RECEIPT</p>
            <hr class="mx-2">
            <div class="text-start ms-3" id="post-title">
              <!-- 제목 -->
              {{ BuynotDetail.title }}
            </div>
            <div class="text-start mt-1 ms-3" id="post-content">
              {{ BuynotDetail.contents }}        
            </div>
            <hr class="mx-2">
            <div class="text-start ms-3 mb-3">
              <span id="post-content">Total.</span>
              <span id="post-title"> {{ BuynotDetail.price }} 원</span>
            </div>
            <div class="post-img">              
              <b-img :src="BuynotDetail.image" class="img-fluid"></b-img>
              <!-- <img src="https://picsum.photos/392/180" alt="이미지"> -->
            </div>
          </div>

          <!-- 추천, 비추천 수 -->
          <div class="mt-4 mb-3">
            <!-- 추천 버튼을 누르지 않았을때 -->
            <div v-show="!upClicked">
              <div class="d-inline-block me-5">
                <div class="d-inline-block">
                  <div
                    class="thumb-btn d-flex align-items-center justify-content-center me-2"
                    @click="clickUp"
                  >              
                    <b-icon icon="hand-thumbs-up" aria-hidden="false"></b-icon>
                </div>
                </div>
                <span id="thumb-cnt">{{ BuynotDetail.upCount }}</span>
              </div>
              <div class="d-inline-block">
                <div class="d-inline-block">
                  <div
                    class="thumb-btn d-flex align-items-center justify-content-center me-2"
                    @click="clickDown"
                  >
                    <!-- :class="{ thumb-btn-clicked: onClick }" -->
                    <b-icon icon="hand-thumbs-down" aria-hidden="false"></b-icon>
                  </div>
                </div>
                <span id="thumb-cnt">{{ BuynotDetail.downCount }}</span>
              </div>
            </div>
            <!-- 추천 버튼을 눌렀을때 -->
            <div v-show="upClicked">
              <div class="d-inline-block me-5">
                <div class="d-inline-block">
                  <div
                    class="thumb-btn-clicked d-flex align-items-center justify-content-center me-2"
                    @click="deleteUp"
                  >              
                    <b-icon icon="hand-thumbs-up" aria-hidden="false"></b-icon>
                </div>
                </div>
                <span id="thumb-cnt">{{ BuynotDetail.upCount }}</span>
              </div>
              <div class="d-inline-block">
                <div class="d-inline-block">
                  <div
                    class="thumb-btn-disabled d-flex align-items-center justify-content-center me-2"                    
                  >
                    <b-icon icon="hand-thumbs-down" aria-hidden="false"></b-icon>
                  </div>
                </div>
                <span id="thumb-cnt">{{ BuynotDetail.downCount }}</span>
              </div>
          </div>
          </div>

          <!-- 리플 수 -->
          <div class="text-end" id="post-upcount">
            <b-icon icon="chat-left" aria-hidden="false" class="me-2"></b-icon>
            <span>{{ BuynotDetail.commentCount }}</span>
          </div>
        </div>
      </div>   

      <div class="comment-wrap">
        <ul v-if="commentList.length" class="p-0">
          <li v-for="comment in commentList" :key="comment.id">
            <Comment 
              :comment="comment"
              v-on:contents="getBuynotPostDetail"
            />
          </li>
        </ul>
        <p v-else class="mt-4">아직 댓글이 없습니다.</p>
      </div>

      <div class="comment-form">
        <CreateComment
          v-bind:id="BuynotDetail.id"
          v-on:contents="getBuynotPostDetail"
        />
        <!-- {{ BuynotDetail.id }} -->
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
  name: "BuyOrNotDetail",
  components: {
    Search,
    Comment,
    CreateComment
  },
  data () {
    return {
      BuynotDetail: [],
      created_time: [],
      commentList: [],
      downList: [],
      upClicked: false,
      downClicked: false,
    };
  },
  methods: {
    getBuynotPostDetail: function () {
      const id = this.$route.params.id
      http.get("buyornot/" + id)
      .then(response => {
        this.BuynotDetail = response.data
        this.commentList = response.data.comment
        this.created_time = response.data.created_time.date
        // console.log(response.data)
      }).catch(err => {
        console.log(err)
      });
    },
    goUpdate() {
      const id = this.$route.params.id
      this.$router.push("/buyornot/" + id + "/update")
    },
    deletePost: function (){
      const id = this.$route.params.id
      http.delete("buyornot/" + id, {
        user_id: this.$store.state.user.id,
      })
      .then(() => {
        this.$router.push({ name: 'BuyOrNot' })
      }).catch(err => {
        console.log(err)
      });
    },
    clickUp() {
      if (!this.$store.state.show) {
        this.$router.push({ name: "Login" })
      }
      else
        http
          .post("up/", {
            post_id: this.$route.params.id,
            user_id: this.$store.state.user.id,            
          })
          .then((response) => {
            console.log(response.data);            
            this.upClicked = !this.upClicked
            // this.freePostList = response.data
            // this.$router.push({ name: "Board" });
          })
          .catch((err) => {
            console.log(err);
          });
    },
    clickDown() {
      if (!this.$store.state.show) {
        this.$router.push({ name: "Login" })
      }
      else
        http
        .post("down/", {
          post_id: this.$route.params.id,
          user_id: this.$store.state.user.id,         
        })
        .then((response) => {
          console.log(response.data);
          this.downClicked = !this.downClicked
          // this.freePostList = response.data
          // this.$router.push({ name: "Board" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteUp() {
      if (!this.$store.state.show) {
        this.$router.push({ name: "Login" })
      }          
      else
        http
          .delete("up/", {
            data: {
              post_id: this.$route.params.id,
              user_id: this.$store.state.user.id,  
            }
          })
          .then((response) => {
            console.log(response.data);
            this.upClicked = !this.upClicked
            // this.freePostList = response.data
          })
          .catch((err) => {
            console.log(err);
          });
    },
    deleteDown() {
      if (!this.$store.state.show) {
        this.$router.push({ name: "Login" })
      }
      else
        http
        .delete("down/", {
          post_id: this.$route.params.id,
          user_id: this.$store.state.user.id,            
        })
        .then((response) => {
          console.log(response.data)
          this.downClicked = !this.downClicked
          // this.freePostList = response.data
          // this.$router.push({ name: "Board" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created: function () {    
    this.getBuynotPostDetail()
  }
}
</script>

<style scoped>
  .post-detail {
    padding: 10px 14px 12px 14px;
    border-bottom: solid 1px #eee;
    color: #444;    
  }

  #receipt-wrap {
    border: solid 1px #ccc;
    overflow: hidden;
  }

  .post-img {
    max-height: 400px;
  }

  #thumb-cnt {
    font-weight: 600;
    color: #333;
    font-size: 18px;
  }

  .thumb-btn {
    width: 40px;
    height: 40px;
    background-color: #ddd;
    border-radius: 20px;
    cursor: pointer;
  }

  .thumb-btn:hover {
    width: 40px;
    height: 40px;
    background-color: #9be4e4;
    color: #7a69e6;
    border-radius: 20px;
    cursor: pointer;
  }

  .thumb-btn-disabled {
    width: 40px;
    height: 40px;
    background-color: #ddd;
    border-radius: 20px;
    /* cursor: pointer; */
  }

  /* .thumb-btn-disabled:hover {
    width: 40px;
    height: 40px;
    background-color: #9be4e4;
    color: #7a69e6;
    border-radius: 20px;
    cursor: pointer;
  } */

  .thumb-btn-clicked {
    width: 40px;
    height: 40px;
    background-color: #9be4e4;
    color: #7a69e6;
    border-radius: 20px;
    cursor: pointer;
  }

  .thumb-btn-clicked:hover {
    width: 40px;
    height: 40px;
    background-color: #ddd;
    border-radius: 20px;
    cursor: pointer;
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