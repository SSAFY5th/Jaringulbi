<template>
  <div>
    <div id="post-header">
      <div
        class="d-flex justify-content-between align-self-center px-3"
        style="width: 100%"
      >
        <div>
          <router-link :to="{ name: 'Mypage' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
        </div>
      </div>
    </div>
    <div class="main-content">
      <div class="pt-5 pb-2 mb-4">
        <img alt="프로필" :src="image" id="profile-img" />
      </div>
      <div class="modify-form">
        <label for="login_id">아이디</label>
        <input
          readonly
          type="text"
          id="login_id"
          name="login_id"
          v-model="login_id"
          ref="login_id"
          class="form-control mt-1 mb-2"
        />
        <label for="password">비밀번호</label>
        <input
          type="password"
          id="password"
          name="password"
          v-model="password"
          ref="password"
          class="form-control mt-1 mb-2"
        />
        <label for="nickname">닉네임</label>
        <input
          type="text"
          id="nickname"
          name="nickname"
          v-model="nickname"
          ref="nickname"
          class="form-control mt-1 mb-2"
        />
        <label for="phone">전화번호</label>
        <input
          type="tel"
          id="phone"
          name="phone"
          v-model="phone"
          ref="phone"
          class="form-control mt-1 mb-3"
        />
        <div>
          <button
            class="btn mb-5"
            id="login-btn"
            @keyup.enter="modifyUser"
            @click="modifyUser"
          >
            수정
          </button>
          <div class="d-flex justify-content-between">
            <span
              @click="deleteUser"
              class="goback-link"
            >
              회원탈퇴
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import http from "@/util/http-common";
import { mapGetters } from "vuex";

export default {
  name: "signup",
  props: {
    type: { type: String },
  },
  computed: {
    ...mapGetters(["userInfo"]),
  },
  data() {
    return {
      login_id: "",
      password: "",
      nickname: "",
      phone: "",
      image: this.$store.state.user.image,
    };
  },
  created() {
    this.login_id = this.$store.state.user.login_id;
    this.password = this.$store.state.user.password;
    this.nickname = this.$store.state.user.nickname;
    this.phone = this.$store.state.user.phone;
  },
  methods: {
    modifyUser() {
      http
        .put(`/user/${this.login_id}`, {
          login_id: this.login_id,
          password: this.password,
          nickname: this.nickname,
          phone: this.phone,
        })
        .then(({ data }) => {
          console.log(data);
          let msg = "회원수정 실패!!";
          if (data === "success") {
            msg = "회원수정 완료";
            this.$router.push("/");
          }
          alert(msg);
        })
        .catch((error) => {
          alert("회원수정 실패");
          console.dir(error);
        });
    },
    deleteUser() {
      console.log("삭제 : " + this.login_id);
      if (confirm("정말 탈퇴 하시겠습니까?")) {
        http.delete(`/user/${this.login_id}`);
        this.$store.dispatch("deleteUser");
        this.$router.push("/");
      }
    },
  },
};
</script>
<style scoped>
.modify-form {
  padding: 0 40px 0 40px;
  text-align: left;
  color: #888;
  font-size: 14px;
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
</style>
