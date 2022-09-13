/*
 * Copyright (c) 2022 by Maksym Furkalo
 * use it for free
 */

package core.DAO.models;

public class UserGroup {
    private int id;
    private String name;
    private String description;
    private boolean allowAdd;
    private boolean allowEdit;
    private boolean allowDelete;
    private boolean allowPrint;
    private boolean allowImport;

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

    public boolean isAllowAdd() {
        return allowAdd;
    }

    public void setAllowAdd(boolean allowAdd) {
        this.allowAdd = allowAdd;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public boolean isAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public boolean isAllowPrint() {
        return allowPrint;
    }

    public void setAllowPrint(boolean allowPrint) {
        this.allowPrint = allowPrint;
    }

    public boolean isAllowImport() {
        return allowImport;
    }

    public void setAllowImport(boolean allowImport) {
        this.allowImport = allowImport;
    }
}
