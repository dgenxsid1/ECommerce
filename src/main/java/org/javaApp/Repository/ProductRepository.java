package org.javaApp.Repository;

import org.javaApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //reason to extend from JpaRepository is to expoilt some of the exisitng methods that it provides
    //for example findAll

}
