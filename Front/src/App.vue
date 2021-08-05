<template>
  <div id="app" class="">
    <div id="home">
      <router-view />
      <div id="bottom-menu" class="justify-content-center">
        <Bottom></Bottom>
      </div>
    </div>
  </div>
</template>

<script>
import Bottom from "@/layout/Bottom.vue";

export default {
  name: "App",
  components: {
    Bottom,
  },
};
</script>

<style>
  #app {
    margin: 0 auto;
    width: 100%;
    height: 100%;
    font-family: 'Noto Sans KR', sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    background-color: #eee;
  }

  #home {
    margin: 0 auto;
    padding-bottom: 65px;
    position: relative;
    width: 100%;
    max-width: 420px;
    min-height: 100vh;
    overflow: hidden;
    background-color: #fff;
  }

  #bottom-menu {
    position: fixed;
    bottom: 0;
    z-index: 999;  
    display: flex;
    width: 100%;
    max-width: 420px;
    height: 65px;
    padding: 15px 0;
    color: white;
    background-color: #fff;
  }

  #img-circle {
    width: 48px;
    height: 48px;
    border-radius: 24px;
    overflow: hidden;
  }
</style>
