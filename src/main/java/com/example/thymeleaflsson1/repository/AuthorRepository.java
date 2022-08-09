package com.example.thymeleaflsson1.repository;

import com.example.thymeleaflsson1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT COUNT(AUTHOR_ID) AS POPULARITY, AUTHORS.* FROM BOOKS " +
            "INER JOIN AUTHORS " +
            "ON AUTHORS.ID = AUTHOR_ID " +
            "GROUP BY AUTHORS.ID " +
            "HAVING MAX(POPULARITY) " +
            "LIMIT 1",
    nativeQuery = true)
    Optional<String> getMostPopularAuthor();
}
