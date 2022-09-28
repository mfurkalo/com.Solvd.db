/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.models;

public class Workorderdetail {
    private int id;
    private int quantity;
    private float amount;
    private float total;
    private int workorder_id;
    private int item_id;

    @Override
    public String toString() {
        return "Workorderdetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", total=" + total +
                ", workorder_id=" + workorder_id +
                ", item_id=" + item_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getWorkorder_id() {
        return workorder_id;
    }

    public void setWorkorder_id(int workorder_id) {
        this.workorder_id = workorder_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
