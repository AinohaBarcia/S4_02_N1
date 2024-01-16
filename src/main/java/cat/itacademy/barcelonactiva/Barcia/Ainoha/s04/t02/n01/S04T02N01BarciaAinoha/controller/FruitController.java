package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.controller;

import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.domain.Fruit;
import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private FruitRepository fruitRepository;

    @PostMapping("/createFruit")
    public ResponseEntity<Fruit> createFruit (@RequestBody Fruit fruit){
        Fruit fruitObj =  fruitRepository.save(fruit);

        return new ResponseEntity<>(fruitObj, HttpStatus.OK);
    }

    @PostMapping ("/updateFruitById/{id}")
    public ResponseEntity<Fruit> updateFruitById(@PathVariable Integer id, @RequestBody Fruit newFruitData){

        Optional<Fruit> oldfruiData = fruitRepository.findById(id);

        if(oldfruiData.isPresent()){
            Fruit updsateFruitData = oldfruiData.get();
            updsateFruitData.setName(newFruitData.getName());
            updsateFruitData.setAmountKilos(newFruitData.getAmountKilos());

            Fruit fruitObj = fruitRepository.save(updsateFruitData);
            return new ResponseEntity<>(fruitObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteFruitById/{id}")
    public ResponseEntity<HttpStatus> deleteFruitById (@PathVariable Integer id){
        fruitRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getFruitById/{id}")
    public ResponseEntity<Fruit> getFruitById (@PathVariable ("id") Integer id){
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if(fruitData.isPresent()){
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Fruit>> getAllFruits(){
       try{
           List<Fruit> fruitList = new ArrayList<>();
           fruitRepository.findAll().forEach(fruitList::add);

           if(fruitList.isEmpty()){
               return new ResponseEntity<>(fruitList,HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(HttpStatus.OK);

       }catch (Exception ex){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }




}
