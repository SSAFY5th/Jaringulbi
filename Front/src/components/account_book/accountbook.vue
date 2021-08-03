
<template>
  <div class="row">
    <div><acheader></acheader></div>
    <hr />
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
    <hr />
    <div>
      <DatePicker v-model="date" is-expanded mode="date" />
      <div>{{ date }}</div>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
import Vue from "vue";
import VCalendar from "v-calendar";
import { DatePicker } from "v-calendar";
// Use v-calendar & v-date-picker components
Vue.use(VCalendar, {
  componentPrefix: "vc", // Use <vc-calendar /> instead of <v-calendar />
});

export default {
  name: "",
  components: {
    Acheader,
    DatePicker,
  },
  computed: {},
  data() {
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

#calendar {
  height: 495px;
}
</style>