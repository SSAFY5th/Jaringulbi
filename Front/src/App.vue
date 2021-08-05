<template>
  <div id="app" class="">
    <div id="home" class="bg-secondary">
      <router-view />
<<<<<<< HEAD
      <div id="bottom-menu" class="justify-content-center">
        <Bottom></Bottom>
      </div>
=======
>>>>>>> feature/FE/AccountPage-5
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
<<<<<<< HEAD
  font-family: 'Noto Sans KR', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
=======
  font-family: "Noto Sans KR", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

>>>>>>> feature/FE/AccountPage-5
  background-color: #eee;
}

#home {
  margin: 0 auto;
  position: relative;
  width: 100%;
  max-width: 420px;
  min-height: 100vh;
  overflow: hidden;
}

<<<<<<< HEAD
  #bottom-menu {
  position: fixed;
  bottom: 0;
  z-index: 999;  
=======
#bottom-menu {
  position: fixed;
  bottom: 0;
  z-index: 999;
>>>>>>> feature/FE/AccountPage-5
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 65px;
  padding: 15px 0;
  color: white;
<<<<<<< HEAD
  background-color: #fff;
=======
>>>>>>> feature/FE/AccountPage-5
}
</style>
