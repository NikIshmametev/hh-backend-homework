package ru.hh.backend.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "resume", schema = "public", catalog = "hh")
public class Resume {
    private int id;
    private String title;
    private String experience;
    private String contacts;
    private Timestamp create_date;
    private Timestamp change_date;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User getUser() {return user;}
    public void setUser(User user){
        this.user = user;
    }


    @Basic
    @Column(name = "title")
    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
    }


    @Basic
    @Column(name = "experience")
    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
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
        Resume that = (Resume) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(experience, that.experience) &&
                Objects.equals(contacts, that.contacts) &&
                Objects.equals(create_date, that.create_date) &&
                Objects.equals(change_date, that.change_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, experience, contacts, create_date, change_date);
    }
}
