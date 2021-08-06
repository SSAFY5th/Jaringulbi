<template>
  <div class="row">
    <b-container id="mainImage">
      <div id="font">
        <div class="back" id="font">
          <div class="underline title">회원 가입</div>
        </div>
        <div class="regist_form">
          <label for="login_id">ID</label>
          <input
            type="text"
            id="login_id"
            name="login_id"
            v-model="login_id"
            ref="login_id"
          />
          <label for="password">비밀번호</label>
          <input
            type="password"
            id="password"
            name="password"
            v-model="password"
            ref="password"
          /><br />
          <label for="nickname">이름</label>
          <input
            type="text"
            id="nickname"
            name="nickname"
            v-model="nickname"
            ref="nickname"
          /><br />
          <label for="phone">Phone</label><br />
          <input
            type="tel"
            id="phone"
            name="phone"
            v-model="phone"
            ref="phone"
          />
          <br />
          <button @click="checkValue" class="btn" id="btn_group">가입</button>
          <button @click="home" class="btn" id="btn_group">홈으로</button>
        </div>
      </div>
    </b-container>
  </div>
</template>
<script>
import http from "@/util/http-common";

export default {
  name: "signup",
  computed: {},
  data() {
    return {
      login_id: "",
      password: "",
      nickname: "",
      phone: "",
    };
  },
  methods: {
    checkValue() {
      // 사용자 입력값 체크하기
      let err = true;
      let msg = "";
      !this.login_id &&
        ((msg = "id를 입력해주세요"),
        (err = false),
        this.$refs.login_id.focus());
      err &&
        !this.password &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.password.focus());
      err &&
        !this.nickname &&
        ((msg = "이름을 입력해주세요"),
        (err = false),
        this.$refs.nickname.focus());
      err &&
        !this.phone &&
        ((msg = "전화번호를 입력해주세요"),
        (err = false),
        this.$refs.phone.focus());

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 회원 가입
      else this.insertMember();
    },
    insertMember() {
      http
        .post("/user/signup", {
          id: this.login_id,
          pwd: this.password,
          nickname: this.nickname,
          phone: this.phone,
        })
        .then(({ data }) => {
          let msg = "회원가입 실패!!";
          if (data === "success") {
            msg = "회원가입 완료";
            this.home();
          }
          alert(msg);
        })
        .catch((error) => {
          alert("회원 가입 실패");
          console.dir(error);
        });
    },
    home() {
      this.$router.push("/");
    },
  },
};
</script>
<style scoped>
@keyframes tracking-in-expand {
  0% {
    letter-spacing: -0.5em;
    opacity: 0;
  }
  40% {
    opacity: 0.6;
  }
  100% {
    opacity: 1;
  }
}
@font-face {
  font-family: "CookieRunOTF-Bold";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

#font {
  font-family: CookieRunOTF-Bold;
}
.title {
  animation: tracking-in-expand 0.7s cubic-bezier(0.215, 0.61, 0.355, 1) both;
  color: black;
  font-size: 40px;
  text-shadow: 5px 5px #558abb;
}

.regist_form {
  text-align: left;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input,
textarea,
.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

#btn_group {
  border: 1px solid skyblue;
  background-color: rgba(0, 0, 0, 0);
  color: skyblue;
  padding: 5px;
  width: 150px;
  margin-left: 14px;
  margin-top: 23px;
}

#btn_group:hover {
  color: white;
  background-color: skyblue;
}
</style>
