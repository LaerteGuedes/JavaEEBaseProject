package org.jeeouvaiouracha.bean;

import org.jeeouvaiouracha.domain.Task;
import org.jeeouvaiouracha.domain.User;
import org.jeeouvaiouracha.services.TaskService;
import org.jeeouvaiouracha.services.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Named
@ViewScoped
public class TaskBean implements Serializable{

    @Inject
    private TaskService service;

    @Inject
    private UserService userService;

    @Inject
    FacesContext fc;

    private Task task = new Task();
    private List<User> users = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Task> getTasks() {
        return service.getAll();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUsers() {
        return userService.getAll();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String add(Task task){
        System.out.println("ADD");
        service.add(task);

        fc.getExternalContext().getFlash().setKeepMessages(true);
        fc.addMessage(null, new FacesMessage("tarefa cadastrada com sucesso!"));

        return "list?faces-redirect=true";
    }

    public String update(Task task){
        service.update(task);

        return redirectAndShowMessage("list", "Tarefa atualizada com sucesso!");
    }

    public String remove(Task task){
        service.remove(task);

        return redirectAndShowMessage("list", "Tarefa atualizada com sucesso!");
    }

    public void load(Long id){
        this.task = service.findById(id);
    }

    private String redirectAndShowMessage(String page, String message){
        fc.getExternalContext().getFlash().setKeepMessages(true);
        fc.addMessage(null, new FacesMessage(message));

        return page+"?faces-redirect=true";
    }

}
