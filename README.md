# Progmod2 Egyeni Beadandó
Egyszerű java applikáció, CRUD web-es megfelelőivel (POST, PUT, GET, DELETE)
Mindez egy MySQL adatbázishoz csatlakozik, amit külön ehhez hoztam létre

## Adatok amiket el tud tárolni az alkalmazás
* ID
* Autó típusa
* Autó rendszámtáblája
* Autó alvázszáma

## Interfacet használ

## ELérhető funkciók:
* GET
  * getCars ==> adatbázis teljes tartalmát visszaadja
  
  ```example
  @GetMapping("/car")
    public Iterable<car> getCars(){
        return carRepo.findAll();
    }
  ```
  
* POST
  * saveCars ==> elmenti az adatbázis elemeit, minden változtatással
  
  ```example
  @PostMapping("/save")
    public String saveCars(@RequestBody car Car){
        ****
        return "SUCCESS";
    }
  ```
  
* PUT
  * updateCars ==> ID alapján újra bekéri az autó adatait, majd menti is a változatásokat
  
  ```example
  @PutMapping("/update/{id}")
    public String updateCar(@PathVariable long id, @RequestBody car Car){
        ****
        return "SUCCESS";
    }
  ```
  
* DELETE
  * deleteCar ==> ID alapján kitörli az adatbázisból az autót
  
  ```example
  @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable long id){
        ****
        return "SUCCESS";
    }
  ```
  
