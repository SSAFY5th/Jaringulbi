<template>
  <div class="row">
    <b-container id="mainImage">
      <div>
        <div class="top">
          <!-- <b-img
            :src="require('@/assets/logo.png')"
            style="width: 100px"
            class="margin"
          ></b-img> -->
          <img alt="프로필" :src="image" id="image" />
          <div id="post-header">
            <div
              class="d-flex justify-content-between align-self-center px-3"
              style="width: 100%"
            >
              <div class="">
                <router-link :to="{ name: 'Board' }" class="text-dark">
                  <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
                </router-link>
              </div>
              <!-- <div class="text-center">
          <span>글쓰기</span>
        </div> -->
            </div>
          </div>
          <!-- <h5 style="color: #9175f3">자린굴비</h5> -->
        </div>
        <div class="regist_form">
          <label for="login_id">아이디</label>
          <input
            readonly
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
          <label for="phone">전화번호</label><br />
          <input
            type="tel"
            id="phone"
            name="phone"
            v-model="phone"
            ref="phone"
          />
          <br />
          <button @click="modifyUser" class="btn" id="btn_group">수정</button>
          <button @click="deleteUser" class="btn" id="btn_group">
            회원탈퇴
          </button>
        </div>
      </div>
    </b-container>
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
.top {
  margin-top: 60px;
}

.margin {
  margin-top: 20px;
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
  width: 150px;
  margin-left: 14px;
  margin-top: 23px;
}

#btn_group:hover {
  color: #9be4e4;
  background-color: #fff;
  border: 1px solid #9be4e4;
}
</style>
