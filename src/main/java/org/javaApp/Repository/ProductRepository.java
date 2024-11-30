package org.javaApp.Repository;

import org.javaApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //reason to extend from JpaRepository is to expoilt some of the exisitng methods that it provides
    //for example findAll


    //spring data Jpa
    List<Product> findByNameContaining(String name);

    //JPQL --> this is dB agnostic, the query gets converted to whatever dB we using(SQL, Postgres etc)

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    List<Product> findByNameOrDescriptionContaining(@Param("keyword") String name);

    //Native Query
    //instead of JPQL, one can directly write mySQL query
    //pass in nativeQuery = true
    //no longer DB AGNOSTIC ( if we change our dB from SQL to postgres it will not work)
    //Generally not recommended --> last resort
}
