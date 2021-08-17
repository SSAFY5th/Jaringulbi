<template>
  <div>
    <div class="row">
      <div>{{ image }}</div>
      <div>{{ contents }}</div>
      <div>{{ start_date }} ~ {{ end_date }}</div>
      <div>참가비용 : {{ entry_fee }} 보상 : {{ reward }}</div>
    </div>
  </div>
</template>
<script>
export default {
  name: "list",
  props: {
    id: Number,
    start_date: String,
    end_date: String,
    contents: String,
    entry_fee: Number,
    reward: Number,
    image: String,
    description: String,
  },
  methods: {},
};
</script>
<style scope>
</style>
