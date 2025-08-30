package main.java.org.example.studylifebalance.repository;

import main.model.Ment;

@Repository
public interface MentRepository extends JpaRepository<Ment, Long> {

    //랜덤하게 하나의 명언을 조회

    @Query(value = "SELECT * FROM ment ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Ment findRandomMent();

}
