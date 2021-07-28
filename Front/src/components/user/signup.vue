<template>
  <div class="row">
    <div class="col-xs-6 col-md-2"></div>
    <div class="col-xs-6 col-md-4"></div>
    <div class="col-xs-6 col-md-4">
      <b-container id="mainImage">
        <div id="font">
          <div class="back" id="font">
            <div class="underline title">회원 가입</div>
          </div>
          <div class="regist_form">
            <label for="id">ID</label>
            <input type="text" id="id" name="id" v-model="id" ref="id" />
            <label for="pwd">비밀번호</label>
            <input
              type="password"
              id="pwd"
              name="pwd"
              v-model="pwd"
              ref="pwd"
            /><br />
            <label for="name">이름</label>
            <input
              type="text"
              id="name"
              name="name"
              v-model="name"
              ref="name"
            /><br />
            <label for="price">Email</label>
            <input
              type="email"
              id="email"
              name="email"
              v-model="email"
              ref="email"
            /><br />
            <label for="phone">Phone</label><br />
            <input
              type="tel"
              id="phone"
              name="phone"
              v-model="phone"
              ref="phone"
            /><br />
            <label for="address">주소</label><br />
            <input
              type="text"
              id="address"
              name="address"
              v-model="address"
              ref="address"
            /><br />
            <button @click="checkValue" class="btn" id="btn_group">가입</button>
          </div>
        </div>
      </b-container>
    </div>
    <div class="col-xs-6 col-md-2"></div>
  </div>
</template>
<script></script>
<style scoped>
@keyframes tracking-in-expand {
  0% {
    letter-spacing: -0.5em;
    opacity: 0;
  }
  40% {
    opacity: 0.6;
  }
  100% {
    opacity: 1;
  }
}
@font-face {
  font-family: "CookieRunOTF-Bold";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

#font {
  font-family: CookieRunOTF-Bold;
}
.title {
  animation: tracking-in-expand 0.7s cubic-bezier(0.215, 0.61, 0.355, 1) both;
  color: black;
  font-size: 40px;
  text-shadow: 5px 5px #558abb;
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
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

#btn_group {
  border: 1px solid skyblue;
  background-color: rgba(0, 0, 0, 0);
  color: skyblue;
  padding: 5px;
  width: 150px;
  margin-left: 14px;
  margin-top: 23px;
}

#btn_group:hover {
  color: white;
  background-color: skyblue;
}
</style>
