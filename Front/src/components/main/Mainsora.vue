<!--전반적인 틀이 되는 컴포넌트-->
<template>
  <div>
    <div class="sora d-flex justify-content-between" @click="go">
      <!-- <b-img :src="require('@/assets/소라고동.jpg')" id="sora"> -->
      <!-- </b-img> -->
      <div class="align-self-center ms-4">
        <span>선택이 고민될 땐 무엇이든!</span>
        <p class="m-0">마-법의 소라고둥</p>
      </div>
      <div class="align-self-center go-icon me-3">
        <b-icon icon="chevron-right" aria-hidden="false"></b-icon>
      </div>
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
  .sora {
    background-color: #9be4e4;
    cursor: pointer;
    border-radius: 12px;
    height: 100px;
    color: #fff;
    text-align: left;
  }

  .sora p {
    color: #7a69e6;
    font-size: 21px;
    font-weight: 800;
  }

  .go-icon {
    font-size: 24px;
  }
</style>