
<template>
  <div>
    <Header></Header>
    <div class="main-content">
      <div id="post-title" class="mt-5">
        {{ this.$store.state.user.nickname }}님, 어떤 고민이 있으신가요?
        <br />소라고둥님께 물어보세요! <br />
      </div>
       <span id="post-upcount"> ex) 치킨 시킬까요? 말까요? </span>
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
        <b-card class=" mt-5">
          <b-form-textarea
            v-model="text"
            placeholder="소라고둥님 명령 대기중..."
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
      var sound =
        "https://docs.google.com/uc?export=open&id=1eC7sDbpWRBOIr9FBEn1UbsDsJD9tvjIg";
      console.log("play it");
      var audio = new Audio(sound);
      audio.play();
      //   setTimeout(function () {
      //     // 1초 후 sound2.mp3 일시정지
      //     audio.pause();
      //   }, 5000);
      this.num = Math.random() * 3;
      console.log(this.num);
      if (this.num >= 0 && this.num < 1) {
        this.text = "안돼";
      }
      if (this.num >= 1 && this.num < 2) {
        this.text = "돼";
      }
      if (this.num >= 2 && this.num < 3) {
        this.text = "가만히 있어";
      }
    },
    replay() {
      var sound =
        "https://docs.google.com/uc?export=open&id=1eC7sDbpWRBOIr9FBEn1UbsDsJD9tvjIg";
      console.log("replay it");
      var audio = new Audio(sound);
      audio.pause();

      this.num = Math.random() * 3;
      console.log(this.num);
      if (this.num >= 0 && this.num < 1) {
        this.text = "안돼";
      }
      if (this.num >= 1 && this.num < 2) {
        this.text = "돼";
      }
      if (this.num >= 2 && this.num < 3) {
        this.text = "가만히 있어";
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


