package hasEntities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@OneToMany(mappedBy = "author", targetEntity = Article.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Article> articles;

	public User() {
		this.articles = new ArrayList<>();
	}

	public User(String name) {
		this();
		this.name = name;
	}

	public void addArticle(Article article) {
		this.articles.add(article);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
