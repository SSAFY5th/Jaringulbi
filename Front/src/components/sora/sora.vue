<template>
  <div>
    <div class="row">
      <div>
        <div class="margin">
          <h1>마법의 소라고동</h1>
          <b-img
            :src="require('@/assets/sora.jpg')"
            style="width: 200px"
            class="margin"
          >
          </b-img>
          <div>
            <b-button variant="info" class="margin" v-on:click.once="play()"
              >소라고동 클릭</b-button
            >
            <b-button class="margin" @click="replay()">다시 하기 </b-button>
          </div>
          <div>
            <b-card class="margin">
              <b-card-text>{{ text }}</b-card-text>
            </b-card>
          </div>
          <div><bottom></bottom></div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Bottom from "@/layout/Bottom.vue";
// import { mapGetters } from "vuex";
export default {
  components: { Bottom },
  name: "",
  computed: {},
  data() {
    return {
      text: "",
      num: "",
    };
  },
  //   created() {},
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
.margin {
  margin: 15px;
}
</style>

