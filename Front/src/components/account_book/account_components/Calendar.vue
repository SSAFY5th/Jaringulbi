<template>
  <div>
    <Calendar class="calendar" :attributes="attributes" disable-page-swipe>
      <template v-slot:day-content="{ day, attributes }">
        <div>
          <!-- <router-link :to="`/detail`" style="text-decoration: none"> -->
          <div class="cal">
            <span id="cal_title">{{ day.day }}</span>
            <div class="prices" style="font-size: 1pt; margin-top: 30px">
              <p v-for="attr in attributes" :key="attr.key">
                <span style="color: #86b2fa"
                  >+{{ attr.customData.expo | makeComma }}</span
                ><br />
                <span style="color: red">{{
                  attr.customData.impo | makeComma
                }}</span>
                <br />
                <span
                  ><router-link
                    :to="{
                      path: `/accountdetail`,
                      query: {
                        year: attr.year,
                        month: attr.date,
                        day: attr.key + 1,
                      },
                    }"
                    >{{ attr.customData.total | makeComma }}</router-link
                  ></span
                >
                <br />
              </p>
            </div>
          </div>
          <!-- </router-link> -->
        </div>
      </template>
    </Calendar>
  </div>
</template>

<script>
import { Calendar } from "v-calendar";
import { mapGetters } from "vuex";

var month = new Date().getMonth() + 1;
console.log("month : " + month);
if (month < 10) month = "0" + month;
const year = new Date().getFullYear();
const day = new Date().getDate();
const full = year + "-" + month + "-" + day;

export default {
  components: {
    Calendar,
  },
  computed: {
    ...mapGetters(["accountbooks"]),
  },
  created() {
    this.$store.dispatch("getAccountBooks", { full: full });
  },

  data() {
    const month = new Date().getMonth();
    const year = new Date().getFullYear();
    let monthIncomes = [];
    let monthOutgoings = [];

    monthIncomes = this.$store.state.accountbooks.incomes
      .replace("[", "")
      .replace("]", "")
      .split(",");
    // console.log(monthIncomes);
    monthOutgoings = this.$store.state.accountbooks.outgoings
      .replace("[", "")
      .replace("]", "")
      .split(",");
    // console.log(monthIncomes);
    let customData;
    let eachAttr;

    let attr = [];
    for (let i = 0; i < monthIncomes.length; i++) {
      if (monthIncomes[i] == "null") {
        monthIncomes[i] = 0;
        console.log(monthIncomes[i]);
      }
      if (monthOutgoings[i] == "null") {
        monthOutgoings[i] = 0;
      }
      customData = {};
      eachAttr = {};
      customData["expo"] = Number(monthIncomes[i]);
      customData["impo"] = Number(monthOutgoings[i]);
      customData["total"] = Number(monthIncomes[i]) + Number(monthOutgoings[i]);

      eachAttr["year"] = year;
      eachAttr["date"] = month;
      eachAttr["key"] = i;
      eachAttr["customData"] = customData;
      eachAttr["dates"] = `${year}-${month + 1}-${i + 1}`;

      // eachAttr["popover"] = popover;
      // popover["label"] = "라벨 ㅎ";

      attr.push(eachAttr);
      // console.log(attr);
    }

    // arr1 = console.log(arr[1]);

    // for (var i = 1; i < this.$store.state.accountbooks.incomes.length; i++) {
    //   plus = arr.push(String(this.$store.state.accountbooks.incomes[i]));
    // }
    console.log("store에 저장된 날짜 : " + attr[0].dates);
    console.log("store 저장된 배열 : " + this.$store.state.accountbooks);
    // console.log(plus);
    // console.log("arr배열 : " + arr[0]);

    return {
      attributes: attr,
    };
  },
  methods: {},
};
</script>
<style scoped>
.custom-calendar {
  width: 50px;
}

.calendar {
  margin-top: 20px;
  width: 100%;
}

.cal {
  border: 1px solid #b8c2cc;
  width: 100%;
  height: 106px;
  text-align: left;
  font-weight: bold;
}

#cal_title {
  margin-left: 5px;
}

.prices {
  font-size: 1pt;
  margin-top: 30px;
  text-align: right;
  margin-right: 5px;
  font-weight: bold;
}
</style>