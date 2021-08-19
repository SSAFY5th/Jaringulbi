<template>
  <div>
    <router-view />
    <div>
      <b-button-group id="acbutton">
        <b-button class="top-category-btn" title="가계부" @click="account">
          <div>가계부</div>
        </b-button>
        <b-button class="top-category-btn" title="예산" @click="budget">
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
  width: 100%;
  height: 65px;
}

.top-category-btn {
  position: fixed;
  top: 0;
  width: 100%;
  max-width: 420px;
  height: 65px;
  background-color: #fff;
  color: #222;
  box-shadow: 0 2px 6px #ddd;
  border: 1px solid white;
}

.top-category-btn:hover {
  background-color: #9be4e4;
  border: 1px solid #9be4e4;
}
</style>