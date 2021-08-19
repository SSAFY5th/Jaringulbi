<template>
  <div>
    <router-view />
    <div id="acheader">
      <div class="d-flex">
        <b-button-group id="acbutton">
          <b-button class="btn" title="모든 챌린지" @click="all">
            <div>전체</div>
          </b-button>
          <b-button class="btn" title="나의 챌린지" @click="my">
            <div>나의 챌린지</div>
          </b-button>
        </b-button-group>
      </div>
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
#font {
  font-family: CookieRunOTF-Bold;
}

#acbutton {
  width: 420px;
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