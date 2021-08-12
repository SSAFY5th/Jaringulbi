<template>
  <div class="mt-5">
    <p class="">404 page not found</p>

    <router-link :to="{ name: 'Home' }">
      <button class="btn btn-lg mint-btn mt-4">
        홈으로 돌아가기
      </button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'PageNotFound',

}
</script>

<style>
  .mint-btn {
    background-color: #9be4e4;
    color: #7a69e6;
  }
  .mint-btn:hover {
    background-color: #9be4e4;
    color: #fff;
  }
</style>