import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    accountbook: {},
    login_id: {},
    password: {},
    show: false,
    user: {},
  },

  getters: {
    //state.user에 있는 값을 return 해줍니다
    userInfo(state) {
      return state.user;
    },
    accountbook(state) {
      return state.accountbook;
    },
  },

  mutations: {
    setAccountBook(state, payload) {
      state.accountbook = payload;
    },

    LOG_IN(state, payload) {
      //state.user에 받아온 데이터(data== payload)를 넣어줍니다.
      //show를 통해서 로그인, 비로그인을 구별
      state.user = payload;
      state.show = true;
    },
    LOG_OUT(state) {
      state.user = {};
      state.show = false;
    },
  },

  actions: {
    login(context, { login_id, password }) {
      console.log("로그인");
      console.log(login_id);
      //들고간 값을 통해서 post요청을 해줍니다.
      //post요청을 하고 나서 받은 객체를 mutations로 보내줍니다. (payload)

      http
        .post("/user/${this.login_id}", {
          login_id: login_id,
          password: password,
        })
        .then(({ data }) => {
          let msg = "로그인 완료!!";
          console.log("닉네임" + data.nickname);
          if (data.nickname == null) {
            msg = "로그인 실패";
            context.commit("LOG_OUT");
          } else {
            context.commit("LOG_IN", data);
          }
          alert(msg);
        })
        .catch((error) => {
          alert("로그인 오류");
          console.dir(error);
        });
    },
    getAccountBook(context) {
      http
        .get("/accountbook")
        .then(({ data }) => {
          context.commit("setAccountBook", data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },
  },

  //////////////////////////////////////////////////////////////

  plugins: [createPersistedState()],
});
