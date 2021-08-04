<template>
  <div>
    <div>
      <div class="regist">
        <h1 class="underline top1">지출 등록</h1>
        <hr />
        <div>
          <button class="btn" id="btn_group">수입</button>
          <button class="btn" id="btn_group">지출</button>
        </div>
        <hr />
        <div class="regist_form">
          <div class="float1"><label for="date">날짜</label></div>
          <div class="float2">
            <input
              type="date"
              id="date"
              name="date"
              v-model="date"
              ref="date"
            />
          </div>
          <hr />
          <div class="float1"><label for="price">금액</label></div>
          <div class="float2">
            <input
              type="text"
              id="price"
              name="price"
              v-model="price"
              ref="price"
            />
          </div>
          <hr />
          <div class="float1"><label for="category">카테고리</label></div>
          <div class="float2">
            <input
              readonly
              type="text"
              id="category"
              name="category"
              v-model="category"
              ref="category"
            />
          </div>
          <hr />
          <div class="float1"><label for="contents">메모</label></div>
          <div class="float2">
            <input
              id="contents"
              name="contents"
              v-model="contents"
              ref="contents"
            />
          </div>
          <hr />
          <div>
            <b-list-group>
              <b-list-group-item>
                <b-avatar
                  button
                  @click="eat"
                  variant="primary"
                  text="식비"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="cafe"
                  variant="primary"
                  text="카페"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="alcohol"
                  variant="primary"
                  text="술"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="life"
                  variant="primary"
                  text="생활"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="fashion"
                  variant="primary"
                  text="패션"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="beauti"
                  variant="primary"
                  text="뷰티"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="trafic"
                  variant="primary"
                  text="교통"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="car"
                  variant="primary"
                  text="자동차"
                  class="align-baseline"
                ></b-avatar>
              </b-list-group-item>

              <b-list-group-item>
                <b-avatar
                  button
                  @click="live"
                  variant="primary"
                  text="주거"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="healthy"
                  variant="primary"
                  text="의료"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="fund"
                  variant="primary"
                  text="금융"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="culture"
                  variant="primary"
                  text="문화"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="travel"
                  variant="primary"
                  text="여행"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="edu"
                  variant="primary"
                  text="교육"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="pet"
                  variant="primary"
                  text="반려동물"
                  class="align-baseline"
                ></b-avatar>
                <b-avatar
                  button
                  @click="gift"
                  variant="primary"
                  text="선물"
                  class="align-baseline"
                ></b-avatar>
              </b-list-group-item>
            </b-list-group>
          </div>
          <button class="btn" id="btn_group">등록</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
//// import { mapGetters } from "vuex";
export default {
  name: "",
  computed: {},
  data() {
    return {
      date: "",
      price: "",
      contents: "",
      category: "",
    };
  },
  methods: {
    eat() {
      this.category = "식비";
    },
  },
};
</script>
<style>
.regist {
  padding: 10px;
}

input {
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
  width: 180px;
  margin: 10px;
}

.float {
  display: inline-block;
  width: 25%;
}

.float1 {
  display: inline-block;
  width: 17%;
}
.float2 {
  display: inline-block;
  width: 83%;
}
</style>


