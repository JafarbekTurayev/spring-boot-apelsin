package uz.pdp.springbootapelsin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //serial
    private Integer id;

    //order_id
    @OneToOne
    private Order order;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @CreatedDate //sistemadan oladi
    private Date issued;

    //xozirgi +3 kun
    private Date due;
}
