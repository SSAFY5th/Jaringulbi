<template>
  <div id="font">
    <router-view />
    <div id="acheader">
      <b-button-group id="acbutton">
        <b-button class="btn" title="가계부" @click="account">
          <div>가계부</div>
        </b-button>
        <b-button class="btn" title="예산" @click="budget">
          <div>예산</div>
        </b-button>
        <b-button class="btn" title="통계" @click="graph">
          <div>통계</div>
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
      this.$router.push("/accountbook");
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
#font {
  font-family: CookieRunOTF-Bold;
}

#acbutton {
  width: 420px;
}

.btn {
  background-color: #9be4e4;
  color: #9175f3;
  border: 1px solid #9be4e4;
}
</style>