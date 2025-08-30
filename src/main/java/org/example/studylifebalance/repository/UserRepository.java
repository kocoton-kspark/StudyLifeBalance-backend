package org.example.studylifebalance.repository;

import org.example.studylifebalance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    int countByCategoryID(String categoryID);
    int countByCategoryIDAndCollege(String categoryID, String college);
    int countByCollege(String college);
    int count();
}
