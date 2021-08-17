<template>
  <div style="width: 100%">
    <div v-if="$store.state.show" class="input-group">
      <input
        type="text"
        class="form-control"
        v-model="contents"
        @keyup.enter="createComment"
        placeholder="이곳을 눌러 댓글을 남겨보세요."
      />
<<<<<<< HEAD
      <button class="btn mint-btn" @click="createComment" type="button">➤</button>
=======
      <button class="btn mint-btn" @click="createComment" type="button">
        ➤
      </button>
>>>>>>> 42bd436b90f60adef118e92bf7245254390d98d5
    </div>
    <div v-else class="input-group">
      <input
        type="text"
        class="form-control"
        @click="createComment"
        v-model="contents"
        placeholder="로그인하여 댓글을 남겨보세요."
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
  props: {
    id: {
      type: Number,
    },
  },
  components: {},
  data() {
    return {
      contents: "",
    };
  },
  created() {},
  methods: {
    createComment: function () {
<<<<<<< HEAD
      let msg = ''
      msg = '내용을 입력해주세요.'

      if (!this.$store.state.show) {
        this.$router.push({ name: "Login" });      
      }

      else if (this.contents.length == 0)
        alert(msg)
      
=======
      let msg = "";
      msg = "내용을 입력해주세요.";

      if (!this.$store.state.show) {
        this.$router.push({ name: "Login" });
      } else if (this.contents.length == 0) alert(msg);
>>>>>>> 42bd436b90f60adef118e92bf7245254390d98d5
      else {
        http
          .post("comment/", {
            contents: this.contents,
            post_id: this.id,
            user_id: this.$store.state.user.id,
          })
          .then((response) => {
            console.log(response.data);
            this.contents = "";
            // this.$router.go()
            this.$emit("contents");
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
  },
};
</script>

<style scoped>
.mint-btn {
  background-color: #9be4e4;
  color: #7a69e6;
}
.mint-btn:hover {
  background-color: #9be4e4;
  color: #fff;
}
</style>