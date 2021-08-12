
<template>
  <div id="font" class="row">
    <div><acheader></acheader></div>
    <hr />
    <div>
      <div>
        <div class="float">수입</div>
        <div class="float">지출</div>
        <div class="float">합계</div>
        <div class="float">자산</div>
      </div>
      <div>
        <div class="float">{{ impo }}원</div>
        <div class="float">{{ expo }}원</div>
        <div class="float">{{ total }}원</div>
        <div class="float">{{ asset }}원</div>
      </div>
    </div>
    <div>
      <calendar> </calendar>
    </div>
    <div>
      <router-link :to="`/registaccount`"
        ><b-button
          id="registbtn"
          variant="primary"
          class="rounded-circle px-2 circle"
          ><b-icon icon="plus" scale="2"></b-icon></b-button
      ></router-link>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
import Calendar from "@/components/account_book/account_components/Calendar.vue";
// import { mapGetters } from "vuex";

export default {
  name: "",
  components: {
    Acheader,
    Calendar,
  },
  computed: {
    // ...mapGetters(["accountbooks"]),
  },
  created() {
    // this.$store.dispatch("getAccountBooks");
  },

  data() {
    // const month = new Date().getMonth();
    // const year = new Date().getFullYear();
    // const day1 = new Date().getDate();

    // console.log(month);
    // console.log(year);
    // console.log(day1);
    return {
      impo: "",
      expo: "",
      total: "",
      asset: "",
      date: new Date(),
    };
  },
  methods: {},
};
</script>
<style scoped>
.float {
  display: inline-block;
  width: 25%;
}
#font {
  font-family: CookieRunOTF-Bold;
}

#registbtn {
  position: fixed;
  bottom: 110px;
  margin-left: 120px;
  z-index: 3;
  width: 50px;
  height: 50px;
  border-radius: 30px;
  background-color: #9be4e4;
  color: #7a69e6;
  font-size: 20pt;
  line-height: 30px;
}
</style>