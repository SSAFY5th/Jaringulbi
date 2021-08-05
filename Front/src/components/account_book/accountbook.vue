
<template>
  <div class="row">
    <div><acheader></acheader></div>
    <hr />
    <div>
      <div class="float">수입</div>
      <div class="float">지출</div>
      <div class="float">합계</div>
      <div class="float">자산</div>
    </div>
    <div>
      <div class="float">{{ impo }}원</div>
      <div class="float">{{ expo }}원</div>
      <div class="float">{{ total }}원</div>
      <div class="float">{{ asset }}원</div>
    </div>
    <hr />

    <div>
      <calendar></calendar>
    </div>
    <div>
      <router-link :to="`/registaccount`"
        ><b-button variant="primary" class="rounded-circle px-2 circle"
          ><b-icon icon="plus" scale="2"></b-icon></b-button
      ></router-link>
    </div>
  </div>
</template>
<script>
import Acheader from "@/layout/AC_Header.vue";
import Calendar from "@/components/account_book/account_components/Calendar.vue";

export default {
  name: "",
  components: {
    Acheader,
    Calendar,
  },
  computed: {},
  data() {
    return {
      impo: "",
      expo: "",
      total: "",
      asset: "",
      date: new Date(),
    };
  },
  methods: {},
};
</script>
<style scoped>
.float {
  display: inline-block;
  width: 25%;
}

#calendar {
  height: 495px;
}
</style>