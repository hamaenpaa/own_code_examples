package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	protected int id;
	protected String ISBN;
	protected String name;
	protected String description;
	protected int pagecount;
	protected int pubYear;
	protected String publisher;
	protected String authors;
	
	public Book() {}
	
	@Id
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }

	public String getISBN() { return this.ISBN; }
	public void setISBN(String ISBN) { this.ISBN = ISBN; }
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
    public String getDescription() { return this.description; }
	public void setDescription(String description) { this.description = description; }
	
	public String getPublisher() { return this.publisher; }
	public void setPublisher(String publisher) { this.publisher = publisher; }
	
    public String getAuthors() { return this.authors; }
	public void setAuthors(String authors) { this.authors = authors; }
	
    public int getPubYear() { return this.pubYear; }
	public void setPubYear(int pubYear) { this.pubYear = pubYear; }

    public int getPageCount() { return this.pagecount; }
	public void setPageCount(int pagecount) { this.pagecount = pagecount; }
}
