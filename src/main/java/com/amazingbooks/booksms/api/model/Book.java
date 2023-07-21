package com.amazingbooks.booksms.api.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="books")
public class Book {
	@Id
	private Long isbn;
	private String title;
	private String authorName;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date publishedDate;
	private Integer totalCopies;
	private Integer issuedCopies;
	
	public Book() {
		super();
	}
	
	public Book(Long isbn, String title, String authorName, Date publishedDate, Integer totalCopies, Integer issuedCopies) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.authorName = authorName;
		this.publishedDate = publishedDate;
		this.totalCopies = totalCopies;
		this.issuedCopies = issuedCopies;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Integer getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}
		
	public Integer getIssuedCopies() {
		return issuedCopies;
	}

	public void setIssuedCopies(Integer issuedCopies) {
		this.issuedCopies = issuedCopies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName, isbn, publishedDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authorName, other.authorName) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(publishedDate, other.publishedDate) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", authorName=" + authorName + ", publishedDate="
				+ publishedDate + ", totalCopies=" + totalCopies + "]";
	}
}
