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
public final class UserGroup {
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

    private UserGroup(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.allowAdd = builder.allowAdd;
        this.allowEdit = builder.allowEdit;
        this.allowDelete = builder.allowDelete;
        this.allowPrint = builder.allowPrint;
        this.allowImport = builder.allowImport;
        this.allowExport = builder.allowExport;
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

    public static class Builder {
        private int id;
        private String name;
        private String description;
        private boolean allowAdd;
        private boolean allowEdit;
        private boolean allowDelete;
        private boolean allowPrint;
        private boolean allowImport;
        private boolean allowExport;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder(int id) {
            this.id = id;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder permissions(boolean allowAdd, boolean allowEdit, boolean allowDelete, boolean allowPrint
                , boolean allowImport
                , boolean allowExport) {
            this.allowAdd = allowAdd;
            this.allowEdit = allowEdit;
            this.allowDelete = allowDelete;
            this.allowPrint = allowPrint;
            this.allowImport = allowImport;
            this.allowExport = allowExport;
            return this;
        }

        public UserGroup build() {
            return new UserGroup(this);
        }
    }
}
