package harvard.cscie57a.part1.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import harvard.cscie57a.part1.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}