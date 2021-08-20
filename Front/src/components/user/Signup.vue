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
        class="form-control mb-2"
      />
      <input
        type="text"
        id="nickname"
        name="nickname"
        v-model="nickname"
        ref="nickname"
        placeholder="닉네임"
        class="form-control mb-2"
      />
      <input
        type="tel"
        id="phone"
        name="phone"
        v-model="phone"
        ref="phone"
        placeholder="전화번호"
        class="form-control mb-3"
      />
      <div>
        <button
          class="btn mb-5"
          id="login-btn"
          @keyup.enter="checkValue"
          @click="checkValue"
        >
          회원가입
        </button>
        <div class="d-flex justify-content-between">
          <span
            @click="home"
            class="goback-link"
          >
            홈으로 돌아가기
          </span>
        </div>
      </div>
    </div>
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
    checkValue() {
      // 사용자 입력값 체크하기
      let err = true;
      let msg = "";
      err &&
        !this.login_id &&
        ((msg = "ID를 입력해주세요"),
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
      else this.insertUser();
    },
    insertUser() {
      http
        .post("/user/signup", {
          login_id: this.login_id,
          password: this.password,
          nickname: this.nickname,
          phone: this.phone,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = "회원가입 실패!!";
          if (data === "success") {
            msg = "회원가입 완료";
            this.$router.push("/");
          }
          alert(msg);
        })
        .catch((error) => {
          alert("회원가입 실패");
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

.goback-link {
  color: #888;
  cursor: pointer;
}
/* 
.goback-link:hover {
  color: #7a69e6;
  font-weight: 600;
} */
</style>
