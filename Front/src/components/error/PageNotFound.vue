<template>
  <div class="mt-5">
    <div class="main-content">
      <b-img :src="require('@/assets/logo.png')" class="mt-5"></b-img>
      <h4 class="mt-4" id="post-title">404 Page Not Found</h4>

      <router-link :to="{ name: 'Home' }">
        <button class="btn btn-lg mt-5" id="mint-btn">홈으로 돌아가기</button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "PageNotFound",
};
</script>

<style>
#mint-btn {
  background-color: #9be4e4;
  color: #fff;
  /* color: #7a69e6; */
}
#mint-btn:hover {
  border: solid 1px #9be4e4;
  background-color: #fff;
  color: #9be4e4;

}
</style>