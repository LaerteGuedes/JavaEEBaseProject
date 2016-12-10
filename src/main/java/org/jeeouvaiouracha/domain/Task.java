package org.jeeouvaiouracha.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Entity
@Table(name = "task")
public class Task extends AbstractEntity implements Serializable{

    @NotNull
    private String title;
    private String description;
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "attributed_id")
    private User attributed;

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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getAttributed() {
        return attributed;
    }

    public void setAttributed(User attributed) {
        this.attributed = attributed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!getTitle().equals(task.getTitle())) return false;
        if (getDescription() != null ? !getDescription().equals(task.getDescription()) : task.getDescription() != null)
            return false;
        if (getDeadline() != null ? !getDeadline().equals(task.getDeadline()) : task.getDeadline() != null)
            return false;
        if (getCreator() != null ? !getCreator().equals(task.getCreator()) : task.getCreator() != null) return false;
        return !(getAttributed() != null ? !getAttributed().equals(task.getAttributed()) : task.getAttributed() != null);

    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDeadline() != null ? getDeadline().hashCode() : 0);
        result = 31 * result + (getCreator() != null ? getCreator().hashCode() : 0);
        result = 31 * result + (getAttributed() != null ? getAttributed().hashCode() : 0);
        return result;
    }
}
