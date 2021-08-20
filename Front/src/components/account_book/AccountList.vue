<template>
  <div>
    <div>
      <div class="form-area text-start">
        <div>
          <div class="d-flex justify-content-between align-items-center mt-2">
            <span id="post-content">{{ date }}</span>
            <span style="color: #7a69e6; font-size: 18px; font-weight: 600">
              {{ price }} 원
            </span>
          </div>
          <div class="d-flex align-items-center mt-3">
            <span id="post-upcount" class="me-3">사용처</span>
            <span id="post-title">{{ used }}</span>
          </div>
          <div class="d-flex align-items-center mb-1">
            <span id="post-upcount" class="me-3">내용</span>
            <span id="post-title">{{ contents }}</span>
          </div>
        </div>
        <!-- <div class="d-flex justify-content-between">
          <span style="color: #888"> {{ date }} </span>
          <span @click="signup" class="sign-up-link"> {{ price }} </span>
        </div> -->
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
.form-area {
  padding: 12px 14px 12px 14px;
  border-bottom: solid 1px #eee;
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