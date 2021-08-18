<template>
  <div id="app" class="">
    <div id="home">
      <router-view />
      <div id="bottom-menu" class="">
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
    font-family: "Noto Sans KR", sans-serif;
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

  .main-content {
    margin-top: 80px;
    position: relative;
  }

  #bottom-menu {
    position: fixed;
    bottom: 0;
    z-index: 999;
    display: flex;
    width: 100%;
    max-width: 420px;
    height: 65px;
    padding: 0;
    background-color: #fff;
  }

  #img-circle {
    min-width: 48px;
    height: 48px;
    border-radius: 24px;
    overflow: hidden;
  }

  .mint-btn {
    background-color: #9be4e4;
    color: #7a69e6;
  }

  .mint-btn:hover {
    background-color: #9be4e4;
    color: #fff;
}

  #post-username {
    font-size: 15px;
    /* font-weight: 600; */
    color: #444;
  }

  #post-time {
    color: #aaa;
    font-size: 13px;
  }

  #post-title {  
    font-weight: 600;
    color: #333;
  }

  #post-content {
    font-size: 14px;
    color: #444;
  }

  #post-upcount {
    font-size: 14px;
    color: #888;
  }

</style>
