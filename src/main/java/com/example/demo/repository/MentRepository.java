package com.example.demo.repository;

import com.example.demo.model.Ment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MentRepository extends JpaRepository<Ment, Long> {

    /**
     * 랜덤하게 하나의 명언을 조회
     * MySQL: ORDER BY RAND()
     * PostgreSQL: ORDER BY RANDOM()
     * H2: ORDER BY RAND()
     */
    @Query(value = "SELECT * FROM ment ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Ment findRandomMent();

    /**
     * 대안: JPA 방식 (성능은 떨어지지만 DB 독립적)
     */
    // @Query("SELECT m FROM Ment m ORDER BY FUNCTION('RANDOM')")
    // List<Ment> findRandomMentJPA();
}
