package harvard.cscie57a.part1.books.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.exception.ReviewDeletionException;
import harvard.cscie57a.part1.books.model.Book;
import harvard.cscie57a.part1.books.model.Review;
import harvard.cscie57a.part1.books.repository.BookRepository;
import harvard.cscie57a.part1.books.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<Review> getAllReviewsByBookId(Long bookId) throws ResourceNotFoundException {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (optionalBook.isPresent()) {
			logger.info("Found book with id: {}", bookId);
			return reviewRepository.findByBookId(bookId);
		}
		
		throw new ResourceNotFoundException("No book found with id="+bookId);
	}

	@Override
	public Review findReviewByBookId(Long bookId, Long reviewId) throws ResourceNotFoundException {
		Optional<Review> review = reviewRepository.findByIdAndBookId(reviewId, bookId);
		if (review.isPresent()) {
			logger.info("Found review with bookId: {} and reviewId: {}", bookId, reviewId);
			return review.get();
		}

		throw new ResourceNotFoundException("No review found with bookId="+bookId+ " and reviewId="+reviewId);
	}

	@Override
	public Review saveReview(Long bookId, Review review) throws ResourceNotFoundException {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (optionalBook.isPresent()) {
			logger.info("Found book with id: {}", bookId);

			Book book = optionalBook.get();
			review.setId(null); //review id set by sequence
			review.setBook(book);

			return reviewRepository.save(review);
		}

		throw new ResourceNotFoundException("No book found with id="+bookId);
	}

	@Override
	public Review updateReview(Long bookId, Long reviewId, Review reviewRequest) throws ResourceNotFoundException {
		Optional<Review> optionalReview = reviewRepository.findByIdAndBookId(reviewId, bookId);
		if (optionalReview.isPresent()) {
			logger.info("Found review with bookId: {} and reviewId: {}", bookId, reviewId);

			Review review = optionalReview.get();
			review.setName(reviewRequest.getName());
			review.setEmail(reviewRequest.getEmail());
			review.setContent(reviewRequest.getContent());

			return reviewRepository.save(review);
		}

		throw new ResourceNotFoundException("No review found with bookId="+bookId+" and reviewId="+reviewId);
	}

	@Override
	public void deleteReview(Long bookId, Long reviewId) throws ReviewDeletionException, ResourceNotFoundException {
		Optional<Review> optionalReview = reviewRepository.findByIdAndBookId(reviewId, bookId);
		if (optionalReview.isPresent()) {
			logger.info("Found review with bookId: {} and reviewId: {}", bookId, reviewId);

			Review review = optionalReview.get();
			try {
				reviewRepository.delete(review);
			} catch(Exception e) {
				throw new ReviewDeletionException("Exception deleting review with id="+bookId+" and reviewId="+reviewId);
			}
		} else {
			throw new ResourceNotFoundException("No review found with bookId="+bookId+" and reviewId="+reviewId);
		}
	}

}
