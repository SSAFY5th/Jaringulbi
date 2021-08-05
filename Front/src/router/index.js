import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
<<<<<<< HEAD
import Accountbook from "../components/account_book/accountbook.vue";
import Board from "../components/board/Board.vue";
import Challenge from "../components/challenge/Challenge.vue";
import Mypage from "../components/user/Mypage.vue";
import Login from "../components/user/Login.vue";
import Signup from "../components/user/Signup.vue";
import Sora from "../components/sora/sora.vue";
=======
import Account from "../components/account_book/accountbook.vue";
import RegistAccount from "../components/account_book/RegistAccount.vue";
import Login from "../components/user/login.vue";
import Signup from "../components/user/signup.vue";
import Sora from "../components/sora/sora.vue";
import Budget from "../components/account_book/Budget.vue";
import Graph from "../components/account_book/Graph.vue";
>>>>>>> feature/FE/AccountPage-5

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
    name: "Account",
    component: Account,
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
<<<<<<< HEAD
=======
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
>>>>>>> feature/FE/AccountPage-5
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
