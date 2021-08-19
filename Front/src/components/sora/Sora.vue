
<template>
  <div>
    <Header></Header>
    <div class="main-content">
      <div id="post-title" class="mt-4">
        <span style="color: #7a69e6">{{ this.$store.state.user.nickname }}</span
        >님, 어떤 고민이 있으신가요? <br />소라고둥님께 물어보세요! <br />
        <br />✨마법의 소라고둥 사용법✨<br />
      </div>
      <span id="post-upcount"> 질문은 한번에 하나씩, </span><br />
      <span id="post-upcount"> 완전한 문장으로 하는 것이 좋습니다 </span><br />
      <span id="post-upcount">
        ex) 취업을 할 수 있을까요? 치킨을 시킬까요?
      </span>
      <div class="mt-3">
        <b-img
          :src="require('@/assets/sora.jpg')"
          style="width: 200px; cursor: pointer; border-radius: 200px"
          class="margin"
          v-on:click.once="play()"
        >
          <b-button
            variant="info"
            class="margin"
            v-on:click.once="play()"
          ></b-button>
        </b-img>
      </div>
      <div id="post-upcount">(사진을 클릭해주세요)</div>
      <div>
        <b-card class="mt-5">
          <b-form-textarea
            v-model="text"
            placeholder="🐚소라고둥님이 뭐라고 답하실까요...?🐚"
          >
            {{ text }}
          </b-form-textarea>
        </b-card>
      </div>
      <div>
        <button class="btn mint-btn mt-3" @click="replay()">다시 하기</button>
      </div>
    </div>
  </div>
</template>
<script>
// import { mapGetters } from "vuex";
import Header from "@/layout/Header.vue";

