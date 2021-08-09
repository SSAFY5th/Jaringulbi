import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Accountbook from "../components/account_book/Accountbook.vue";
import RegistAccount from "../components/account_book/RegistAccount.vue";
import CreateFreePost from "../components/board/CreateFreePost.vue";
import Board from "../components/board/Board.vue";
import FreeboardDetail from "../components/board/FreeboardDetail.vue";
import Challenge from "../components/challenge/Challenge.vue";
import Mypage from "../components/user/Mypage.vue";
import Login from "../components/user/Login.vue";
import Signup from "../components/user/Signup.vue";
import Sora from "../components/sora/Sora.vue";
import Budget from "../components/account_book/Budget.vue";
import Graph from "../components/account_book/Graph.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/registaccount",
    name: "RegistAccount",
    component: RegistAccount,
  },
  {
    path: "/accountbook",
    name: "Accountbook",
    component: Accountbook,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/mypage",
    name: "Mypage",
    component: Mypage,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/board",
    name: "Board",
    component: Board,
  },
  {
    path: "/board/create",
    name: "CreateFreePost",
    component: CreateFreePost,
  },
  {
    path: "/board/:id",
    name: "FreeboardDetail",
    component: FreeboardDetail,
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
  {
    path: "/budget",
    name: "Budget",
    component: Budget,
  },
  {
    path: "/graph",
    name: "Graph",
    component: Graph,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
