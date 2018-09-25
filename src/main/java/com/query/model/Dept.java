package com.query.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="depttable")
public class Dept {

	@Id
	private int deptno;
	
	private String dname;
	private String loc;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Dept(){
		
	}
	public Dept(int deptno, String dname, String loc) {
			super();
			this.deptno = deptno;
			this.dname = dname;
			this.loc = loc;
		}

}
