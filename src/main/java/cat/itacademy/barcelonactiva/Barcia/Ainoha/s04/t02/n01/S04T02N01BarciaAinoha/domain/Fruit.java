package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.n01.S04T02N01BarciaAinoha.domain;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Fruits")
@Setter
@Getter
@ToString
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float amountKilos;

}
