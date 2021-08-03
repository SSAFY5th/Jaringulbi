<template>
  <div>
    <div id="acheader">
      <b-button-group id="acbutton">
        <b-button variant="info" block title="가계부" @click="account">
          <div>가계부</div>
        </b-button>
        <b-button variant="info" title="예산" @click="budget">
          <div>예산</div>
        </b-button>
        <b-button variant="info" title="통계" @click="graph">
          <div>통계</div>
        </b-button>
        <b-button variant="info" title="통계" @click="graph">
          <div>자산</div>
        </b-button>
      </b-button-group>
    </div>
  </div>
</template>
 
<script>
export default {
  name: "Acheader",
  computed: {},
  data() {
    return {};
  },
  methods: {
    account() {
      this.$router.push("/account");
    },
    budget() {
      this.$router.push("/budget");
    },
    graph() {
      this.$router.push("/graph");
    },
  },
};
</script>
<style scoped>
#acheader {
  width: 420px;
}
#acbutton {
  width: 420px;
}
</style>