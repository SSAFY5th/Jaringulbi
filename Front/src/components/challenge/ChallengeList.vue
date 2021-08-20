<template>
  <div id="challenge" class="mb-3">
    <div class="chlg-list-wrap">
      <router-link
        :to="{
          path: `/challenge/detail/${id}`,
          query: { name: image },
        }"
        class="text-decoration-none"
      >
        <div class="chlg-img-wrap">
          <img :src="image"
            class="chlg-thumbnail"
            alt="챌린지 이미지"/>
        </div>
        <div id="post-title" class="my-2">{{ title }}</div>
      </router-link>
      <div id="post-time" class="">
        {{ start_date.date.year }}-{{ start_date.date.month }}-{{
          start_date.date.day
        }}~{{ end_date.date.year }}-{{ end_date.date.month }}-{{
          end_date.date.day
        }}
      </div>
      <div id="post-content">참가비  {{ entry_fee }}굴비</div>
      <div id="post-content">보상  {{ reward }}굴비</div>
    </div>
  </div>
</template>
<script>
export default {
  name: "challengelist",
  props: {
    id: Number,
    title: String,
    start_date: String,
    end_date: String,
    entry_fee: Number,
    reward: Number,
    image: String,
    description: String,
  },
  methods: {},
};
</script>
<style>
.chlg-img-wrap {
  width: 100%;
  height: 100%;
  overflow: hidden;  
  border-radius: 12px;
}

.chlg-thumbnail {
  width: 100%;
  height: 120px;
  object-fit: cover;
}

.chlg-thumbnail:hover {
  filter: blur(3px);
  -webkit-filter: blur(3px);
  transition: 500ms cubic-bezier(0.19, 1, 0.22, 1);
}

#challenge {
  display: inline-block;
  width: 50%;
  text-align: left;
  vertical-align: top;
}

.chlg-list-wrap {
  margin-right: 10px;  
}
</style>
