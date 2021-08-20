<template>
  <!-- <router-view /> -->
  <div>
    <div class="cl-tab-wrap">
      <b-button-group id="acbutton">
        <b-button class="cl-tab-btn" title="모든 챌린지" @click="all">
          <div>전체</div>
        </b-button>
        <b-button class="cl-tab-btn" title="나의 챌린지" @click="my">
          <div>나의 챌린지</div>
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
    all() {
      this.$router.push("/challenge");
    },
    my() {
      this.$router.push("/mychallenge");
    },
  },
};
</script>
<style scoped>
.cl-tab-wrap {
  position: fixed;
  top: 0;
  width: 100%;
  max-width: 420px;
  height: 65px;
  background-color: #fff;
  box-shadow: 0 2px 6px #ddd;
}

.cl-tab-btn {
  background-color: #fff;
  color: #333;
  border: 1px solid white;
}

.cl-tab-btn:hover {
  background-color: #9be4e4;
  border: 1px solid #9be4e4;
}

#acbutton {
  width: 100%;
  height: 100%;
}
</style>