<template>
  <div>
    <div id="font">
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
          <div class="float1"><label for="used">장소</label></div>
          <div class="float2">
            <input
              type="text"
              id="used"
              name="used"
              v-model="used"
              ref="used"
            />
          </div>
          <hr />
          <div class="float1"><label for="contents">내용</label></div>
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
            <b-button v-b-modal.modal-center id="btn_group"
              >카테고리 선택</b-button
            >
            <b-modal
              ref="my-modal"
              id="modal-center"
              hide-footer
              centered
              title="카테고리 분류"
              ><div>
                <button class="btn_modal" @click="eat">식비</button>
                <button class="btn_modal" @click="cafe">카페</button>
                <button class="btn_modal" @click="alcohol">음주</button>
                <button class="btn_modal" @click="life">생활</button>
              </div>
              <div>
                <button class="btn_modal" @click="fashion">패션</button>
                <button class="btn_modal" @click="beauti">뷰티</button>
                <button class="btn_modal" @click="trafic">교통</button>
                <button class="btn_modal" @click="car">자동차</button>
              </div>
              <div>
                <button class="btn_modal" @click="live">주거</button>
                <button class="btn_modal" @click="healthy">의료</button>
                <button class="btn_modal" @click="fund">금융</button>
                <button class="btn_modal" @click="culture">문화</button>
              </div>
              <div>
                <button class="btn_modal" @click="travel">여행</button>
                <button class="btn_modal" @click="edu">교육</button>
                <button class="btn_modal" @click="gift">선물</button>
                <button class="btn_modal" @click="pet">반려동물</button>
              </div>
            </b-modal>
          </div>

          <button class="btn" id="btn_group" @click="registAccountBook">
            등록
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import http from "@/util/http-common";
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
      used: "",
      userid: "",
    };
  },
  methods: {
    registAccountBook() {
      console.log("가계부 등록");
      let err = true;
      let msg = "";
      err &&
        !this.date &&
        ((msg = "날짜를 입력해주세요."),
        (err = false),
        this.$refs.date.focus());
      err &&
        !this.price &&
        ((msg = "금액을 입력해주세요."),
        (err = false),
        this.$refs.price.focus());
      err &&
        !this.category &&
        ((msg = "카테고리를 입력해주세요"),
        (err = false),
        this.$refs.category.focus());
      err &&
        !this.used &&
        ((msg = "장소를 입력해주세요"),
        (err = false),
        this.$refs.category.focus());
      err &&
        !this.contents &&
        ((msg = "내용을 입력해주세요."),
        (err = false),
        this.$refs.contents.focus());
      if (!err) alert(msg);

      http
        .post("/accountbook", {
          date: this.date,
          price: this.price,
          category: this.category,
          used: this.used,
          contents: this.contents,
          userid: this.userid,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push("/accountbook");
        });
    },
    eat() {
      this.category = "식비";
      this.$refs["my-modal"].hide();
    },
    cafe() {
      this.category = "카페";
      this.$refs["my-modal"].hide();
    },
    alcohol() {
      this.category = "술";
      this.$refs["my-modal"].hide();
    },
    life() {
      this.category = "생활";
      this.$refs["my-modal"].hide();
    },
    fashion() {
      this.category = "패션";
      this.$refs["my-modal"].hide();
    },
    beauti() {
      this.category = "뷰티";
      this.$refs["my-modal"].hide();
    },
    trafic() {
      this.category = "교통";
      this.$refs["my-modal"].hide();
    },
    car() {
      this.category = "자동차";
      this.$refs["my-modal"].hide();
    },
    live() {
      this.category = "주거";
      this.$refs["my-modal"].hide();
    },
    healthy() {
      this.category = "의료";
      this.$refs["my-modal"].hide();
    },
    fund() {
      this.category = "금융";
      this.$refs["my-modal"].hide();
    },
    culture() {
      this.category = "문화";
      this.$refs["my-modal"].hide();
    },
    travel() {
      this.category = "여행";
      this.$refs["my-modal"].hide();
    },
    edu() {
      this.category = "교육";
      this.$refs["my-modal"].hide();
    },
    pet() {
      this.category = "반려동물";
      this.$refs["my-modal"].hide();
    },
    gift() {
      this.category = "선물";
      this.$refs["my-modal"].hide();
    },
  },
};
</script>
<style>
#font {
  font-family: CookieRunOTF-Bold;
}

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
  width: 20%;
}
.float2 {
  display: inline-block;
  width: 80%;
}

.btn_modal {
  display: inline-block;
  width: 25%;
  border: 1px solid skyblue;
  background-color: rgba(0, 0, 0, 0);
  color: skyblue;
}
</style>


