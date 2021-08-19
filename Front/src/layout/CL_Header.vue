<template>
  <!-- <router-view /> -->
  <div>
    <div class="d-flex">
      <b-button-group id="acbutton">
        <b-button class="top-category-btn" title="모든 챌린지" @click="all">
          <div>전체</div>
        </b-button>
        <b-button class="top-category-btn" title="나의 챌린지" @click="my">
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
#acbutton {
  width: 100%;
}
.top-category-btn {
  position: fixed;
  top: 0;
  z-index: 999;
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