<template>
  <div>
    <!-- 헤더 부분 -->
    <div id="post-header">
      <div
        class="d-flex justify-content-between align-self-center px-3"
        style="width: 100%"
      >
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
              <b-img :src="freeDetail.profile" class="img-fluid"></b-img>
            </div>
            <span class="d-inline-block ms-2" id="post-username">
              {{ freeDetail.nickname }}
            </span>
            <!-- -->
          </div>

          <div class="d-inline-block">
            <span id="post-time">
              {{ created_time.year }}. {{ created_time.month }}.
              {{ created_time.day }}
            </span>
            <!-- 본인일때만 삭제 가능함 -->
            <b-dropdown
              size="sm"
              id="dropdown-right"
              right
              v-if="$store.state.user.id === freeDetail.user_id"
              variant="link"
              class="p-0"
              toggle-class="text-decoration-none"
              no-caret
            >
              <template #button-content>
                <b-icon
                  icon="three-dots-vertical"
                  aria-hidden="true"
                  class="text-secondary"
                ></b-icon>
              </template>
              <b-dropdown-item
                v-bind:title="freeDetail.title"
                v-bind:contents="freeDetail.contents"
                @click="goUpdate(freeDetail)"
              >
                수정
              </b-dropdown-item>
              <b-dropdown-item @click="deletePost(freeDetail)">
                삭제
              </b-dropdown-item>
            </b-dropdown>
          </div>
        </div>
        <!-- 내용 -->
        <div>
          <div class="text-start mt-2" id="post-title">
            {{ freeDetail.title }}
          </div>
          <div class="text-start mt-1 mb-2" id="post-content">
            {{ freeDetail.contents }}
          </div>
          <div class="post-img mb-2" v-if="freeDetail.image">              
            <b-img :src="freeDetail.image" class="img-fluid"></b-img>
            <!-- <img src="https://picsum.photos/392/180" alt="이미지"> -->
          </div>
          <div v-else></div>

          <!-- 좋아요, 리플 수 -->
          <div class="text-end text-secondary" id="post-upcount">
            <div class="d-inline-block me-3">
              <b-icon
                icon="heart-fill"
                aria-hidden="false"
                class="me-2"
              ></b-icon>
              <span>{{ freeDetail.upCount }}</span>
            </div>
            <div class="d-inline-block">
              <b-icon
                icon="chat-left"
                aria-hidden="false"
                class="me-2"
              ></b-icon>
              <span>{{ freeDetail.commentCount }}</span>
            </div>
          </div>
        </div>
      </div>

      <div class="comment-wrap">
        <ul v-if="commentList.length" class="p-0">
          <li v-for="comment in commentList" :key="comment.id">
            <Comment :comment="comment" v-on:contents="getFreePostDetail" />
          </li>
        </ul>
        <p v-else class="mt-4">아직 댓글이 없습니다.</p>
      </div>

      <div class="comment-form">
        <CreateComment
          v-bind:id="freeDetail.id"
          v-on:contents="getFreePostDetail"
        />
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
    CreateComment,
  },
  data() {
    return {
      freeDetail: [],
      created_time: [],
      commentList: [],
    };
  },
  methods: {
    getFreePostDetail: function () {
      const id = this.$route.params.id;
      http
        .get("board/" + id)
        .then((response) => {
          this.freeDetail = response.data;
          this.commentList = response.data.comment;
          this.created_time = response.data.created_time.date;
          console.log(response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    goUpdate() {
      const id = this.$route.params.id;
      this.$router.push("/board/" + id + "/update");
    },
    deletePost: function () {
      // console.log(freeDetail.id)
      const id = this.$route.params.id;
      http
        .delete("board/" + id, {
          user_id: this.$store.state.user.id,
        })
        .then(() => {
          this.$router.push({ name: "Board" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created: function () {
    this.getFreePostDetail();
  },
};
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
  color: #999;
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