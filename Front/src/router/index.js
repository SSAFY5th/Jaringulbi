import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import PageNotFound from "../components/error/PageNotFound.vue";
import PageReady from "../components/error/PageReady.vue";
import Accountbook from "../components/account_book/Accountbook.vue";
import RegistAccount from "../components/account_book/RegistAccount.vue";
import Board from "../components/board/Board.vue";
import BuyOrNot from "../components/board/BuyOrNot.vue";
import CreateFreePost from "../components/board/CreateFreePost.vue";
import CreateBuyOrNot from "../components/board/CreateBuyOrNot.vue";
import UpdateFreePost from "../components/board/UpdateFreePost.vue";
import UpdateBuyOrNot from "../components/board/UpdateBuyOrNot.vue";
import FreeboardDetail from "../components/board/FreeboardDetail.vue";
import BuyOrNotDetail from "../components/board/BuyOrNotDetail.vue";
import Challenge from "../components/challenge/Challenge.vue";
import Mypage from "../components/user/Mypage.vue";
import Login from "../components/user/Login.vue";
import Signup from "../components/user/Signup.vue";
import Sora from "../components/sora/Sora.vue";
import Budget from "../components/account_book/Budget.vue";
import Graph from "../components/account_book/Graph.vue";
import MyChallenge from "../components/challenge/MyChallenge.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "*",
    redirect: '/404'
  },
  {
    path: "/404",
    name: "PageNotFound",
    component: PageNotFound,
  },
  {
    path: "/ready",
    name: "PageReady",
    component: PageReady,
  },
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
    path: "/buyornot",
    name: "BuyOrNot",
    component: BuyOrNot,
  },
  {
    path: "/board/create",
    name: "CreateFreePost",
    component: CreateFreePost,
  },
  {
    path: "/board/:id/update",
    name: "UpdateFreePost",
    component: UpdateFreePost,
  },
  {
    path: "/board/:id",
    name: "FreeboardDetail",
    component: FreeboardDetail,
  },
  {
    path: "/buyornot/create",
    name: "CreateBuyOrNot",
    component: CreateBuyOrNot,
  },
  {
    path: "/buyornot/:id/update",
    name: "UpdateBuyOrNot",
    component: UpdateBuyOrNot,
  },
  {
    path: "/buyornot/:id",
    name: "BuyOrNotDetail",
    component: BuyOrNotDetail,
  },
  {
    path: "/challenge",
    name: "Challenge",
    component: Challenge,
  },
  {
    path: "/mychallenge",
    name: "MyChallenge",
    component: MyChallenge,
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
