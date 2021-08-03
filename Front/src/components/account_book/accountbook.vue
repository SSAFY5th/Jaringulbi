
<template>
  <div class="row">
    <div class="col-xs-6 col-md-2"></div>
    <div class="col-xs-6 col-md-4">로고가 들어올 공간입니당</div>
    <div class="col-xs-6 col-md-4">
      <div><acheader></acheader></div>
      <div>
        <div class="row money">
          <div class="col-xs-12 col-md-4">
            <div>수입</div>
            <div>{{ impo }}</div>
          </div>

          <div class="col-xs-12 col-md-4">
            <div>지출</div>
            <div>{{ expo }}</div>
          </div>
          <div class="col-xs-12 col-md-4">
            합계
            <div>{{ total }}</div>
          </div>
        </div>
      </div>
      <hr />
      <div><FullCalendar :options="calendarOptions" /></div>
      <div><bottom></bottom></div>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
import Bottom from "@/layout/Bottom.vue";
import "@fullcalendar/core/vdom"; // solves problem with Vite
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin from "@fullcalendar/interaction";

export default {
  components: {
    Acheader,
    Bottom,
    FullCalendar, // make the <FullCalendar> tag available
  },
  data() {
    return {
      impo: "원",
      expo: "원",
      total: "원",
      calendarOptions: {
        plugins: [dayGridPlugin, interactionPlugin],
        initialView: "dayGridMonth",
      },
    };
  },
  methods: {},
};
</script>
<style scoped>
.money {
  margin-top: 50px;
}
</style>