package com.jee.persistence;

import javax.persistence.*;
import javax.persistence.DiscriminatorColumn;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Cacheable
@DiscriminatorColumn(name = "T",discriminatorType = DiscriminatorType.STRING)
public class Customer implements Serializable {
    @GeneratedValue
    @Id
    private long id;
    private String firstName;
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Transient
    private int age;

    @Transient
    private String date;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    @OneToOne(fetch= FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_Fk")
    private Address address;
    


   @PrePersist
    public void constructDate() {
        if(date==null) throw new NullPointerException();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            dateOfBirth = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @PostLoad
    @PostPersist
    public  void constructDateString(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        date = format.format(dateOfBirth);
        if(dateOfBirth==null){
            age = -1;
            return;
        }

        // calculate the age of the customer
        Calendar dob = new GregorianCalendar();
        dob.setTime(dateOfBirth);

        Calendar now = new GregorianCalendar();
        now.setTime(new Date());

        int adjust = 0;


        if (now.get(Calendar.DAY_OF_YEAR) - dob.get(Calendar.DAY_OF_YEAR) < 0) {
            adjust = -1;
        }
        age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR) + adjust;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
