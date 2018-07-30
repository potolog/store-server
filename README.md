# store-server


### store 추가
http localhost:8080/stores store_id="111" store_name="아마노"
http localhost:8080/stores store_id="222" store_name="아마노-AKC"

### store 변경
http patch localhost:8080/stores/222 store_name="아마노-AKC-GRAND"



### 메뉴 추가
http localhost:8080/menus menu_id="m-1" menu_name="짜장면" price=8000
http localhost:8080/menus menu_id="m-2" menu_name="탕수육" price=8000 store_id="222"
http localhost:8080/menus menu_id="m-3" menu_name="팔보채" price=8000 store_id="333"
