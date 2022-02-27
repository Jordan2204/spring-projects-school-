package com.jordi;

import com.jordi.Entities.Account;
import com.jordi.Services.BankService;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        String url = "http://localhost:8590/"; //access address
        Endpoint.publish(url, new BankService());// web publication
        System.out.println(url);
        System.out.println(Account.AccountList());
    }
}
