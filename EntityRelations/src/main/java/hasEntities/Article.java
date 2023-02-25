package hasEntities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Basic
	private String text;

	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private User author;

	@ManyToMany
	@JoinTable(
			name = "articles_categories", 
			joinColumns = @JoinColumn(name = "article_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "id"))
	private Set<Categorie> categories;

	public Article() {
		this.categories = new HashSet<>();
	}

	public Article(String text) {
		this();
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
