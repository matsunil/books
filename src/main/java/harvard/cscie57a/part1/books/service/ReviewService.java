package harvard.cscie57a.part1.books.service;

import java.util.List;

import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.exception.ReviewDeletionException;
import harvard.cscie57a.part1.books.model.Review;

public interface ReviewService {

	List<Review> getAllReviewsByBookId(Long bookId) throws ResourceNotFoundException;

	Review findReviewByBookId(Long bookId, Long reviewId) throws ResourceNotFoundException;

	Review saveReview(Long bookId, Review review) throws ResourceNotFoundException;

	Review updateReview(Long bookId, Long reviewId, Review reviewRequest) throws ResourceNotFoundException;

	void deleteReview(Long bookId, Long reviewId) throws ReviewDeletionException, ResourceNotFoundException;

}
