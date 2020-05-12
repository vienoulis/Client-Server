package ru.vienoulis.server.comp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "role")
    private String role;

//    @ManyToMany(mappedBy = "roleSet")
//    private Set<User> userSet = new HashSet<>();

    public Role() {
    }


    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

//    @XmlID
//    @XmlJavaTypeAdapter(value = LongAdapter.class, type = String.class)
    public Long getId() {
        return id;
    }

    public void setId(Long ig) {
        this.id = ig;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    @XmlIDREF
//    public Set<User> getUserSet() {
//        return userSet;
//    }

//    pu

    @Override
    public String toString() {
        return role.substring(5).toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}
