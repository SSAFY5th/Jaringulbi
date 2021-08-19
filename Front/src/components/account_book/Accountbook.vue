
<template>
  <div class="row">
    <div><acheader></acheader></div>
    <hr />
    <div style="margin-top: 6px">
      <div>
        <div class="float">수입</div>
        <div class="float">지출</div>
        <div class="float">합계</div>
      </div>
      <div>
        <div class="float" style="color: #86b2fa; font-weight: bold">
          {{ this.$store.state.accountbooks.monthIncomes | makeComma }}원
        </div>
        <div class="float" style="color: #f08d73; font-weight: bold">
          {{ this.$store.state.accountbooks.monthOutgoings | makeComma }}원
        </div>
        <div class="float" style="font-weight: bold">
          {{ this.$store.state.accountbooks.monthSum | makeComma }}원
        </div>
      </div>
    </div>
    <div>
      <calendar></calendar>
    </div>

    <div>
      <router-link :to="`/registaccount`">
        <div id="write-btn">
          <span>+</span>
        </div>
      </router-link>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
import Calendar from "@/components/account_book/account_components/Calendar.vue";
import { mapGetters } from "vuex";
var month = new Date().getMonth() + 1;
if (month < 10) month = "0" + month;
const year = new Date().getFullYear();
const day = new Date().getDate();

const full = year + "-" + month + "-" + day;
console.log(year + "-" + month + "-" + day);

export default {
  name: "",
  components: {
    Acheader,
    Calendar,
  },
  computed: {
    ...mapGetters(["accountbooks"]),
  },
  created() {
    // console.log(full);
    this.$store.dispatch("getAccountBooks", { full: full });
  },

  data() {
    // const month = new Date().getMonth();
    // const year = new Date().getFullYear();
    // const day1 = new Date().getDate();

    // console.log(month);
    // console.log(year);
    // console.log(day1);
    return {
      asset: "",
    };
  },
  methods: {},
};
</script>
<style scoped>
.float {
  display: inline-block;
  width: 33%;
}

#write-btn {
  position: fixed;    
  left: calc(50vw + 380px);
  bottom: 85px;
  z-index: 3;
  width: 60px;
  height: 60px;
  border-radius: 30px;
  background-color: #9be4e4;
  color: #fff;
  font-size: 30pt;
  line-height: 56px;
  box-shadow: 2px 2px 6px #ccc;
}
</style>