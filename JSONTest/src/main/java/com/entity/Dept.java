package com.entity;

public class Dept {
    private Integer deptNo;
    private String dname;
    private String location;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Dept() {
    }

    public Dept(Integer deptNo, String dname, String location) {
        this.deptNo = deptNo;
        this.dname = dname;
        this.location = location;
    }
}
