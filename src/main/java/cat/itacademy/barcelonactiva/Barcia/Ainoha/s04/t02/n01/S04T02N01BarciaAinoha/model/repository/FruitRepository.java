package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.model.repository;

import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit,Integer> {
}
