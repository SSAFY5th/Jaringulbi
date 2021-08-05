<template>
  <div>
    <div class="search">
      <div class="float">
        <b-img :src="require('@/assets/fish.png')" id="fish"> </b-img>
      </div>
    </div>
    <div>
      <div class="float">
        <b-icon icon="bell-fill" aria-hidden="false" id="bell"></b-icon>
      </div>
      <div class="float">
        <b-icon icon="search" aria-hidden="false" id="search"></b-icon>
      </div>
    </div>
  </div>
</template>
<script>
// import { mapGetters } from "vuex";
// export default {
//   name: "",
//   computed: {},
//   data() {
//     return {};
//   },
//   created() {},
//   methods: {},
// };
</script>
<style scoped>
.float {
  display: inline-block;
  width: 25%;
}

.search {
  position: absolute;
  width: 420px;
  height: 85px;

  top: 0px;
}

#fish {
  position: absolute;
  height: 40px;
  width: 40px;
  left: 21px;
  top: 22px;
  border-radius: 0px;
}

#bell {
  position: absolute;
  width: 20px;
  height: 20px;
  left: 344px;
  top: 38px;
}
#search {
  position: absolute;
  width: 20px;
  height: 20px;
  left: 372px;
  top: 38px;
}
</style>
