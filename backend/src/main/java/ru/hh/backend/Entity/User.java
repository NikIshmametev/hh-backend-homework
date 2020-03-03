package ru.hh.backend.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "public", catalog = "hh")
public class User {
    private int id;
    private String name;
    private String type;
    private Timestamp create_date;
    private Timestamp change_date;
    private Set<Company> companies;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    public Set<Company> getCompanies() { return companies; }
    public void setCompanies(Set<Company> companies) {this.companies = companies;}


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    @Basic
    @Column(name = "create_date")
    @CreationTimestamp
    public Timestamp getCreate_date() {
        return create_date;
    }
    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }


    @Basic
    @UpdateTimestamp
    @Column(name = "change_date")
    public Timestamp getChange_date() {
        return change_date;
    }
    public void setChange_date(Timestamp change_date) {
        this.change_date = change_date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(create_date, that.create_date) &&
                Objects.equals(change_date, that.change_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, create_date, change_date);
    }
}
