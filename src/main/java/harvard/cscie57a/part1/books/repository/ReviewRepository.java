package harvard.cscie57a.part1.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import harvard.cscie57a.part1.books.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}