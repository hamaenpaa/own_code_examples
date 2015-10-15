package fi.agileo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean
public class BookMap {
	
    private TreeMap<String, Book> kirjat;
    
    public BookMap() {
        kirjat = new TreeMap<String, Book>();
        Book kirja1 = new Book();
        kirja1.setIsbn("951-0-23861-9");
        kirja1.setTekijat("Arto Paasilinna");
        kirja1.setNimi("Hirnuva maailmanloppu: kylmäverinen totuus suomenhevosten jalostuksen yltiöpäisistä saavutuksista");
        Book kirja2 = new Book();
        kirja2.setIsbn("951-1-05939-4");
        kirja2.setTekijat("Veikko Huovinen");
        kirja2.setNimi("Koirankynnen leikkaaja");
        Book kirja3 = new Book();
        kirja3.setIsbn("951-1-762-102-7");
        kirja3.setTekijat("Tietotekniikan liiton sanastoryhmä");
        kirja3.setNimi("ATK-sanakirja");
        Book kirja4 = new Book();
        kirja4.setIsbn("978-951-846-264-7");
        kirja4.setTekijat("Ari Rantala");
        kirja4.setNimi("Web-ohjelmointi");
        kirjat.put(kirja1.getIsbn(), kirja1);
        kirjat.put(kirja2.getIsbn(), kirja2);
        kirjat.put(kirja3.getIsbn(), kirja3);
        kirjat.put(kirja4.getIsbn(), kirja4);
    }

    public List<Book> getBookList() {
    	return new ArrayList<Book>(kirjat.values());
    }
    
	public TreeMap<String, Book> getKirjat() {
		return kirjat;
	}

	public void setKirjat(TreeMap<String, Book> kirjat) {
		this.kirjat = kirjat;
	}

	public static Object getManagedBean(String beanName) {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    Object bean;
	     
	    try {
	        ELContext elc = fc.getELContext();
	        bean = elc.getELResolver().getValue(elc, null,
	          beanName);
	    } catch (RuntimeException e) {
	        throw new FacesException(e.getMessage(), e);
	    }
	 
	    if (bean == null) {
	        throw new FacesException("bean not found.");
	    }
	    return bean;
	}	
	
	
	public String addBook() {
		Book book = (Book)getManagedBean("book");
		kirjat.put(book.getIsbn(), book);
		return "index";
	}

}