export default {
  name: "",
  components: { Header },
  computed: {},
  data() {
    return {
      text: "",
      num: "",
    };
  },
  methods: {
    play() {
      var sound = new Audio(require("@/assets/sora_sound.mp3"));

      console.log("play it");
      var audio = new Audio(sound);
      audio.play();
      //   setTimeout(function () {
      //     // 1초 후 sound2.mp3 일시정지
      //     audio.pause();
      //   }, 5000);
      this.num = Math.random() * 21;
      console.log(this.num);
      if (this.num >= 0 && this.num < 1) {
        this.text = "노력 없이는 얻는 것도 없다";
      }
      if (this.num >= 1 && this.num < 2) {
        this.text = "쉽게 생각하라";
      }
      if (this.num >= 2 && this.num < 3) {
        this.text = "다투지 마라";
      }
      if (this.num >= 3 && this.num < 4) {
        this.text = "지는 것이 이기는 것이다";
      }
      if (this.num >= 4 && this.num < 5) {
        this.text = "감사함을 잊지 말아라";
      }
      if (this.num >= 5 && this.num < 6) {
        this.text = "남을 탓하지 마라";
      }
      if (this.num >= 6 && this.num < 7) {
        this.text = "급할수록 돌아가라";
      }
      if (this.num >= 7 && this.num < 8) {
        this.text = "있을 수 없는 일이다";
      }
      if (this.num >= 8 && this.num < 9) {
        this.text = "단순해져라";
      }
      if (this.num >= 9 && this.num < 10) {
        this.text = "부족한 것을 인정하라";
      }
      if (this.num >= 10 && this.num < 11) {
        this.text = "현실 직시";
      }
      if (this.num >= 11 && this.num < 12) {
        this.text = "조급해 하지 말아라";
      }
      if (this.num >= 12 && this.num < 13) {
        this.text = "이 또한 지나간다";
      }
      if (this.num >= 13 && this.num < 14) {
        this.text = "곧 알게 된다";
      }
      if (this.num >= 14 && this.num < 15) {
        this.text = "물론이다";
      }
      if (this.num >= 15 && this.num < 16) {
        this.text = "그때가 지금이다";
      }
      if (this.num >= 16 && this.num < 17) {
        this.text = "때로는 우연에 기대라";
      }
      if (this.num >= 17 && this.num < 18) {
        this.text = "고민이 아니다";
      }
      if (this.num >= 18 && this.num < 19) {
        this.text = "신념을 지켜라";
      }
      if (this.num >= 19 && this.num < 20) {
        this.text = "신중히 행동하라";
      }
      if (this.num >= 20 && this.num < 21) {
        this.text = "후회할 수도 있다";
      }
    },
    replay() {
      var sound = "https://jaringulbi.s3.ap-northeast-2.amazonaws.com/sora.m4a";
      console.log("replay it");
      var audio = new Audio(sound);
      audio.pause();

      this.num = Math.random() * 21;
      console.log(this.num);
      if (this.num >= 0 && this.num < 1) {
        this.text = "노력 없이는 얻는 것도 없다";
      }
      if (this.num >= 1 && this.num < 2) {
        this.text = "쉽게 생각하라";
      }
      if (this.num >= 2 && this.num < 3) {
        this.text = "다투지 마라";
      }
      if (this.num >= 3 && this.num < 4) {
        this.text = "지는 것이 이기는 것이다";
      }
      if (this.num >= 4 && this.num < 5) {
        this.text = "감사함을 잊지 말아라";
      }
      if (this.num >= 5 && this.num < 6) {
        this.text = "남을 탓하지 마라";
      }
      if (this.num >= 6 && this.num < 7) {
        this.text = "급할수록 돌아가라";
      }
      if (this.num >= 7 && this.num < 8) {
        this.text = "있을 수 없는 일이다";
      }
      if (this.num >= 8 && this.num < 9) {
        this.text = "단순해져라";
      }
      if (this.num >= 9 && this.num < 10) {
        this.text = "부족한 것을 인정하라";
      }
      if (this.num >= 10 && this.num < 11) {
        this.text = "현실 직시";
      }
      if (this.num >= 11 && this.num < 12) {
        this.text = "조급해 하지 말아라";
      }
      if (this.num >= 12 && this.num < 13) {
        this.text = "이 또한 지나간다";
      }
      if (this.num >= 13 && this.num < 14) {
        this.text = "곧 알게 된다";
      }
      if (this.num >= 14 && this.num < 15) {
        this.text = "물론이다";
      }
      if (this.num >= 15 && this.num < 16) {
        this.text = "그때가 지금이다";
      }
      if (this.num >= 16 && this.num < 17) {
        this.text = "때로는 우연에 기대라";
      }
      if (this.num >= 17 && this.num < 18) {
        this.text = "고민이 아니다";
      }
      if (this.num >= 18 && this.num < 19) {
        this.text = "신념을 지켜라";
      }
      if (this.num >= 19 && this.num < 20) {
        this.text = "신중히 행동하라";
      }
      if (this.num >= 20 && this.num < 21) {
        this.text = "후회할 수도 있다";
      }
    },
  },
};
</script>
<style scoped>
.mint-btn {
  width: 100%;
  background-color: #9be4e4;
  color: #fff;
  /* border: solid 1px #9be4e4; */
}

.mint-btn:hover {
  border: solid 1px #9be4e4;
  background-color: #fff;
  color: #9be4e4;
}

.main-content {
  padding: 10px 14px 12px 14px;
}

#board-header {
  position: fixed;
  top: 0;
  z-index: 999;
  display: flex;
  width: 100%;
  max-width: 420px;
  height: 65px;
  background-color: #fff;
  box-shadow: 0 2px 8px #ddd;
}

#write-btn {
  position: fixed;
  left: calc(50vw + 120px);
  bottom: 85px;
  z-index: 3;
  width: 60px;
  height: 60px;
  border-radius: 30px;
  background-color: #9be4e4;
  color: #7a69e6;
  font-size: 30pt;
  line-height: 60px;
}
</style>


