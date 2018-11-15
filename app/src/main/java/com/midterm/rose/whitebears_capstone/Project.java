package com.midterm.rose.whitebears_capstone;

import java.util.ArrayList;
import java.util.Date;

public class Project {
    private int projectId;

    private String title, description, scopeStatement, scope;

    private Date startDate, dueDate, completionDate;

    private ArrayList<Task> tasks;

    public Project(int projectId, String title, String description, String scopeStatement, String scope, Date startDate, Date dueDate, Date completionDate) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.scopeStatement = scopeStatement;
        this.scope = scope;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.completionDate = completionDate;
    }

    public Project() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScopeStatement() {
        return scopeStatement;
    }

    public void setScopeStatement(String scopeStatement) {
        this.scopeStatement = scopeStatement;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isOverdue(){
        Date today = new Date();

        return today.getTime() > this.dueDate.getTime();
    }
}
