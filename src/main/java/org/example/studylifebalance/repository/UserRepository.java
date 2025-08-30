package org.example.studylifebalance.repository;

import org.example.studylifebalance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    int countByCategoryId(String categoryID);
    int countByCategoryIdAndCollege(String categoryID, String college);
    int countByCollege(String college);
//    int count();
}
