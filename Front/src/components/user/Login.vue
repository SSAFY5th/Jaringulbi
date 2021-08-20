<template>
  <div>    
    <div style="margin-top: 80px;">
      <b-img
        :src="require('@/assets/logo.png')"
        style="width: 100px;"            
      >
      </b-img>
      <h4
        class="my-3"
        style="color: #9be4e4; font-weight:600;"
      >
        자린굴비
      </h4>
    </div>
    <div class="login-form">
      <input
        type="text"
        id="login_id"
        name="login_id"
        v-model="login_id"
        ref="login_id"
        placeholder="ID"
        class="form-control mt-5 mb-2"
      />
      <input
        type="password"
        id="password"
        name="password"
        v-model="password"
        ref="password"
        placeholder="비밀번호"
        class="form-control mb-3"
        @keyup.enter="checkValue"
      />
      <div>
        <button
          class="btn mb-5"
          id="login-btn"
          @keyup.enter="checkValue"
          @click="checkValue"
        >
          로그인
        </button>
        <div class="d-flex justify-content-between">
          <span style="color:#888;">
            아직 계정이 없으신가요?
          </span>
          <span 
            @click="signup"
            class="sign-up-link"
          >
            회원가입
          </span>
        </div>
        <!-- <button
          style="width: 100%"
          class="btn btn-mint btn-primary"
          @click="signup"
        >
          회원가입
        </button> -->
      </div>
    </div>
  </div>
</template>
<script>
// import { mapGetters } from "vuex";

export default {
  name: "bottom",
  computed: {
    //getter에 있는 userInfo 함수를 불러옵니다.
    // ...mapGetters(["userInfo"]),
  },
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
        ((msg = "ID를 입력해주세요"),
        (err = false),
        this.$refs.login_id.focus());
      err &&
        !this.password &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.password.focus());
      if (!err) alert(msg);
      //dispatch >> store에 있는 action안에 있는 login 함수를 실행시켜줍니다.
      else
        this.$store.dispatch("login", {
          //form에서 받은 값을 action에 있는 login 함수로 들고
          login_id: this.login_id,
          password: this.password,
        });
      console.log(this.$store.state.user.id);
      if (this.$store.state.user.login_id != undefined) {
        console.log(this.$store.state.user.login_id + " " + "로그인성공");
        alert("로그인 성공");
        this.$router.push("/");
      }
    },
  },
};
</script>

<style scoped>
.login-form {
  padding: 0 40px 0 40px;
}

#login-btn {
  width: 100%;
  background-color: #9be4e4;
  color: #fff;
}

#login-btn:hover {
  border: solid 1px #9be4e4;
  background-color: #fff;
  color: #9be4e4;
}

.sign-up-link {
  color: #333;
  font-weight: 600;
  cursor: pointer;
}

.sign-up-link:hover {
  color: #7a69e6;
  font-weight: 600;
}

/* #btn_group {
  background-color: #9be4e4;
  color: #9175f3;
  border: 1px solid #9175f3;
  padding: 5px;
  width: 150px;
  margin-left: 14px;
  margin-top: 23px;
} */

</style>
