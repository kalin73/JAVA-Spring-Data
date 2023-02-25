package hasEntities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Basic
	private String name;

	@ManyToMany(targetEntity = Article.class, mappedBy = "categories")
	private Set<Article> articles;

	public Categorie() {
		this.articles = new HashSet<>();
	}

	public Categorie(String name) {
		this();
		this.name = name;
	}

}
