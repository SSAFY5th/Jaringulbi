<template>
  <div class="row" id="challenge">
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
    <div>
      <div>{{ title }}</div>
      <div>
        {{ start_date.date.year }}-{{ start_date.date.month }}-{{
          start_date.date.day
        }}~{{ end_date.date.year }}-{{ end_date.date.month }}-{{
          end_date.date.day
        }}
      </div>
      <div>참가비 : {{ entry_fee }}굴비</div>
      <div>보상 : {{ reward }}굴비</div>
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
<style scope>
#image {
  width: 90%;
  height: 120px;
  margin: 14px;
  border-radius: 20px;
}

#challenge {
  display: inline-block;
  width: 50%;
}
</style>
