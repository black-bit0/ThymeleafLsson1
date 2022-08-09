package com.example.thymeleaflsson1.repository;


import com.example.thymeleaflsson1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM Books JOIN Authors ON books.author_Id = authors.id" +
            " WHERE Upper(authors.author_Name) = UPPER (:name)",
    nativeQuery = true)
    List<Book> getBooksByAuthorName(String name);

    @Query(value = "SELECT * " +
            "FROM Books " +
            "WHERE sold_amount  = ( SELECT MAX(sold_amount) FROM Books);",
    nativeQuery = true)
    List<Book> getMostSellingBook();

    @Query(value = "SELECT * " +
            "FROM Books " +
            "WHERE published_amount = ( SELECT MAX(published_amount) FROM Books);",
            nativeQuery = true)
    List<Book> getMostPublishedBook();



    @Query(value = "SELECT b FROM Book b " +
            "JOIN Author a  " +
            "ON a.id = b.authorId " +
            "WHERE a.authorName LIKE %:partName% ")
    List<Book> getBooksByAuthorPartName(@Param("partName") String partName);


}
