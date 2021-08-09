<template>
  <div class="row">
    <b-container id="mainImage">
      <div id="font">
        <div class="top">
          <b-img
            :src="require('@/assets/logo.png')"
            style="width: 100px"
            class="margin"
          ></b-img>

          <h5 style="color: #9175f3">자린굴비</h5>
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
          <button @click="check" class="btn" id="btn_group">가입</button>
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
  props: {
    type: { type: String },
  },
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
    check() {
      console.log("id =" + this.login_id);
      console.log("pass = " + this.password);
      console.log("nick = " + this.nickname);
      console.log("phone = " + this.phone);
    },
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

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 회원 가입
      else this.insertUser();
    },
    insertUser() {
      http
        .post("/user/login", {
          login_id: this.login_id,
          password: this.password,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = "로그인 실패!!";
          if (data === "success") {
            msg = "로그인 완료";
          }
          alert(msg);
        })
        .catch((error) => {
          alert("로그인 실패");
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
@font-face {
  font-family: "CookieRunOTF-Bold";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

.top {
  margin-top: 100px;
}

.margin {
  margin-top: 20px;
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
  padding: 35px;
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
  background-color: #9be4e4;
  color: #9175f3;
  border: 1px solid #9be4e4;
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
