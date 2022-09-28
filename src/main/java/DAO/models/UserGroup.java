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

@XmlRootElement(name = "UserGroup")
@XmlType(propOrder = {"id", "name", "description", "allowAdd", "allowEdit", "allowDelete", "allowPrint", "allowImport"
        , "allowExport"})
public class UserGroup {
    private int id;
    private String name;
    private String description;
    private boolean allowAdd;
    private boolean allowEdit;
    private boolean allowDelete;
    private boolean allowPrint;
    private boolean allowImport;
    private boolean allowExport;

    public UserGroup() {
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", allowAdd=" + allowAdd +
                ", allowEdit=" + allowEdit +
                ", allowDelete=" + allowDelete +
                ", allowPrint=" + allowPrint +
                ", allowImport=" + allowImport +
                ", allowExport=" + allowExport +
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

    public boolean isAllowAdd() {
        return allowAdd;
    }

    @XmlElement(name = "allowAdd")
    public void setAllowAdd(boolean allowAdd) {
        this.allowAdd = allowAdd;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    @XmlElement(name = "allowEdit")
    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public boolean isAllowDelete() {
        return allowDelete;
    }

    @XmlElement(name = "allowDelete")
    public void setAllowDelete(boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public boolean isAllowPrint() {
        return allowPrint;
    }

    @XmlElement(name = "allowPrint")
    public void setAllowPrint(boolean allowPrint) {
        this.allowPrint = allowPrint;
    }

    public boolean isAllowImport() {
        return allowImport;
    }

    @XmlElement(name = "allowImport")
    public void setAllowImport(boolean allowImport) {
        this.allowImport = allowImport;
    }

    public boolean isAllowExport() {
        return allowExport;
    }

    @XmlElement(name = "allowExport")
    public void setAllowExport(boolean allowExport) {
        this.allowExport = allowExport;
    }
}
