package com.apress.ejb.chapter02;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SearchFacadeLocal {
    List wineSearch(String wineType);
}
