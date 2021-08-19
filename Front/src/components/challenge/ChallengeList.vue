<template>
  <div id="challenge">
    <div>
      <router-link
        :to="{
          path: `/challenge/detail/${id}`,
          query: { name: image },
        }"
      >
        <img alt="list" :src="image" id="image"
      /></router-link>
    </div>
    <div id="post-title">{{ title }}</div>
    <div id="post-time">
      {{ start_date.date.year }}-{{ start_date.date.month }}-{{
        start_date.date.day
      }}~{{ end_date.date.year }}-{{ end_date.date.month }}-{{
        end_date.date.day
      }}
    </div>
    <div id="post-content">참가비 : {{ entry_fee }}굴비</div>
    <div id="post-content">보상 : {{ reward }}굴비</div>
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
    status: Number,
  },
  methods: {},
};
</script>
<style scope>
#image {
  width: 98%;
  height: 120px;
  border-radius: 12px;
}

#challenge {
  display: inline-block;
  width: 50%;
  text-align: left;
}
</style>
