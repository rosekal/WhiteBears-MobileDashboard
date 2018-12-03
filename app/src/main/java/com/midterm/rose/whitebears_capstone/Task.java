package com.midterm.rose.whitebears_capstone;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task {
    private int TaskId, workload, ProjectId;

    private String Priority, Title, Description, Status, ProjectName;

    private Date DueDate, StartDate, completedDate;

    private boolean IsCompleted;

    private ArrayList<User> users = new ArrayList<>();

    public Task(int taskId, int workload, int projectId, String priority, String title, String description, String status, String projectName, Date dueDate, Date startDate, Date completedDate) {
        this.TaskId = taskId;
        this.workload = workload;
        this.ProjectId = projectId;
        this.Priority = priority;
        this.Title = title;
        this.Description = description;
        this.ProjectName = projectName;
        this.DueDate = dueDate;
        this.StartDate = startDate;
        this.completedDate = completedDate;

        Date today = new Date();

        this.setStatus(Status);
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
        return TaskId;
    }

    public void setTaskId(int taskId) {
        this.TaskId = taskId;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        this.ProjectId = projectId;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        this.Priority = priority;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        this.ProjectName = projectName;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        this.DueDate = dueDate;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
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
        if(DueDate == null){
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(DueDate);
    }

    public String getFormattedStartDate(){
        if(StartDate == null){
            return null;
        }
        //hello World
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(StartDate);
    }

    public String getFormattedCompletedDate(){
        if(completedDate == null){
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(completedDate);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public boolean isCompleted() {
        return IsCompleted;
    }

    public void setCompleted(boolean completed) {
        IsCompleted = completed;
    }
}
