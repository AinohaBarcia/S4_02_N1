package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.services;

import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.domain.Fruit;
import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit createFruit (Fruit fruit){
        return fruitRepository.save(fruit);
    }
    public Fruit updateFruit (Fruit fruit){
        Fruit oldFruit = null;
        Optional<Fruit> optionalFruit = fruitRepository.findById(fruit.getId());
        if(optionalFruit.isPresent()){
            oldFruit = optionalFruit.get();
            oldFruit.setName(fruit.getName());
            oldFruit.setAmountKilos(fruit.getAmountKilos());
            fruitRepository.save(oldFruit);
        }else {
            return new Fruit();
        }
        return oldFruit;
    }
    public void deletFruit (Integer id){
        fruitRepository.deleteById(id);
        System.out.println("The fruit with ID " + id + "is delete");
    }
    public Fruit getFruitById (Integer id){
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        return optionalFruit.get();
    }

    public List<Fruit> getAllFruits(){
        return fruitRepository.findAll();
    }




}
