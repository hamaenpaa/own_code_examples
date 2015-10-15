package com.titan.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="CABIN")
public class Cabin implements java.io.Serializable 
{
    private int id;
    private String name;
    private int deckLevel;
    private int shipId;
    private int bedCount;

    @Id
    @Column(name="CABIN_ID")
    public int getId()
    {
	return id;
    }
    public void setId(int pk) 
    {
	id = pk;
    }

    @Column(name="CABIN_NAME")
    public String getName()
    {
        return name;
    }
    public void setName(String str)
    {
	name = str;
    }

    @Column(name="CABIN_DECK_LEVEL")
    public int getDeckLevel() 
    {
	return deckLevel;
    }
    public void setDeckLevel(int level)
    {
	deckLevel = level;
    }

    @Column(name="CABIN_SHIP_ID")
    public int getShipId()
    {
	return shipId;
    }
    public void setShipId(int sid)
    {
	shipId = sid;
    }

    @Column(name="CABIN_BED_COUNT")
    public int getBedCount() 
    { 
	return bedCount; 
    }
    public void setBedCount(int bed) 
    { 
	bedCount = bed; 
    }
}

 

    
    

    
