package org.jeeouvaiouracha.bean;

import org.jeeouvaiouracha.domain.User;
import org.jeeouvaiouracha.services.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by laerteguedes on 25/11/16.
 */
@Named
@ViewScoped
public class UserBean implements Serializable{

    private User user = new User();
    private Long userId;
    private List<User> users;

    @Inject
    FacesContext fc;

    @Inject
    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<User> getUsers(){
        return userService.getAll();
    }

    public String add(User user){
        System.out.println("ADD");
        userService.add(user);

        fc.getExternalContext().getFlash().setKeepMessages(true);
        fc.addMessage(null, new FacesMessage("Usuário salvo com sucesso!"));

        return "list?faces-redirect=true";
    }

    public String update(User user){
        System.out.println("UPDATE");
        userService.update(user);

        fc.getExternalContext().getFlash().setKeepMessages(true);
        fc.addMessage(null, new FacesMessage("Usuário salvo com sucesso!"));

        return "list?faces-redirect=true";
    }

    public void remover(User user) throws Exception {
        userService.remove(user);

        fc.getExternalContext().getFlash().setKeepMessages(true);
        fc.addMessage(null, new FacesMessage("Usuário removido com sucesso!"));
    }

    public void load(){
        System.out.println("LOAD");
        this.user = userService.findById(userId);
        this.user.setPassword("teste");
    }

}
