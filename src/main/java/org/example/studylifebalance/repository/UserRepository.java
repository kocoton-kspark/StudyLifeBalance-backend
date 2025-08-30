package org.example.studylifebalance.repository;

import org.example.studylifebalance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    int countByCategory_CategoryId(String categoryId);
    int countByCategory_CategoryIdAndCollege(String categoryId, String college);
    int countByCollege(String college);
//    int count();
}
