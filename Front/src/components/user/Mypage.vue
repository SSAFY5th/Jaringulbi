<template>
  <div>
    <div id="mypage-header">
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
        <div class="mt-5">
          <div class="float1">
            <img alt="프로필" :src="image" id="image" />
          </div>
          <div class="float2">
            <div style="font-weight: bold">
              {{ this.$store.state.user.nickname }}
            </div>
            <div style="font-size: 10pt">
              굴비 개수 {{ this.$store.state.user.fish_count }}개
            </div>
            <div style="font-size: 10pt">
              이번 달 예산 {{ this.$store.state.budget }}원
            </div>
          </div>
        </div>
        <br />
        <div class="mb-3">
          <b-button style="width: 100%" @click="modify" class="mint-btn"
            >계정 설정</b-button
          >
        </div>
        <div>
          <b-list-group class="mb-3 text-start mt-5">
            <b-list-group-item>고객센터</b-list-group-item>
            <b-list-group-item>어플공유</b-list-group-item>
            <b-list-group-item>자주 하는 질문</b-list-group-item>
          </b-list-group>
        </div>
        <div class="mb-3 mt-5">
          <button @click="logout" style="width: 100%" class="btn">
            로그아웃
          </button>
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
    logout() {
      if (confirm("정말 로그아웃 하시겠습니까?")) {
        this.$store.dispatch("logout");
        this.$router.push("/");
      }
    },
  },
};
</script>

<style scoped>
#mypage-header {
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
  text-align: center;
}

.mint-btn {
  background-color: #9be4e4;
  color: #7a69e6;
  border: 1px solid #9be4e4;
  width: 100%;
  border-radius: 0.25rem;
}

.mint-btn:hover {
  border: 1px solid white;
  background-color: #9be4e4;
  color: #fff;
}

.form-area {
  padding: 10px 14px 12px 14px;
}
#image {
  width: 100px;
  height: 100%;
  border-radius: 100%;
  margin-bottom: 40px;
}

.float1 {
  width: 35%;
}

.float2 {
  width: 65%;
  text-align: left;
}
</style>