package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
