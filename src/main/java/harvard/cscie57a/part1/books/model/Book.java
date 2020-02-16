package harvard.cscie57a.part1.books.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
	@SequenceGenerator(name="book_generator", sequenceName = "book_seq", initialValue = 4, allocationSize=50)
	private Long id;

	@NotNull
    @Size(max = 100)
    @Column(unique = true)
	private String title;

	@NotNull
    @Size(max = 100)
	private String author;
	
	@NotNull
    @Size(max = 100)
	private String publisher;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Review> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", reviews="
				+ reviews + "]";
	}

}
