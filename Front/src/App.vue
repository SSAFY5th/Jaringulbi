<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
  components: {},
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
  position: relative;
  width: 100%;
  max-width: 420px;
  min-height: 100vh;
  overflow: hidden;
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
</style>
