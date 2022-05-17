package com.francesca.pascalau.controller;

import com.francesca.pascalau.data.entities.Employee;
import com.francesca.pascalau.data.entities.Payment;
import com.francesca.pascalau.domain.service.EmployeeService;
import com.francesca.pascalau.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class AppController {

    private final EmployeeService employeeService;
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findEmployees();

        return new ResponseEntity<>(employees, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);

        return new ResponseEntity<>(employee, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee saved = employeeService.save(employee);

        return new ResponseEntity<>(saved, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.findPayments();

        return new ResponseEntity<>(payments, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/payment/add")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment saved = paymentService.save(payment);

        return new ResponseEntity<>(saved, new HttpHeaders(), HttpStatus.OK);
    }
}
