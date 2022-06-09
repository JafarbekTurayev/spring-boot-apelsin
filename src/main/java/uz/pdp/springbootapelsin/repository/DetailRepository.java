package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.entity.Detail;

public interface DetailRepository extends JpaRepository<Detail,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
