<template>
  <div>
    <div><acheader></acheader></div>

    <div style="text-align: left; margin: 20px">
      <div class="top">
        <div class="float1">
          <h5>
            <div>
              <b-button class="btn1" size="sm">←</b-button
              >{{ month }}월<b-button size="sm" class="btn1">→</b-button>
            </div>
          </h5>
        </div>
        <div class="float2 mt-3">
          <div>수입 {{ impo }}원</div>
          <div>수출 {{ expo }}원</div>
        </div>
      </div>
      <div class="mt-3">한 달 예산</div>
      <div class="mt-3">
        <h2>{{ budget }}원 남음</h2>
      </div>
      <div class="mt-3">하루 예산 {{ daybudget }}원</div>
      <div>총 예상 지출 {{ dayimpo }}원</div>
      <div class="mt-5">
        <h5>권장 60%</h5>
        <b-progress :max="max">
          <b-progress-bar
            :value="value"
            :label="`${((value / max) * 100).toFixed(2)}%`"
          ></b-progress-bar>
        </b-progress>
      </div>
      <div>
        총 예산<span>{{ budget }}</span>
      </div>
      <div>
        오늘까지 권장 지출<span>{{ recommend }}</span>
      </div>
      <div class="mt-5">
        <b-button id="btn_group">카테고리별 예산 설정</b-button>
      </div>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";

//// import { mapGetters } from "vuex";
export default {
  components: {
    Acheader,
  },
  name: "",
  computed: {},
  data() {
    return {
      month: "7",
      impo: "5000",
      expo: "5000",
      budget: "500,000",
      daybudget: "50,000",
      recommend: "",
      dayimpo: "0",
      value: 50,
      max: 100,
    };
  },
  methods: {},
};
</script>
<style scoped>
.btn1 {
  background-color: rgba(0, 0, 0, 0);
  border-color: rgba(0, 0, 0, 0);
  border-radius: 20px;
}
.top {
  background-color: #9be4e4;
  color: white;

  border-radius: 10px;
}

.float1 {
  display: inline-block;
  width: 30%;
}
.float2 {
  display: inline-block;
  width: 60%;
}
</style>
