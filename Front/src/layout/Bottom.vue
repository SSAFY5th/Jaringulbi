<template>
  <div id="bottom-nav">
    <nav>
      <div class="nav-icon">
        <router-link :to="{ name: 'Accountbook' }">
          <b-icon icon="calculator" aria-hidden="true"></b-icon>
          <p class="nav-name m-0">가계부</p>
        </router-link>      
      </div>
      <div class="nav-icon">
        <router-link :to="{ name: 'Board' }">
          <b-icon icon="chat-square-text" aria-hidden="true"></b-icon>
          <p class="nav-name m-0">커뮤니티</p>
        </router-link>
      </div>
      <div class="nav-icon">
        <router-link :to="{ name: 'Home' }">
          <b-icon icon="house" aria-hidden="true"></b-icon>
          <p class="nav-name m-0">홈</p>
        </router-link>
      </div>
      <div class="nav-icon">
        <router-link :to="{ name: 'Challenge' }">
          <b-icon icon="flag" aria-hidden="true"></b-icon>
          <p class="nav-name m-0">챌린지</p>
        </router-link>
      </div>
      <div class="nav-icon">
        <router-link :to="{ name: 'Login' }">
          <b-icon icon="person" aria-hidden="true"></b-icon>
          <p class="nav-name m-0">마이페이지</p>
        </router-link>
      </div>
    </nav>
  </div>
</template>
 
<script>
export default {
  name: "Bottom",
  computed: {},
  data() {
    return {};
  },
  methods: {},
};
</script>
 
<style scoped>
  #bottom-nav {
    position: relative;
    width: 100%;
    height: 65px;
  }

  .nav-icon {
    display: inline-block;
    width: 20%;
    height: 100%;
    font-size: 14pt;
    padding-top: 5px;
  }

  .nav-icon > a {
    text-decoration: none;
    color: #222;
  }

  .nav-icon > a:hover {
    color: #9be4e4;
    /* color: #7a69e6; */
  }

  .nav-icon > a.router-link-exact-active {
    color: #9be4e4;
  }

  .nav-name {
    font-size: 11px;
  }
</style>