package com.ayushspring.ecommerce.repo;

import com.ayushspring.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //JPQL - JP query language
    @Query("SELECT p from Product p WHERE "+"lower(p.name) LIKE lower(CONCAT('%',:keyWord,'%')) OR " +
            "lower(p.brand) LIKE lower(CONCAT('%',:keyWord,'%')) OR " +
            "lower(p.category) LIKE lower(CONCAT('%',:keyWord,'%')) OR " +
            "lower(p.description) LIKE lower(CONCAT('%',:keyWord,'%'))")
    List<Product> searchProducts(String keyWord);
}
