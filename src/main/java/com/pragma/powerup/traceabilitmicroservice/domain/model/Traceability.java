package com.pragma.powerup.traceabilitmicroservice.domain.model;

import com.pragma.powerup.traceabilitmicroservice.domain.validations.ArgumentValidations;

import java.time.LocalDateTime;

public class Traceability {
    private Long id;
    private Long idOrder;
    private Long idClient;
    private String mailClient;
    private Integer previousStatus;
    private Integer newStatus;
    private Long idEmployee;
    private String mailEmployee;
    private LocalDateTime date;

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        ArgumentValidations.validateObject(idOrder,"idOrder");
        this.idOrder = idOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        ArgumentValidations.validateObject(idClient,"idClient");
        this.idClient = idClient;
    }

    public String getMailClient() {
        return mailClient;
    }

    public void setMailClient(String mailClient) {
        ArgumentValidations.validateString(mailClient,"mailClient");
        this.mailClient = mailClient;
    }

    public Integer getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(Integer previousStatus) {
        ArgumentValidations.validateObject(previousStatus,"previousStatus");
        this.previousStatus = previousStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        ArgumentValidations.validateObject(newStatus,"newStatus");
        this.newStatus = newStatus;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        ArgumentValidations.validateObject(idEmployee,"idEmployee");
        this.idEmployee = idEmployee;
    }

    public String getMailEmployee() {
        return mailEmployee;
    }

    public void setMailEmployee(String mailEmployee) {
        ArgumentValidations.validateString(mailEmployee,"mailEmployee");
        this.mailEmployee = mailEmployee;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        ArgumentValidations.validateObject(date,"date");
        this.date = date;
    }

}
