<template>
  <div>
    <router-view />
    <div>
      <b-button-group id="acbutton">
        <b-button class="btn" title="가계부" @click="account">
          <div>가계부</div>
        </b-button>
        <b-button class="btn" title="예산" @click="budget">
          <div>예산</div>
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
#acbutton {
  width: 420px;
  height: 65px;
}

.btn {
  position: fixed;
  top: 0;
  width: 100%;
  max-width: 420px;
  height: 65px;
  background-color: #fff;
  color: #222;
  box-shadow: 0 2px 8px #ddd;
  border: 1px solid white;
}
</style>