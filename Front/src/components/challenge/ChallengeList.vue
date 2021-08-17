<template>
  <tr>
    <td>id : {{ id }}</td>
    <td>contents : {{ contents }}</td>
    <td>reward : {{ reward }}</td>
    <td>entry_fee : {{ entry_fee }}</td>
    <td>description : {{ description }}</td>
  </tr>
</template>
<script>
export default {
  name: "challengelist",
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
