build and run instruction 
java -jar demo-0.0.1-SNAPSHOT.jar

use postman only json request 

use instruction 

 /* registering drone*/
 Post  ("127.0.0.1:8080/drone/add")

{
    "serialnumber": 1019,
    "model": "Middleweight",
    "states": "IDLE",
  "bateryCapacity": 100.00
}


 /* loading drone with medication items*/
    @PostMapping("/drone/medication/add/{id}")


 /* cheking loaaded medication items for a given drone*/
    @PostMapping("/drone/medication/check/{id}")


 /*cheking availables drones for loading*/
    @GetMapping("/drone/forload")

/*check  drone battery level for a given drone*/
/drone/batterystatus/{id}


the battery leveñ  log  into  console
please hold on 