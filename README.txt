build and run instruction 
java -jar demo-0.0.1-SNAPSHOT.jar



use instruction 

 /* registering drone*/
    @PostMapping("/drone/add")




 /* loading drone with medication items*/
    @PostMapping("/drone/medication/add/{id}")


 /* cheking loaaded medication items for a given drone*/
    @PostMapping("/drone/medication/check/{id}")


 /*cheking availables drones for loading*/
    @GetMapping("/drone/forload")


