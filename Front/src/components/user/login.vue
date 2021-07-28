<template>
  <div class="row">
    <div class="col-xs-6 col-md-2"></div>
    <div class="col-xs-6 col-md-4"></div>
    <div class="col-xs-6 col-md-4">
      <b-container id="mainImage" class="top-login">
        <div class="login-back">
          <b-row>
            <div class="login top list" id="font">
              <div class="login_form">
                <label for="id">ID</label><br />
                <input
                  type="text"
                  id="id"
                  name="id"
                  v-model="id"
                  ref="id"
                /><br />
                <label for="pwd">비밀번호</label><br />
                <input
                  type="password"
                  id="pwd"
                  name="pwd"
                  v-model="pwd"
                  ref="pwd"
                  @keyup.enter="checkValue"
                /><br />
                <button
                  class="btn"
                  @keyup.enter="checkValue"
                  @click="checkValue"
                >
                  로그인
                </button>
                <button class="btn">아이디 찾기</button>
                <button class="btn">비밀번호 찾기</button>
              </div>
            </div>
          </b-row>
        </div>
      </b-container>
    </div>
    <div class="col-xs-6 col-md-2"></div>
  </div>
</template>
<script></script>
<style scoped>
@font-face {
  font-family: "CookieRunOTF-Bold";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

.top {
  background-color: white;
}

button {
  margin: 5px;
  background-color: skyblue;
}

#font {
  font-family: CookieRunOTF-Bold;
}

.regist {
  padding: 10px;
}
.regist_form {
  text-align: left;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input,
textarea,
.view {
  width: 60%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}
</style>
