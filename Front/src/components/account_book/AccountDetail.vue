<template>
  <div>
    <div>
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
</style>