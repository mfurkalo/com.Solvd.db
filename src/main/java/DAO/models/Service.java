/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Service")
@XmlType(propOrder = { "id", "name", "description", "amount" })
public class Service {
    private int id;
    private String name;
    private String description;
    private float amount;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
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

    public String getDescription() {
        return description;
    }
    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }
    @XmlElement(name = "amount")
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
