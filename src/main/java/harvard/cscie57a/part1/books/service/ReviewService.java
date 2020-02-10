package harvard.cscie57a.part1.books.service;

import java.util.List;

import harvard.cscie57a.part1.books.exception.BookDeletionException;
import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.model.Review;

public interface ReviewService {

	List<Review> getAllReviewsByBookId(Long bookId);

	Review findReviewByBookId(Long bookId, Long reviewId) throws ResourceNotFoundException;

	Review saveReview(Long bookId, Review review);

	Review updateReview(Long bookId, Long reviewId, Review reviewRequest);

	void deleteReview(Long bookId, Long reviewId) throws BookDeletionException;

}
