import axios from "axios";

// axios 객체 생성
// http://i5b303.p.ssafy.io:80/
export default axios.create({
  baseURL: "http://localhost:8399/",
  headers: {
    "Content-type": "application/json",
  },
});
