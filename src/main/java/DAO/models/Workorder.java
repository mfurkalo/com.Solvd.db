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

@XmlRootElement(name = "Workorder")
@XmlType(propOrder = {"id", "request_date", "amount", "estimate_date", "status", "remarks", "customer_id", "technician_id," +
        "processed_by_id", "service_id"})

public class Workorder {
    private int id;
    private Date request_date;
    private float amount;
    private Date estimate_date;
    private int status;
    private String remarks;
    private int customer_id;
    private int technician_id;
    private int processed_by_id;
    private int service_id;

    @Override
    public String toString() {
        return "Workorder{" +
                "id=" + id +
                ", request_date=" + request_date +
                ", amount=" + amount +
                ", estimate_date=" + estimate_date +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", customer_id=" + customer_id +
                ", technician_id=" + technician_id +
                ", processed_by_id=" + processed_by_id +
                ", service_id=" + service_id +
                '}';
    }

    public int getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public Date getRequest_date() {
        return request_date;
    }

    @XmlElement(name = "request_date")
    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public float getAmount() {
        return amount;
    }

    @XmlElement(name = "amount")
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getEstimate_date() {
        return estimate_date;
    }

    @XmlElement(name = "estimate_date")
    public void setEstimate_date(Date estimate_date) {
        this.estimate_date = estimate_date;
    }

    public int getStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    @XmlElement(name = "remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    @XmlElement(name = "customer_id")
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTechnician_id() {
        return technician_id;
    }

    @XmlElement(name = "technician_id")
    public void setTechnician_id(int technician_id) {
        this.technician_id = technician_id;
    }

    public int getProcessed_by_id() {
        return processed_by_id;
    }

    @XmlElement(name = "processed_by_id")
    public void setProcessed_by_id(int processed_by_id) {
        this.processed_by_id = processed_by_id;
    }

    public int getService_id() {
        return service_id;
    }

    @XmlElement(name = "service_id")
    public void setService_id(int service_id) {
        this.service_id = service_id;
    }
}
