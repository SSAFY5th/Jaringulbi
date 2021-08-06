<template>
  <div class="row">
    <div>
      <b-container id="mainImage" class="top-login">
        <div class="login-back">
          <b-row>
            <div class="login top list" id="font">
              <div class="login_form">
                <label for="id">ID</label><br />
                <input
                  type="text"
                  id="login_id"
                  name="login_id"
                  v-model="login_id"
                  ref="login_id"
                /><br />
                <label for="pwd">비밀번호</label><br />
                <input
                  type="password"
                  id="password"
                  name="password"
                  v-model="password"
                  ref="password"
                  @keyup.enter="checkValue"
                /><br />
                <button
                  class="btn"
                  @keyup.enter="checkValue"
                  @click="checkValue"
                >
                  로그인
                </button>
                <button class="btn">아이디 찾기</button>
                <button class="btn">비밀번호 찾기</button>
              </div>
              <div><button class="btn" @click="signup">회원가입</button></div>
            </div>
          </b-row>
        </div>
      </b-container>
    </div>
    <div class="col-xs-6 col-md-2"></div>
  </div>
</template>
<script>
export default {
  name: "bottom",
  computed: {},
  data() {
    return {
      login_id: "",
      password: "",
    };
  },
  methods: {
    signup() {
      this.$router.push("/signup");
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
      // 만약, 내용이 다 입력되어 있다면 로그인
      //else this.login();
      else
        this.$store.dispatch("login", {
          login_id: this.login_id,
          password: this.password,
        });

      if (this.$store.state.user.email !== null) {
        console.log(this.$store.state.user.email + " " + "로그인성공");
        this.$router.push("/");
      } else {
        console.log("bye");
      }
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
  background-color: white;
}

button {
  margin: 5px;
  background-color: skyblue;
}

#font {
  font-family: CookieRunOTF-Bold;
}

.regist {
  padding: 10px;
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
  width: 60%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}
</style>
