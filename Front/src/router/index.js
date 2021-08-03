import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Accountbook from "../components/account_book/accountbook.vue";
import Board from "../components/board/Board.vue";
import Challenge from "../components/challenge/Challenge.vue";
import Mypage from "../components/user/Mypage.vue";
import Login from "../components/user/Login.vue";
import Signup from "../components/user/Signup.vue";
import Sora from "../components/sora/sora.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/accountbook",
    name: "Accountbook",
    component: Accountbook,
  },
  {
    path: "/board",
    name: "Board",
    component: Board,
  },
  {
    path: "/challenge",
    name: "Challenge",
    component: Challenge,
  },
  {
    path: "/mypage",
    name: "Mypage",
    component: Mypage,
  },
  {
    path: "/sora",
    name: "Sora",
    component: Sora,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
