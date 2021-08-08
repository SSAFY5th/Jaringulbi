<template>
  <div class="row">
    <div>
      <b-container id="mainImage" class="top-login">
        <div id="font" class="login-back">
          <b-row>
            <div>
              <b-img
                :src="require('@/assets/logo.png')"
                style="width: 100px"
                class="margin"
              >
              </b-img>
              <h5>자린굴비</h5>
            </div>
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
                <div class="buttons">
                  <button
                    id="btn_group"
                    class="btn"
                    @keyup.enter="checkValue"
                    @click="checkValue"
                  >
                    로그인
                  </button>
                  <button class="btn" id="btn_group">아이디 찾기</button>
                  <button class="btn" id="btn_group">비밀번호 찾기</button>
                  <button class="btn" @click="signup" id="btn_group">
                    회원가입
                  </button>
                </div>
              </div>
            </div>
          </b-row>
        </div>
      </b-container>
    </div>
    <div class="col-xs-6 col-md-2"></div>
  </div>
</template>
<script>
import http from "@/util/http-common";

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
      else {
        http
          .post("/user/login", {
            login_id: this.login_id,
            password: this.password,
          })
          .then(({ data }) => {
            console.log(data);
            if (data === "success") {
              this.$router.push("/");
            }
            if (data === "fail") {
              console.log("아이디 비번 확인");
              alert("아이디와 비밀번호를 확인해주세요");
            }
          })
          .catch((error) => {
            alert("로그인 실패");
            console.dir(error);
          });
      }
      // if (this.$store.state.user.email !== null) {
      //   console.log(this.$store.state.user.email + " " + "로그인성공");
      //   this.$router.push("/");
      // } else {
      //   console.log("bye");
      // }
    },
  },
};
</script>
<style scoped>
#font {
  font-family: CookieRunOTF-Bold;
}

.top {
  background-color: white;
  margin-top: 40px;
}

button {
  margin: 5px;
  background-color: skyblue;
}

.buttons {
  margin-top: 25px;
}

.top-login {
  margin-top: 100px;
}

.margin {
  margin-top: 20px;
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

#btn_group {
  border: 1px solid skyblue;
  background-color: rgba(0, 0, 0, 0);
  color: skyblue;
  padding: 5px;
  width: 150px;
  margin-left: 14px;
  margin-top: 23px;
}
</style>
