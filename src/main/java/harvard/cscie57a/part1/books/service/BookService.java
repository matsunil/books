package harvard.cscie57a.part1.books.service;

import java.util.List;

import harvard.cscie57a.part1.books.exception.BookDeletionException;
import harvard.cscie57a.part1.books.exception.ResourceNotFoundException;
import harvard.cscie57a.part1.books.model.Book;

public interface BookService {

	List<Book> findAllBooks();

	Book findBookById(Long bookId) throws ResourceNotFoundException;

	Book saveBook(Book book);

	void deleteBook(Long bookId) throws BookDeletionException;

}
