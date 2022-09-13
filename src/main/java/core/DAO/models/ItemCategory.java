/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.models;

public class ItemCategory {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
