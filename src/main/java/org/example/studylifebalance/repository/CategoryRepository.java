package org.example.studylifebalance.repository;

import org.example.studylifebalance.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    @Modifying
    @Query("UPDATE Category c SET c.count = c.count + 1 WHERE c.categoryID = :categoryID")
    int incrementCountByCategoryID(String categoryID);

    Category findByCategoryID(String categoryID);
}
