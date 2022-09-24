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
import java.util.Date;

@XmlRootElement(name = "Payment")
@XmlType(propOrder = {"id", "receipt_no", "total_amount", "is_paid", "date", "paid_by", "remarks", "processed_by"
        , "workorder_id"})

public class Payment {
    private int id;
    private String receipt_no;
    private float total_amount;
    private boolean is_paid;
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

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getReceipt_no() {
        return receipt_no;
    }

    @XmlElement(name = "receipt_no")
    public void setReceipt_no(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    @XmlElement(name = "total_amount")
    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public boolean isIs_paid() {
        return is_paid;
    }

    @XmlElement(name = "is_paid")
    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public Date getDate() {
        return date;
    }

    @XmlElement(name = "date")
    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaid_by() {
        return paid_by;
    }

    @XmlElement(name = "paid_by")
    public void setPaid_by(String paid_by) {
        this.paid_by = paid_by;
    }

    public String getRemarks() {
        return remarks;
    }

    @XmlElement(name = "remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getProcessed_by() {
        return processed_by;
    }

    @XmlElement(name = "processed_by")
    public void setProcessed_by(int processed_by) {
        this.processed_by = processed_by;
    }

    public int getWorkorder_id() {
        return workorder_id;
    }

    @XmlElement(name = "workorder_id")
    public void setWorkorder_id(int workorder_id) {
        this.workorder_id = workorder_id;
    }
}
