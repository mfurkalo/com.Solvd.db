/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ItemCategory")
@XmlType(propOrder = {"id", "name"})

public final class ItemCategory {
    private int id;
    private String name;

    public ItemCategory() {
    }

    private ItemCategory(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

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

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        private int id;
        private String name;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public ItemCategory build() {
            return new ItemCategory(this);
        }
    }
}
