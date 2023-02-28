package entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
	@Column(nullable = false)
	private Date date;

	@Column(name = "comments")
	private String comment;

	public Visitation() {

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
