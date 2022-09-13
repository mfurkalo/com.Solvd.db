/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.models;

public class Item {
    private int id;
    private String name;
    private String description;
    private String serial_no;
    private float amount;
    private int item_category;
    private int encoded_by;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serial_no='" + serial_no + '\'' +
                ", amount=" + amount +
                ", item_category=" + item_category +
                ", encoded_by=" + encoded_by +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getItem_category() {
        return item_category;
    }

    public void setItem_category(int item_category) {
        this.item_category = item_category;
    }

    public int getEncoded_by() {
        return encoded_by;
    }

    public void setEncoded_by(int encoded_by) {
        this.encoded_by = encoded_by;
    }
}
