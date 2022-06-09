package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
