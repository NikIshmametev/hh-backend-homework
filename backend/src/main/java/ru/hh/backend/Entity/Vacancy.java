package ru.hh.backend.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vacancy", schema = "public", catalog = "hh")
public class Vacancy {
    private int id;
    private String title;
    private Integer salary;
    private String description;
    private String contacts;
    private Timestamp create_date;
    private Timestamp change_date;
    private Company company;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company getCompany() {return company;}
    public void setCompany(Company company){
        this.company = company;
    }


    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "contacts")
    public String getContacts() {
        return contacts;
    }
    public void setContacts(String contacts) {
        this.contacts = contacts;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy that = (Vacancy) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(description, that.description) &&
                Objects.equals(contacts, that.contacts) &&
                Objects.equals(create_date, that.create_date) &&
                Objects.equals(change_date, that.change_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, salary, description, contacts, create_date, change_date);
    }
}
