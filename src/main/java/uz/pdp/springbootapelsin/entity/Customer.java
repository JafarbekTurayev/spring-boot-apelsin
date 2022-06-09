package uz.pdp.springbootapelsin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //serial
    private Integer id;

    @Column(nullable = false, length = 14)
    private String name;

    @Column(nullable = false, length = 3)
    private String country;

    @Column(columnDefinition = "text")
    private String address; //255tadan ko'proq belgini qabul qila oladi

    @Column(length = 50)
    private String phone;


}
