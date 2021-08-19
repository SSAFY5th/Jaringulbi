<template>
  <div>
    <div>디테일뷰</div>
  </div>
</template>
<script>
export default {
  data() {
    const year = new Date().getFullYear();
    var mon = new Date().getMonth();
    if (mon < 10) mon = "0" + Number(mon + 1);
    const full1 = year + "-" + mon + "-" + this.$route.query.day;
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