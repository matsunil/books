package harvard.cscie57a.part1.books.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.exception.ReviewDeletionException;
import harvard.cscie57a.part1.books.model.Review;
import harvard.cscie57a.part1.books.service.ReviewService;

/**
 * API interface
 * 
 */
@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	/**
	 * Get all reviews for the book
	 * Using @PathVariable bookId
	 * @throws ResourceNotFoundException
	 */
	@GetMapping(value = "/books/{bookId}/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllReviewsByBookId(@PathVariable("bookId") Long bookId)
			throws ResourceNotFoundException {
		logger.info("Getting all reviews by bookId: {}", bookId);
		return new ResponseEntity<>(reviewService.getAllReviewsByBookId(bookId), HttpStatus.OK);
	}

	/**
	 * Get review by review id for book by book id
	 * Using @PathVariable bookId
	 * Using @PathVariable reviewId
	 * @throws ResourceNotFoundException 
	 */
	@GetMapping(value = "/books/{bookId}/reviews/{reviewId}")
	public ResponseEntity<?> getReviewByBookIdAndReviewId(@PathVariable("bookId") Long bookId, 
			@PathVariable("reviewId") Long reviewId) throws ResourceNotFoundException {
		logger.info("Getting review with bookId: {} and reviewId:{}", bookId, reviewId);
		return new ResponseEntity<>(reviewService.findReviewByBookId(bookId, reviewId), HttpStatus.OK);
	}

	/**
	 * POST review for book by book id
	 * Using @PathVariable bookId
	 * Using @RequestBody review
	 * @throws ResourceNotFoundException
	 */
	@PostMapping(value = "/books/{bookId}/reviews")
	public ResponseEntity<?> addNewReview(@PathVariable("bookId") Long bookId, @RequestBody Review review)
			throws ResourceNotFoundException {
		logger.info("Adding review: {} with bookId: {}", review, bookId);
		return new ResponseEntity<>(reviewService.saveReview(bookId, review), HttpStatus.CREATED);
	}

	/**
	 * PUT review by review id for book by book id
	 * Using @PathVariable bookId
	 * Using @PathVariable reviewId
	 * Using @RequestBody review
	 * @throws ResourceNotFoundException
	 */
	@PutMapping(value = "/books/{bookId}/reviews/{reviewId}")
	public ResponseEntity<?> updateReview(@PathVariable("bookId") Long bookId,
			@PathVariable("reviewId") Long reviewId, @RequestBody Review review) {
		logger.info("Updating review: {} with bookId: {} and reviewId: {}", review, bookId, reviewId);
		return new ResponseEntity<>(reviewService.updateReview(bookId, reviewId, review), HttpStatus.OK);
	}

	/**
	 * DELETE review by book id and review id
	 * Using @PathVariable bookId
	 * Using @PathVariable reviewId
	 * @throws ReviewDeletionException
	 */
	@DeleteMapping(value = "/books/{bookId}/reviews/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable("bookId") Long bookId, 
			@PathVariable("reviewId") Long reviewId) throws ReviewDeletionException {
		logger.info("Deleting review with bookId: {} and reviewId: {}", bookId, reviewId);
		reviewService.deleteReview(bookId, reviewId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
