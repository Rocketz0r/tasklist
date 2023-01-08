package test.tasklist.domen;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name="tasklist")
@ToString(of = {"id", "tasks"})
@EqualsAndHashCode(of = {"id"})
public class EntityPr {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String tasks;

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getTasks() {
        return tasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
