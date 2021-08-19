<template>
  <div id="challenge" class="mb-3">
    <div class="chlg-list-wrap">
      <div>
        <router-link
          :to="{
            path: `/challenge/detail/${id}`,
            query: { name: image },
          }"
        >
          <img :src="image" id="image" alt="챌린지 이미지"
        /></router-link>
      </div>
      <div id="post-title" class="my-2">{{ title }}</div>
      <div id="post-time" class="">
        {{ start_date.date.year }}-{{ start_date.date.month }}-{{
          start_date.date.day
        }}~{{ end_date.date.year }}-{{ end_date.date.month }}-{{
          end_date.date.day
        }}
      </div>
      <div id="post-content">참가비 {{ entry_fee }}굴비</div>
      <div id="post-content">보상 {{ reward }}굴비</div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";

export default {
  name: "mylist",
  props: {
    key: Number,
    id: Number,
    title: String,
    start_date: String,
    end_date: String,
    entry_fee: Number,
    reward: Number,
    image: String,
    description: String,
    status: Number,
  },
  data() {
    return {};
  },
  computed: {
    ...mapGetters(["myChallenge"]),
  },
  methods: {},
  created() {
    const id = this.$store.state.user.id;
    console.log("created : " + id);
    this.$store.dispatch("getmyChallenge", { id: id });
  },
};
</script>
<style scope>
#image {
  width: 98%;
  height: 120px;
  object-fit: cover;
  border-radius: 12px;
}

#challenge {
  display: inline-block;
  width: 50%;
  text-align: left;
}
</style>
