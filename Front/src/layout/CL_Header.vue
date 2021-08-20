<template>
  <!-- <router-view /> -->
  <div>
    <div class="cl-tab-wrap">
      <b-button-group id="acbutton">
        <b-button class="cl-tab-btn" title="모든 챌린지" @click="all">
          <div>전체</div>
        </b-button>

        <b-button class="cl-tab-btn" title="나의 챌린지">
          <router-link
            :to="{
              path: /mychallenge/ + this.$store.state.user.id,
            }"
            class="text-decoration-none text-dark"
          >
            <div>나의 챌린지</div>
          </router-link>
        </b-button>
      </b-button-group>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Acheader",
  computed: {
    ...mapGetters(["myChallenge"]),
  },
  data() {
    return {};
  },
  created() {
    var id = this.$store.state.user.id;
    this.$store.dispatch("getmyChallenge", { id: id });
  },
  methods: {
    all() {
      this.$router.push("/challenge");
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
  z-index: 5;
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