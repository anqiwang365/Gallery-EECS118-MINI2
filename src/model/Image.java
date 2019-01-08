package model;

public class Image {
	
	public int iId;
	public String title;
	public String link;
	public int gId;
	public int aId;
	public int dId;
	public String name;
	public int year;
	public String type;
	public int width;
	public int height;
	public String location;
	public String des;
//	public Detail detail;
//	public Artist artist;
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	
	public void setYear(int year) {
		this.year = year;
		
	}
	
	public int getYear() {
		return year;
	}

	public void setType(String type) {
		this.type = type;
		
	}
	
	public String getType() {
		return type;
	}
	
	public void setWidth(int width) {
		this.width = width;
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
		
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setLocation(String location) {
		this.location=location;
		
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setDes(String des) {
		this.des = des;
		
	}
	public String getDes() {
		return this.des;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
}
