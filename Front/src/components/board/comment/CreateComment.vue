<template>
  <div style="width: 100%">
    <div v-if="$store.state.show" class="input-group">
      <input
        type="text"
        class="form-control"
        v-model="commentItem"
        @keyup.enter="createComment"
        placeholder="이곳을 눌러 댓글을 남겨보세요."
      />
      <button class="btn" @click="createComment" type="button">➤</button>
    </div>
    <div v-else class="input-group">
      <input
        type="text"
        class="form-control"
        @click="createComment"
        v-model="commentItem"
        placeholder="대화를 시작하려면 로그인하세요!"
      />
      <button class="btn disabled" @click="createComment" type="button">
        ➤
      </button>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "CreateComment",
  components: {},
  data() {
    return {
      commentItem: [],
    };
  },
  methods: {
    createComment: function () {
      if (!this.$store.state.show) {
        this.$router.push({ name: "Login" });
      } else {
        http
          .post("comment/", {
            comment: this.commentItem,
          })
          .then((response) => {
            console.log(response.data);
            // console.log(commentItem)
            // this.getChatList()
            this.contents = "";
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
  },
};
</script>

<style>
</style>