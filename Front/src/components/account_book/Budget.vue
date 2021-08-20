<template>
  <div>
    <div>
      <Acheader />
    </div>

    <div class="main-content">
      <div class="d-flex summary-box align-items-center justify-content-evenly">
        <div class="d-inline-block me-3">
          <span style="font-weight: 600; font-size: 21px">{{ month }}월</span>
        </div>
        <div class="d-inline-block me-3">
          <div class="d-flex align-items-center mb-2">
            <span id="post-username"> 수입 </span>
            <span id="post-title" class="ms-3" style="font-size: 18px">
              {{ impo | makeComma }}원
            </span>
          </div>
          <div class="d-flex align-items-center mb-2">
            <span id="post-username" class="m-0"> 지출 </span>
            <span
              id="post-title"
              class="ms-3"
              style="color: #7a69e6; font-size: 18px"
            >
              {{ expo | makeComma }}원
            </span>
          </div>
        </div>
      </div>

      <div class="mt-4 text-start">
        <div class="d-flex align-items-center">
          <span class="me-4">이번달 목표 예산</span>
          <span id="post-title"
            >{{ this.$store.state.realbudget | makeComma }}원</span
          >
        </div>
        <div>
          <span class="me-4">남은 예산</span>
          <span style="color: #7a69e6; font-weight: 600">
            {{
              (Number(this.$store.state.realbudget) +
                Number(this.$store.state.accountbooks.monthOutgoings))
                | makeComma
            }}원
          </span>
        </div>
      </div>

      <div class="mt-5 pt-2">
        <!-- <img
          :src="imgLink"
          style="width: 350px; height: 300px"
          class="margin"
        /> -->

        <p
          id="post-title"
          style="font-size: 21px"
          v-if="
            Number(this.$store.state.realbudget) +
              Number(this.$store.state.accountbooks.monthOutgoings) >=
            0
          "
        >
          아직까진 넉넉해요!
        </p>
        <p
          v-if="
            Number(this.$store.state.realbudget) +
              Number(this.$store.state.accountbooks.monthOutgoings) <
            0
          "
          id="post-title"
          style="font-size: 21px"
        >
          예산을 초과했어요 ㅠ_ㅠ
        </p>
      </div>
      <div>
        <button v-b-modal.modal-center class="btn mt-4" id="budget-btn">
          이번 달 예산 설정
        </button>
        <b-modal
          id="modal-center"
          @ok="registbudget"
          centered
          ref="my-dal1"
          title="예산 등록"
        >
          <p>금액을 입력해주세요</p>
          <p class="my-4">
            <input v-model.lazy="realbudget" class="form-control" />
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
    var realbudget = this.$store.state.realbudget;
    //이번달 예산 남은거가 설정해놓은 예산보다 작을경우

    return {
      month: month,
      impo: this.$store.state.accountbooks.monthIncomes,
      expo: this.$store.state.accountbooks.monthOutgoings,
      budget: this.budget,

      realbudget: realbudget,
    };
  },

  methods: {
    registbudget() {
      this.$store.dispatch("getBudget", this.budget);
      this.$store.dispatch("getrealBudget", this.realbudget);
      this.$refs["my-dal1"].hide();
    },
  },
};
</script>
<style scoped>
.main-content {
  padding: 15px 14px 12px 14px;
}

.summary-box {
  width: 100%;
  height: 120px;
  border: solid 1px #eee;
}

#budget-btn {
  width: 100%;
  background-color: #9be4e4;
  color: #fff;
}

#budget-btn:hover {
  border: solid 1px #9be4e4;
  background-color: #fff;
  color: #9be4e4;
}
</style>