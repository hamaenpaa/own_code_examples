package fi.agileo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Book {
	private String isbn, tekijat, nimi;

	public Book() {
		
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTekijat() {
		return tekijat;
	}

	public void setTekijat(String tekijat) {
		this.tekijat = tekijat;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", tekijat=" + tekijat + ", nimi=" + nimi + "]";
	}
}
