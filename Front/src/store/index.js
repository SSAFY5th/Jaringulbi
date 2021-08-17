import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    accountbook: {},
    accountbooks: {},
    login_id: {},
    password: {},
    show: false,
    user: {},
    freePostList: [],
    budget: {},
    realbudget: {},
    challenge: {},
    challenges: {},
  },

  getters: {
    //state.user에 있는 값을 return 해줍니다
    userInfo(state) {
      return state.user;
    },
    accountbook(state) {
      return state.accountbook;
    },
    accountbooks(state) {
      return state.accountbooks;
    },
    freeboard(state) {
      return state.freePostList;
    },
    budget(state) {
      return state.budget;
    },
    realbudget(state) {
      return state.realbudget;
    },

    challenge(state) {
      return state.challenge;
    },

    challenges(state) {
      return state.challenges;
    },
  },

  mutations: {
    setAccountBooks(state, payload) {
      state.accountbooks = payload;
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
    REGIST_ACCOUNT(state, payload) {
      state.accountbook = payload;
    },

    setFreeboard(state, payload) {
      state.freePostList = payload;
    },
    setBudget(state, payload) {
      state.budget = payload;
      state.realbudget = payload;
    },

    setChallenge(state, payload) {
      state.challenges = payload;
    },

    setChallenges(state, payload) {
      state.challenges = payload;
    },
  },

  actions: {
    registaccount(context, { date, price, category, used, contents, user_id }) {
      console.log("가계부 등록");

      http
        .post("/accountbook", {
          date: date,
          price: price,
          category: category,
          used: used,
          contents: contents,
          user_id: user_id,
        })
        .then(({ data }) => {
          context.commit("REGIST_ACCOUNT", data);
        });
    },
    login(context, { login_id, password }) {
      console.log("로그인");
      console.log(login_id + " " + password);

      //들고간 값을 통해서 post요청을 해줍니다.
      //post요청을 하고 나서 받은 객체를 mutations로 보내줍니다. (payload)

      http
        .post("/user/${this.login_id}", {
          login_id: login_id,
          password: password,
        })
        .then(({ data }) => {
          // let msg = "로그인 완료!!";

          console.log("닉네임 : " + data.nickname);
          if (data.nickname == null) {
            // msg = "로그인 실패";
            context.commit("LOG_OUT");
          } else {
            context.commit("LOG_IN", data);
          }
          // alert(msg);
        })
        .catch((error) => {
          alert("로그인 오류");
          console.dir(error);
        });
    },
    deleteUser(context) {
      console.log("회원탈퇴");
      context.commit("LOG_OUT");
      alert("탈퇴 되었습니다.");
    },
    logout(context) {
      console.log("로그아웃");
      context.commit("LOG_OUT");
    },
    getAccountBooks(context, { full }) {
      console.log("vue:" + full);
      http
        .get("/accountbook", {
          params: {
            date: full,
          },
        })
        .then(({ data }) => {
          context.commit("setAccountBooks", data);
        })
        .catch(() => {
          alert("가계부 불러오기 실패");
        });
    },
    getFreePostList: function(context) {
      http
        .get("/board")
        .then((response) => {
          // this.freePostList = response.data
          context.commit("setFreeboard", response.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getBudget: function(context, budget) {
      context.commit("setBudget", budget);

      console.log(context);
    },

    getChalleng(context, { id }) {
      console.log("챌린지 상세보기");
      console.log(id);
      http
        .get("/detail/${this.id}", {
          id: id,
        })
        .then(({ data }) => {
          console.log("챌린지 제목 : " + data.title);
          if (data.title != null) {
            context.commit("setChallenge", data);
          }
        })
        .catch((error) => {
          console.log(error);
          console.error("챌린지 상세보기 실패");
        });
    },

    getChallengs: function(context) {
      http
        .get("/challenge")
        .then((data) => {
          // this.freePostList = response.data
          context.commit("setChallenges", data);
        })
        .catch((err) => {
          console.log(err);
          console.error("챌린지 목록 불러오기 실패");
        });
    },
  },

  //////////////////////////////////////////////////////////////

  plugins: [createPersistedState()],
});
