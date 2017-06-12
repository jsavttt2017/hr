package cn.mldn.vo;

import java.io.Serializable;

public class Areaplus implements Serializable {
	private Integer apid;
	private Area area;
	private String title;
	public Integer getApid() {
		return apid;
	}
	public void setApid(Integer apid) {
		this.apid = apid;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
