package ru.hh.backend.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "company", schema = "public", catalog = "hh")
public class Company {
    private int id;
    private String name;
    private Timestamp create_date;
    private Timestamp change_date;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User getUser() {return user;}
    public void setUser(User user){
        this.user = user;
    }


    @Basic
    @CreationTimestamp
    @Column(name = "create_date")
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


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vacancy> vacancies = new HashSet<>();

    public void addVacancy(Vacancy vacancy){
        this.vacancies.add(vacancy);
        vacancy.setCompany(this);
    }
    public void removeVacancy(Vacancy vacancy){
        this.vacancies.remove(vacancy);
        vacancy.setCompany(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company that = (Company) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(create_date, that.create_date) &&
                Objects.equals(change_date, that.change_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, create_date, change_date);
    }
}
