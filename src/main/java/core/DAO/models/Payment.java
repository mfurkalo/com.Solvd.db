/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.models;

import java.util.Date;

public class Payment {
    private int id;
    private String receipt_no;
    private float total_amount;
    private  boolean is_paid;
    private Date date;
    private String paid_by;
    private String remarks;
    private int processed_by;
    private int workorder_id;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", receipt_no='" + receipt_no + '\'' +
                ", total_amount=" + total_amount +
                ", is_paid=" + is_paid +
                ", date=" + date +
                ", paid_by='" + paid_by + '\'' +
                ", remarks='" + remarks + '\'' +
                ", processed_by=" + processed_by +
                ", workorder_id=" + workorder_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceipt_no() {
        return receipt_no;
    }

    public void setReceipt_no(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public boolean isIs_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaid_by() {
        return paid_by;
    }

    public void setPaid_by(String paid_by) {
        this.paid_by = paid_by;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getProcessed_by() {
        return processed_by;
    }

    public void setProcessed_by(int processed_by) {
        this.processed_by = processed_by;
    }

    public int getWorkorder_id() {
        return workorder_id;
    }

    public void setWorkorder_id(int workorder_id) {
        this.workorder_id = workorder_id;
    }
}
