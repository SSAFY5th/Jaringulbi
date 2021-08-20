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
    challengeid: {},
    myChallenge: {},
    myList: {},
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

    challengeid(state) {
      return state.challengeid;
    },

    myChallenge(state) {
      return state.myChallenge;
    },
  },

  mutations: {
    setAccountBook(state, payload) {
      state.accountbook = payload;
    },
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
    },

    setrealBudget(state, payload) {
      state.realbudget = payload;
    },

    setChallenge(state, payload) {
      state.challenge = payload;
    },

    setChallenges(state, payload) {
      state.challenges = payload;
    },

    setChallengeId(state, payload) {
      state.challengeid = payload;
    },

    setmyChallenge(state, payload) {
      state.myChallenge = payload;
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
    getAccountBook(context, { full1 }) {
      console.log("상세보기 가자 :" + full1);
      http
        .get("/accountbook/detail", {
          params: {
            date: full1,
          },
        })
        .then(({ data }) => {
          context.commit("setAccountBook", data);
        })
        .catch(() => {
          alert("가계부 상세보기 실패");
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
    getAccountBooks(context, { full }) {
      console.log("vue :" + full);
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
    getBudget: function(context, budget) {
      context.commit("setBudget", budget);

      console.log(context);
    },

    getrealBudget: function(context, budget) {
      context.commit("setrealBudget", budget);

      console.log(context);
    },

    getChallenge(context, { id }) {
      console.log("챌린지 상세보기");
      http
        .get("/challenge/detail/" + id, {
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

    getmyChallenge(context, { id }) {
      console.log("마이 챌린지 시작");
      console.log(id);
      http
        .get("/challenge/mylist/" + id, {
          id: id,
        })
        .then(({ data }) => {
          context.commit("setmyChallenge", data);
        })
        .catch((error) => {
          console.log(error);
          console.error("마이챌린지 보기 실패");
        });
    },

    getChallenges: function(context) {
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
    enter(context, { challenge_id, user_id }) {
      console.log("참가하기");
      console.log(challenge_id + " " + user_id);
      http
        .post("/challenge/enter", {
          challenge_id: challenge_id,
          user_id: user_id,
        })
        .then(({ data }) => {
          // let msg = "로그인 완료!!";

          console.log("챌린지번호 : " + data);
          context.commit("setChallengeId", data);

          // alert(msg);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },

  //////////////////////////////////////////////////////////////

  plugins: [createPersistedState()],
});
