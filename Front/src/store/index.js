import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    accountbook: {},
  },

  getters: {
    accountbook(state) {
      return state.accountbook;
    },
  },

  mutations: {
    setAccountBook(state, payload) {
      state.accountbook = payload;
    },
  },

  actions: {
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
