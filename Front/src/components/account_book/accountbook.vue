
<template>
  <div class="row">
    <div class="col-xs-6 col-md-2"></div>
    <div class="col-xs-6 col-md-4">로고가 들어올 공간입니당</div>
    <div class="col-xs-6 col-md-4"><acheader></acheader> <bottom></bottom></div>
    <div class="col-xs-6 col-md-2"></div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
import Bottom from "@/layout/Bottom.vue";

export default {
  components: {
    Acheader,
    Bottom,
  },
};
</script>

   