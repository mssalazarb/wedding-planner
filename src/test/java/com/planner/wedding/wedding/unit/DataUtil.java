package com.planner.wedding.wedding.unit;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.domain.model.Reception;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static Customer buildCustomerRequest() {
        Customer customer = new Customer();
        customer.setIdNumber("1720364578");
        customer.setAddress("Prueba");
        customer.setEmail("prueb@hotmail.com");
        customer.setFullName("Prueba prueba2");
        customer.setPhone("0940234578");
        return customer;
    }

    public static Customer buildCustomerResponse() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setIdNumber("1720364578");
        customer.setAddress("Prueba");
        customer.setEmail("prueb@hotmail.com");
        customer.setFullName("Prueba prueba2");
        customer.setPhone("0940234578");
        return customer;
    }

    public static List<Customer> buildListCustomerResponse() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setIdNumber("1720364578");
        customer.setAddress("Prueba");
        customer.setEmail("prueb@hotmail.com");
        customer.setFullName("Prueba prueba2");
        customer.setPhone("0940234578");
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        return list;
    }

    public static Event buildEventRequest() {
        Event event = new Event();
        event.setDescription("Quinceaños");
        Timestamp startDate = new Timestamp(System.currentTimeMillis());
        event.setStartDate(startDate);
        Timestamp endDate = new Timestamp(System.currentTimeMillis() + 2000);
        event.setEndDate(endDate);
        event.setStatus("Reservado");
        event.setCustomerId(1L);
        event.setReceptionId(1L);
        event.setCapacity(100);

        return event;
    }

    public static Event buildEventResponse() {
        Event event = new Event();
        event.setDescription("Quinceaños");
        Timestamp startDate = new Timestamp(System.currentTimeMillis());
        event.setStartDate(startDate);
        Timestamp endDate = new Timestamp(System.currentTimeMillis() + 2000);
        event.setEndDate(endDate);
        event.setStatus("Reservado");
        event.setCustomerId(1L);
        event.setReceptionId(1L);
        event.setCapacity(100);

        return event;
    }


    public static Reception buildReceptionRequest() {
        Reception reception = new Reception();
        reception.setTitle("Rincón de Puembo");
        reception.setEmail("rincon_pruembo@gmail.com");
        reception.setPhone("0978942356");
        reception.setAddress("Manuel Burbano N6-66 y Francisco Ruiz. Ubicados a 15 minutos del nuevo Aeropuerto Mariscal");
        BigDecimal price = new BigDecimal("1800.00");
        reception.setPrice(price);

        return reception;
    }

    public static Reception buildReceptionResponse() {
        Reception reception = new Reception();
        reception.setId(1L);
        reception.setTitle("Rincón de Puembo");
        reception.setEmail("rincon_pruembo@gmail.com");
        reception.setPhone("0978942356");
        reception.setAddress("Manuel Burbano N6-66 y Francisco Ruiz. Ubicados a 15 minutos del nuevo Aeropuerto Mariscal");
        BigDecimal price = new BigDecimal("1800.00");
        reception.setPrice(price);

        return reception;
    }

    public static List<Reception> buildListReceptionResponse() {
        Reception reception = new Reception();
        reception.setId(1L);
        reception.setTitle("Rincón de Puembo");
        reception.setEmail("rincon_pruembo@gmail.com");
        reception.setPhone("0978942356");
        reception.setAddress("Manuel Burbano N6-66 y Francisco Ruiz. Ubicados a 15 minutos del nuevo Aeropuerto Mariscal");
        BigDecimal price = new BigDecimal("1800.00");
        reception.setPrice(price);

        List<Reception> list = new ArrayList<>();
        list.add(reception);
        return list;
    }
}
