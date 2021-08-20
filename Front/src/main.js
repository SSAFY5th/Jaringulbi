import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

// Install BootstrapVue
// Optionally install the BootstrapVue icon components plugin

Vue.config.productionTip = false;
Vue.config.silent = true;

Vue.filter("makeComma", (val) => {
  return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
});

import "bootstrap/dist/css/bootstrap.min.css";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";

// Import Bootstrap an BootstrapVue CSS files (order is important)
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
