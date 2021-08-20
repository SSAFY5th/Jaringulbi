<template>
  <div>
    <div id="regist-account-header">
      <div
        class="d-flex justify-content-center align-self-center px-3"
        style="width: 100%"
      >
        <div class="text-center">
          <span>지출 등록</span>
        </div>
      </div>
    </div>
    <div id="font" class="main-content">
      <div class="regist">
        <!-- <h1 class="underline top1">지출 등록</h1> -->
        <!-- <hr /> -->
        <div>
          <button class="btn" id="btn_group" @click="plus">수입</button>
          <button class="btn" id="btn_group" @click="minus">지출</button>
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
          <!-- <hr /> -->
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
          <!-- <hr /> -->
          <div class="float1"><label for="category">카테고리</label></div>
          <div class="float3">
            <input
              readonly
              type="text"
              id="category"
              name="category"
              v-model="category"
              ref="category"
            />
          </div>
          <div class="float3">
            <b-button v-b-modal.modal-center id="btn_group_category"
              >카테고리 선택</b-button
            >
            <div v-if="this.if == 1">
              <b-modal
                ref="my-modal"
                id="modal-center"
                hide-footer
                centered
                title="카테고리 지출"
                ><div id="group_category">
                  <button class="btn_modal" @click="eat">식비</button>
                  <button class="btn_modal" @click="cafe">카페/간식</button>
                  <button class="btn_modal" @click="alcohol">음주/유흥</button>
                  <button class="btn_modal" @click="life">생활</button>
                </div>
                <div>
                  <button class="btn_modal" @click="fashion">패션/쇼핑</button>
                  <button class="btn_modal" @click="beauti">뷰티/미용</button>
                  <button class="btn_modal" @click="trafic">교통</button>
                  <button class="btn_modal" @click="car">자동차</button>
                </div>
                <div>
                  <button class="btn_modal" @click="live">주거/통신</button>
                  <button class="btn_modal" @click="healthy">의료/건강</button>
                  <button class="btn_modal" @click="fund">금융</button>
                  <button class="btn_modal" @click="culture">문화/여가</button>
                </div>
                <div>
                  <button class="btn_modal" @click="travel">여행/숙박</button>
                  <button class="btn_modal" @click="edu">교육/학습</button>
                  <button class="btn_modal" @click="gift">반려동물</button>
                  <button class="btn_modal" @click="pet">경조/선물</button>
                </div>
              </b-modal>
            </div>
            <div v-else>
              <b-modal
                ref="my-modal"
                id="modal-center"
                hide-footer
                centered
                title="카테고리 수입"
                ><div id="group_category">
                  <button class="btn_modal" @click="salary">급여</button>
                  <button class="btn_modal" @click="pocket">용돈</button>
                  <button class="btn_modal" @click="fundmoney">금융수입</button>
                  <button class="btn_modal" @click="businessmoney">
                    사업수입
                  </button>
                  <button class="btn_modal" @click="etcmoney">기타수입</button>
                </div>
              </b-modal>
            </div>
          </div>
          <!-- <hr /> -->
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
          <!-- <hr /> -->
          <div class="float1"><label for="contents">내용</label></div>
          <div class="float2">
            <input
              id="contents"
              name="contents"
              v-model="contents"
              ref="contents"
            />
          </div>
          <!-- <hr /> -->
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
      category: "",
      categorynum: "",
      used: "",
      contents: "",
      userid: "",
      if: "0",
    };
  },
  methods: {
    registAccountBook() {
      console.log("가계부 등록");
      let err = true;
      let msg = "";
      !this.date &&
        ((msg = "날짜를 입력해주세요."),
        (err = false),
        this.$refs.date.focus());
      !this.price &&
        ((msg = "금액을 입력해주세요."),
        (err = false),
        this.$refs.price.focus());
      !this.category &&
        ((msg = "카테고리를 입력해주세요"),
        (err = false),
        this.$refs.category.focus());
      !this.used &&
        ((msg = "장소를 입력해주세요"),
        (err = false),
        this.$refs.category.focus());
      !this.contents &&
        ((msg = "내용을 입력해주세요."),
        (err = false),
        this.$refs.contents.focus());
      if (!err) alert(msg);

      http
        .post("/accountbook", {
          date: this.date,
          price: this.price,
          category: this.categorynum,
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
      this.categorynum = 1;
      this.$refs["my-modal"].hide();
    },
    cafe() {
      this.category = "카페/간식";
      this.categorynum = 2;
      this.$refs["my-modal"].hide();
    },
    alcohol() {
      this.category = "술/유흥";
      this.categorynum = 3;
      this.$refs["my-modal"].hide();
    },
    life() {
      this.category = "생활";
      this.categorynum = 4;
      this.$refs["my-modal"].hide();
    },
    fashion() {
      this.category = "패션/쇼핑";
      this.categorynum = 5;
      this.$refs["my-modal"].hide();
    },
    beauti() {
      this.category = "뷰티/미용";
      this.categorynum = 6;
      this.$refs["my-modal"].hide();
    },
    trafic() {
      this.category = "교통";
      this.categorynum = 7;
      this.$refs["my-modal"].hide();
    },
    car() {
      this.category = "자동차";
      this.categorynum = 8;
      this.$refs["my-modal"].hide();
    },
    live() {
      this.category = "주거/통신";
      this.categorynum = 9;
      this.$refs["my-modal"].hide();
    },
    healthy() {
      this.category = "의료/건강";
      this.categorynum = 10;
      this.$refs["my-modal"].hide();
    },
    fund() {
      this.category = "금융";
      this.categorynum = 11;
      this.$refs["my-modal"].hide();
    },
    culture() {
      this.category = "문화/여가";
      this.categorynum = 12;
      this.$refs["my-modal"].hide();
    },
    travel() {
      this.category = "여행/숙박";
      this.categorynum = 13;
      this.$refs["my-modal"].hide();
    },
    edu() {
      this.category = "교육/학습";
      this.categorynum = 14;
      this.$refs["my-modal"].hide();
    },
    pet() {
      this.category = "반려동물";
      this.categorynum = 15;
      this.$refs["my-modal"].hide();
    },
    gift() {
      this.category = "경조/선물";
      this.categorynum = 16;
      this.$refs["my-modal"].hide();
    },
    salary() {
      this.category = "급여";
      this.categorynum = 17;
      this.$refs["my-modal"].hide();
    },
    pocket() {
      this.category = "용돈";
      this.categorynum = 18;
      this.$refs["my-modal"].hide();
    },
    fundmoney() {
      this.category = "금융수입";
      this.categorynum = 19;
      this.$refs["my-modal"].hide();
    },
    businessmoney() {
      this.category = "사업수입";
      this.categorynum = 20;
      this.$refs["my-modal"].hide();
    },
    etcmoney() {
      this.category = "기타수입";
      this.categorynum = 21;
      this.$refs["my-modal"].hide();
    },
    plus() {
      this.price = "";
      this.if = 0;
    },
    minus() {
      this.price = "-";
      this.if = 1;
    },
  },
};
</script>
<style>
#regist-account-header {
  position: fixed;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 80px;
  background-color: #fff;
  color: #222;
  box-shadow: 0 2px 8px #ddd;
  text-align: center;
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
  background-color: #9be4e4;
  color: #9175f3;
  border: 1px solid #9175f3;
  padding: 5px;
  width: 180px;
  margin: 10px;
}

#btn_group_category {
  background-color: #9be4e4;
  color: #9175f3;
  border: 1px solid #9175f3;
  padding: 5px;
  width: 120px;
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

.float3 {
  display: inline-block;
  width: 40%;
}

.btn_modal {
  display: inline-block;
  width: 25%;
  border: 1px solid #9175f3;
  background-color: #9be4e4;
  color: #9175f3;
}
</style>


