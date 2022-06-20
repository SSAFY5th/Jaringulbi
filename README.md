# 🐟자린굴비

![image](https://user-images.githubusercontent.com/26705587/174597543-4ecc39e1-0e8a-44e9-b4d9-b4b97e559787.png)



## 😎대전없는대전팀

|   Name   |                            왕영문                            |                            이산하                            |                            임현우                            |                            하태린                            |
| :------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| Profile  | <img width="200" src="https://user-images.githubusercontent.com/26705587/127587609-21e853bb-f47a-4989-af09-c0e0a9107d33.png"> | <img width="200" src="https://user-images.githubusercontent.com/26705587/127587653-eace5871-dda2-46c7-a75b-1faaf7e5be20.png"> | <img width="200" src="https://user-images.githubusercontent.com/26705587/127587569-fd28267a-99ee-4228-98f3-578193ac8a3a.png"> | <img width="200" src="https://user-images.githubusercontent.com/26705587/127587865-a754c895-67f4-4654-82e0-13c49820512e.png"> |
| Position |                Project leader &<br />Backend                 |                Frontend &<br />UX/UI, Design                 |                    Frontend &<br /> UI/UX                    |                    Backend & <br />DevOps                    |
|  GitHub  |            [@wym6764](https://github.com/wym6764)            |           [@sana0803](https://github.com/sana0803)           |         [@hyunwoo-sl](https://github.com/hyunwoo-sl)         |           [@hataerin](https://github.com/hataerin)           |

<br><br>

## 📌프로젝트 소개

자린굴비는 쉽고 직관적인 **가계부** 기능을 바탕으로,<br>
사용자간의 **소통** 및 **챌린지** 기능을 제공하는 **소셜 네트워크형 자산관리 서비스**입니다.<br>

자린굴비는 MZ세대의 **새로운 재테크 문화**를 만들어 갑니다. 

<br><br>

## 📺 시연영상

> 사진을 클릭하면 유튜브 페이지로 이동합니다

<p align='middle'><a href="https://www.youtube.com/watch?v=93zr21d3FSE" target="_blank"><img src="https://user-images.githubusercontent.com/26705587/174597211-7adac617-b7ae-431b-b7eb-0141486da1e0.png" width="600px"/></a></p>

<br><br>

## 🚧아키텍처

![image](https://user-images.githubusercontent.com/26705587/174601765-6cc2e810-3812-4be4-a572-1d086cef65d5.png)

## 🔨  설치 및 실행방법

### Font-end

1. 자린굴비 프론트 이미지 받아오기

   ```shell
   $ docker pull hotoron/jaringulbi-vue-dockerize
   ```

2. 자린굴비 프론트 도커 실행하기

   ```shell
   $ docker run -d -p 80:80 --rm --name jaringulbi-vue hotoron/jaringulbi-vue-dockerize
   ```

   </br>

### Back-end

1. 자린굴비 백엔드 이미지 받아오기

   ``` shell
   $ docker pull hotoron/jaringulbi-spring-dockerize
   ```

2. 자린굴비 백엔드 도커 실행하기

   ``` shell
   $ docker run -d -p 8399:8399 --rm --name jaringulbi-spring hotoron/jaringulbi-spring-dockerize
   ```

</br>

### Database

1. mysql 이미지 받아오기

   ``` shell
   $ docker pull mysql
   ```

2. 자린굴비 DB 도커 실행하기

   ```shell
   $ docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name jaringulbi-mysql mysql
   ```

3. MySQL 접속해서 `b303.sql` 실행하기 (첨부파일 참조)

4. CSV파일로 더미데이터 집어넣기 (첨부파일 참조)

</br>

</br>



## 🚩주요기능

1. **가계부 기능**

   <img src="https://user-images.githubusercontent.com/26705587/174598919-a6536e5e-2b97-4ea0-89c9-7ce9f377f8cf.png" height="300px"/>

   <br>

2. **챌린지 기능**

   <img src="https://user-images.githubusercontent.com/26705587/174598977-302a29f4-55c4-40eb-b8b2-4a3ff4f8100a.png" height="300px"/>

   <br>

3. **커뮤니티 기능**

   <img src="https://user-images.githubusercontent.com/26705587/174599035-458d1da4-d791-4e52-a221-d0ee1c497f79.png" height="300px"/>

   <br>

   <br><br>





## 📚WIKI

👉[대전없는 대전팀 협업방법 보러가기](https://lab.ssafy.com/s05-webmobile2-sub2/S05P12B303/-/wikis/home)👈

<br>

### 📆Daily Scrum & Wrap-up

| 회의             | 월                                      | 화                                                           | 수                                                           | 목                                                           | 금                                      | 회고             |
| ---------------- | :-------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | --------------------------------------- | :--------------- |
| [🧐Sprint 회의]() | **26**<br>🌞Scrum <br>🌛Wrap-up           | **27**<br/>[🌞Scrum](https://lab.ssafy.com/s05-webmobile2-sub2/S05P12B303/-/wikis/09.-Daily-Scrum#anchor-20210727) <br/>[🌛Wrap-up](https://lab.ssafy.com/s05-webmobile2-sub2/S05P12B303/-/wikis/10.-Daily-Warp-up#anchor-20210727) | **28**<br/>[🌞Scrum](https://lab.ssafy.com/s05-webmobile2-sub2/S05P12B303/-/wikis/09.-Daily-Scrum#anchor-20210728) <br/>[🌛Wrap-up](https://lab.ssafy.com/s05-webmobile2-sub2/S05P12B303/-/wikis/10.-Daily-Warp-up#anchor-20210728) | **29**<br/>[🌞Scrum](https://lab.ssafy.com/s05-webmobile2-sub2/S05P12B303/-/wikis/09.-Daily-Scrum#anchor-20210729) <br/>[🌛Wrap-up](https://lab.ssafy.com/s05-webmobile2-sub2/S05P12B303/-/wikis/10.-Daily-Warp-up#anchor-20210729) | **30**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]() | [🤔Sprint 회고]() |
| [🧐Sprint 회의]() | **2**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()  | **3**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                       | **4**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                       | **5**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                       | **6**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()  | [🤔Sprint 회고]() |
| [🧐Sprint 회의]() | **9**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()  | **10**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                      | **11**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                      | **12**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                      | **13**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]() | [🤔Sprint 회고]() |
| [🧐Sprint 회의]() | **16**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]() | **17**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                      | **18**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                      | **19**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]()                      | **20**<br/>[🌞Scrum]() <br/>[🌛Wrap-up]() | [🤔Sprint 회고]() |

