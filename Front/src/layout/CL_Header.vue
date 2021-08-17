<template>
  <div id="font">
    <router-view />
    <div id="acheader">
      <b-button-group id="acbutton">
        <b-button class="btn" title="모든 챌린지" @click="all">
          <div>모든 챌린지</div>
        </b-button>
        <b-button class="btn" title="나의 챌린지" @click="my">
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
  border-bottom-color: #9175f3;
}
</style>