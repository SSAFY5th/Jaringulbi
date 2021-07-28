<template>
  <div class="row">
    <div class="col-xs-6 col-md-2"></div>
    <div class="col-xs-6 col-md-4">로고가 들어올 공간입니당</div>
    <div class="col-xs-6 col-md-4">
      <b-navbar type="dark" variant="dark">
        <b-navbar-nav>
          <b-nav-item href="/">Home</b-nav-item>
          <b-nav-item-dropdown text="User" left>
            <b-dropdown-item href="/login">로그인</b-dropdown-item>
            <b-dropdown-item href="/signup">회원가입</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-navbar>
    </div>
    <div class="col-xs-6 col-md-2"></div>
  </div>
</template>

<script>
export default {
  name: "Header",
  methods: {},
};
</script>
<style>
</style>

