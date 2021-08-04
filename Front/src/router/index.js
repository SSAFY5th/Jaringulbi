import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Account from "../components/account_book/accountbook.vue";
import RegistAccount from "../components/account_book/RegistAccount.vue";
import Login from "../components/user/login.vue";
import Signup from "../components/user/signup.vue";
import Sora from "../components/sora/sora.vue";
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
