package com.cit360.week09test;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emp_test", schema = "hibernate", catalog = "")
public class EmpTestEntity {
    private int id;
    private String name;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpTestEntity that = (EmpTestEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "EmpTestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
