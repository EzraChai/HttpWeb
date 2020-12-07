package com.entity;

public class city {
    private Integer id;
    private String name;
    private Integer stateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public city() {
    }

    public city(Integer id, String name, Integer stateId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
    }
}
