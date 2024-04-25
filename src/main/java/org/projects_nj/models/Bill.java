package org.projects_nj.models;

import java.util.List;

public class Bill {
    private String id;
    private Ticket ticket;
    private String exitTime;
    private double amount;
    private List<Payment> payments;
    private PaymentStatus paymentStatus;

}
