<template id="font">
  <tr>
    <td>{{ image }}</td>
    <td>{{ content }}</td>
    <!-- <td>
      <router-link :to="`/board/view?isbn=${isbn}`">{{ author }}</router-link>
    </td> -->
  </tr>
</template>
<script>
export default {
  name: "list",
  props: {
    image: String,
    content: String,
  },
  methods: {},
};
</script>
<style scope>
</style>
