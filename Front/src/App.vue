<template>
  <div id="app">
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
    letter-spacing: -.4px;
    background-image: url('https://imgur.com/fsTlQvU.png');
    background-position: left 0;
    background-attachment: fixed;
    background-size: cover;
    background-repeat: no-repeat;
    /* background-color: #eee; */
    /* background: rgb(215,238,238);
    background: linear-gradient(140deg,
  rgba(215,238,238,1) 17%, 
  rgba(238,238,238,1) 67%,
  rgba(229,226,241,1) 100%); */
  }

  #home {
    margin-left: 53%;
    padding-bottom: 65px;
    position: relative;
    width: 100%;
    max-width: 422px;
    min-height: 100vh;
    overflow: hidden;
    background-color: #fff;
    border-left: solid 1px #eee;
    border-right: solid 1px #eee;
  }

  /* @media only screen and (min-width: 421px) and (max-width: 1024px)
  #home {
    margin: 0 auto;
  } */

  .main-content {
    margin-top: 65px;
    position: relative;
    color: #222;
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

  #profile-img {
    width: 68px;
    height: 68px;
    border-radius: 34px;
    overflow: hidden;
  }

  #img-circle {
    min-width: 48px;
    width: 48px;
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

  #main-title {
    color: #222;
    font-weight: 600;
    font-size: 19px;
  }

  #post-username {
    font-size: 15px;
    /* font-weight: 600; */
    color: #444;
  }

  #post-username-bold {
    font-size: 15px;
    font-weight: 600;
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
