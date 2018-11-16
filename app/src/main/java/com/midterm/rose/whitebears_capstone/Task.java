package com.midterm.rose.whitebears_capstone;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task {
    private int taskId, workload, projectId;

    private String priority, title, description, status, projectName;

    private Date dueDate, startDate, completedDate;

    private ArrayList<User> users = new ArrayList<>();

    public Task(int taskId, int workload, int projectId, String priority, String title, String description, String status, String projectName, Date dueDate, Date startDate, Date completedDate) {
        this.taskId = taskId;
        this.workload = workload;
        this.projectId = projectId;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.projectName = projectName;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.completedDate = completedDate;

        Date today = new Date();

        this.setStatus(status);
        /*
        if(completedDate == null){
            if(today.getTime() > dueDate.getTime()){
                this.status = "Overdue";
                this.overdue++;
            }else{
                this.status = "On Schedule";
                this.onSchedule++;
            }
        }else{
            if(completedDate.getTime() > dueDate.getTime()){
                this.status = "Completed (Overdue)";
                this.completedOverdue++;
            }else{
                this.status = "Completed (On Time)";
                this.completedOnTime++;
            }
        }*/
    }

    public Task() {

    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getFormattedDueDate(){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(dueDate);
    }

    public String getFormattedStartDate(){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(startDate);
    }

    public String getFormattedCompletedDate(){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(completedDate);
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
