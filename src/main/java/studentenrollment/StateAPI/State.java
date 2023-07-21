package studentenrollment.StateAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "states")
public class State {
    @Id
    private Integer id;
    private String statename;

    public State() {
        // Default constructor is required for JPA
    }

    public State(Integer id, String statename) {
        this.id = id;
        this.statename = statename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public static State stateNotFound() {
        State notFound = new State();
        notFound.setStatename("State not found");
        return notFound;
    }

}
