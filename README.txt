build and run instruction 
java -jar demo-0.0.1-SNAPSHOT.jar

use postman only json request 

use instruction 

 /* registering drone*/
 Post  ("127.0.0.1:8080/drone/add")

{
    "serialnumber":  "1019 ",
    "model": "Middleweight",
    "states": "IDLE",
  "bateryCapacity": 100.00
}


 /* loading drone with medication items*/
 Post ("127.0.01:8080/drone/medication/add/{dron id}")
{
    "image": "/images/oxxi.jpg",
    "name": "OXXI",
    "weight": 20,
    "code": "AX_12"
}


 /* cheking loaaded medication items for a given drone*/
 GET ("/drone/medication/check/{drone id}")


 /*cheking availables drones for loading*/
 GET   ("127.0.0.1:8080/drone/forload")

/*check  drone battery level for a given drone*/
 GET ("127.0.0.1:8080/drone/batterystatus/{drone id}")
      


the battery leveñ  log  into  console
please hold on 