<template>
  <div>
    <Calendar
      class="calendar"
      :attributes="attributes"
      disable-page-swipe
      is-expanded
    >
      <template v-slot:day-content="{ day, attributes }">
        <div class="cal">
          <span>{{ day.day }}</span>
          <div style="font-size: 2pt">
            <p v-for="attr in attributes" :key="attr.key">
              {{ attr.customData.title }}
            </p>
          </div>
        </div>
      </template>
    </Calendar>
  </div>
</template>

<script>
import { Calendar } from "v-calendar";

export default {
  components: {
    Calendar,
  },
  data() {
    const month = new Date().getMonth();
    const year = new Date().getFullYear();
    return {
      attributes: [
        {
          key: 1,
          customData: {
            title: "1,000,000",
          },
          dates: new Date(year, month, 1),
        },
      ],
    };
  },
};
</script>
<style scoped>
.custom-calendar {
  width: 50px;
}

.calendar {
  width: 100%;
}

.cal {
  border: 1px solid #b8c2cc;
  width: 100%;
  height: 105px;
}
</style>