package com.jee.persistence;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@Stateless
public class CustomerEJB {


    @Resource
    private TimerService timerService;

    @PermitAll
    public Customer createCustomer(Customer customer) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Locale locale = Locale.UK;
        TimeZone timeZone = TimeZone.getTimeZone("Nairobi/africa");

        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(customer.getDateOfBirth());
        ScheduleExpression scheduleExpression = new ScheduleExpression()
                .dayOfMonth(calendar.get(Calendar.DAY_OF_MONTH))
                .month(calendar.get(Calendar.MONTH))
                .hour("16")
                .year("*");

        timerService.createCalendarTimer(scheduleExpression, new TimerConfig(customer, true));


        return customer;

    }

    @Timeout
    public  void  scheduleCustomerBirthDay(Timer timer) {

        Customer customer = (Customer) timer.getInfo();
       //send email to the client here
        System.out.println("Dear " + customer.getFirstName() + " " + customer.getLastName() + " today is your birthday");
    }
}
