<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div>
    <div class="sora"  @click="go">

        <b-img :src="require('@/assets/소라고동.jpg')" id="sora">
        </b-img>
          <span>선택이 고민될 땐 무엇이든!</span>
        <p>마-법의 소라고동</p>

    </div>
  </div>
</template>

<script>
export default {
  name: "Mainsora",
  data() {
    return {};
  },
  methods: {
    go() {
      this.$router.push("/sora");
    },
  },
};
</script>

<style>
#sora {
  width: 60px;
  height: 60px;
  border-radius: 60px;
}

.sora {
  background-color: #9be4e4;
  cursor: pointer;
}

.sora p {
  color: #fff;
  font-size: 16pt;
  font-weight: 800;

}
</style>