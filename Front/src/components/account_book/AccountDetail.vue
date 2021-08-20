<template>
  <div>
      <div id="mypage-header">
      <div
        class="d-flex justify-content-between align-self-center px-3"
        style="width: 100%"
      >
      <div class="">
          <router-link :to="{ name: 'Accountbook' }" class="text-dark">
            <b-icon icon="chevron-left" aria-hidden="false"></b-icon>
          </router-link>
      </div>
      <div class="text-center">
        <!-- <span>가계부 상세보기</span> -->
      </div>
      </div>
    </div>
    <div class="main-content">
      <account-list
        v-for="(account, index) in accountbook"
        v-bind:key="index"
        :id="account.id"
        :date="account.date"
        :price="account.price"
        :category="account.category"
        :used="account.used"
        :contents="account.contents"
        :user_id="account.user_id"
      ></account-list>
    </div>
  </div>
</template>
<script>
import AccountList from "@/components/account_book/AccountList.vue";
import { mapGetters } from "vuex";

export default {
  components: {
    AccountList,
  },
  computed: {
    ...mapGetters(["accountbook"]),
  },

  data() {
    const year = new Date().getFullYear();
    var mon = new Date().getMonth() + 1;
    if (mon < 10) mon = "0" + mon;
    var day = this.$route.query.day;
    if (day < 10) day = "0" + day;
    const full1 = year + "-" + mon + "-" + day;

    this.$store.dispatch("getAccountBook", { full1: full1 });
    return {
      year: this.$route.query.year,
      month: this.$route.query.month,
      day: this.$route.query.day,
      full1: full1,
    };
  },
};
</script>
<style scoped>
#mypage-header {
  position: fixed;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 65px;
  background-color: #fff;
  color: #222;
  box-shadow: 0 2px 8px #ddd;
  text-align: center;
}
</style>