<template>
  <div>
    <div id="mypage-header">
      <div
        class="d-flex justify-content-center align-self-center px-3"
        style="width: 100%"
      >
        <div class="text-center">
          <span>가계부 상세보기</span>
        </div>
      </div>
    </div>
    <div class="main-content">
      <div>
        <div>
          <p>{{ date }}</p>
          <p>{{ price }}</p>
          <p>{{ used }}</p>
          <p>{{ contents }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    id: Number,
    date: String,
    price: Number,
    category: Number,
    used: String,
    contents: String,
    user_id: Number,
  },
};
</script>
<style scoped>
#mypage-header {
  position: fixed;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 65px;
  background-color: #fff;
  color: #222;
  box-shadow: 0 2px 8px #ddd;
  text-align: center;
}

.form-area {
  padding: 10px 14px 12px 14px;
}
#image {
  width: 100px;
  height: 100%;
  border-radius: 100%;
  margin-bottom: 40px;
}

.float1 {
  width: 35%;
}

.float2 {
  width: 65%;
  text-align: left;
}

.sign-up-link {
  color: #333;
  font-weight: 600;
  cursor: pointer;
}

.sign-up-link:hover {
  color: #7a69e6;
  font-weight: 600;
}
</style>