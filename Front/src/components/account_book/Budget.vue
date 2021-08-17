<template>
  <div>
    <div><acheader></acheader></div>

    <div id="top_btn">
      <div class="top">
        <h5 class="float1" style="text-align: center">{{ month }}월</h5>
        <div class="float2 mt-3">
          <div>수입 {{ impo | makeComma }}원</div>
          <div>지출 {{ expo | makeComma }}원</div>
        </div>
      </div>
      <div>이번 달 목표 예산</div>
      <div>
        <h2>{{ realbudget | makeComma }}원</h2>
      </div>
      <div>남은 예산</div>
      <div>
        <h2>{{ budget | makeComma }}원</h2>
      </div>
      <div></div>
      <br />

      <div>
        <img
          alt="Vue logo"
          :src="imgLink"
          style="width: 350px; height: 300px"
          class="margin"
        />

        <div>
          <h1>{{ contents }}</h1>
        </div>
      </div>
      <div>
        <b-button v-b-modal.modal-center id="btn_group"
          >이번 달 예산 설정</b-button
        >
        <b-modal
          id="modal-center"
          @ok="registbudget"
          centered
          title="예산 등록"
        >
          <h5>금액을 입력해주세요</h5>
          <p class="my-4">
            <input v-model.lazy="budget" />
          </p>
        </b-modal>
      </div>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
// import save from "@/assets/save.png";
// import good from "@/assets/good.png"

var month = new Date().getMonth() + 1;

import { mapGetters } from "vuex";
export default {
  components: {
    Acheader,
  },
  name: "",
  computed: { ...mapGetters(["budget", "realbudget"]) },
  data() {
    var budget =
      Number(this.$store.state.budget) +
      Number(this.$store.state.accountbooks.monthOutgoings);
    var contents = "";
    var imgLink = "";
    //이번달 예산 남은거가 설정해놓은 예산보다 작을경우
    console.log(Number(this.$store.state.budget));
    console.log(Number(this.$store.state.realbudget));
    if (budget >= 0) {
      contents = "아직까진 넉넉해요 ! ";
      imgLink = require("@/assets/good.png");
    }
    if (budget < 0) {
      contents = "예산 초과했어요 ㅠ_ㅠ";
      imgLink = require("@/assets/save.png");
    }

    console.log(contents);
    return {
      month: month,
      impo: this.$store.state.accountbooks.monthIncomes,
      expo: this.$store.state.accountbooks.monthOutgoings,
      budget: budget,
      contents: contents,
      realbudget: this.$store.state.realbudget,
      imgLink: imgLink,
    };
  },
  methods: {
    registbudget() {
      this.$store.dispatch("getBudget", this.budget);
      this.$router.go();
    },
  },
};
</script>
<style scoped>
#top_btn {
  text-align: left;
  margin: 20px;
}

.btn1 {
  background-color: rgba(0, 0, 0, 0);
  border-color: rgba(0, 0, 0, 0);
  border-radius: 20px;
}
.top {
  background-color: #9be4e4;
  color: #9175f3;
  border-radius: 10px;
  margin-bottom: 30px;
  padding-bottom: 10px;
}

.float1 {
  display: inline-block;
  width: 40%;
}
.float2 {
  display: inline-block;
  width: 60%;
}

#btn_group {
  background-color: #9be4e4;
  color: #9175f3;
  border: 1px solid #9be4e4;
  padding: 5px;
  width: 330px;
  margin: 20px;
}
</style>
