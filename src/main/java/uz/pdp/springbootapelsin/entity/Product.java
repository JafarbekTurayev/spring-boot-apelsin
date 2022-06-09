package uz.pdp.springbootapelsin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //serial
    private Integer id;

    @Column(length = 10)
    private String name;

    @ManyToOne
    private Category category; //category_id

    @Column(length = 20)
    private String description;

    @Column(precision = 6, scale = 2)
    private BigDecimal price; //1111.00

    @Column(length = 1024)
    private String photo; //photoUrl -> lokal kompdan url orqali faylni topib kelish
}
