<template>
  <div>
    <div id="post-header">
      <div
        class="d-flex justify-content-center align-self-center px-3"
        style="width: 100%"
      >
        <div class="text-center">
          <span>마이페이지</span>
        </div>
      </div>
    </div>
    <div class="main-content">
      <div class="form-area">
        <div>
          <div class="float1 category">
            <img alt="프로필" :src="image" id="image" />
          </div>
          <div class="float2">
            <div>닉네임</div>
            <div>소유한 굴비 개수 {{ this.$store.state.user.fish_count }}</div>
          </div>
        </div>
        <br />
        <div class="mb-3">
          <b-button style="width: 100%" @click="modify">프로필 수정</b-button>
        </div>
        <div>
          <b-list-group>
            <b-list-group-item>계정설정</b-list-group-item>
            <b-list-group-item>고객센터</b-list-group-item>
            <b-list-group-item>어플공유</b-list-group-item>
            <b-list-group-item>자주 하는 질문</b-list-group-item>
          </b-list-group>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      image: this.$store.state.user.image,
    };
  },
  methods: {
    modify() {
      this.$router.push("/modify");
    },
  },
};
</script>

<style scoped>
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
  text-align: center;
}
.form-area {
  padding: 10px 14px 12px 14px;
}

.category {
  height: 50px;
  line-height: 50px;
  font-weight: 600;
  color: #333;
  /* border-bottom: solid 1px #eee; */
}

.float1 {
  width: 30%;
}

.float2 {
  width: 70%;
  text-align: left;
}
</style>