package com.midterm.rose.whitebears_capstone;

import java.util.ArrayList;
import java.util.Date;

public class Project {
    private int ProjectId;

    private String Title, Description, scopeStatement, scope;

    private Date StartDate, DueDate, CompletionDate;

    private ArrayList<Task> tasks;

    public Project(int projectId, String title, String description, String scopeStatement, String scope, Date startDate, Date dueDate, Date completionDate) {
        this.ProjectId = projectId;
        this.Title = title;
        this.Description = description;
        this.scopeStatement = scopeStatement;
        this.scope = scope;
        this.StartDate = startDate;
        this.DueDate = dueDate;
        this.CompletionDate = completionDate;
    }

    public Project() {

    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        this.ProjectId = projectId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
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
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        this.DueDate = dueDate;
    }

    public Date getCompletionDate() {
        return CompletionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.CompletionDate = completionDate;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isOverdue(){
        Date today = new Date();

        return today.getTime() > this.DueDate.getTime();
    }
}
