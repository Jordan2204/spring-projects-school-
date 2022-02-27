package com.jordi.Services;

import com.jordi.Entities.Account;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(name="BankService")
public class BankService {

    @WebMethod
    public Account getAccount(@WebParam(name="code") Long code){
        return Account.getAccount(code);
    }

    @WebMethod
    public List<Account> getAccounts(){
        return Account.AccountList();
    }

    @WebMethod
    public Account addAccount(@WebParam(name="code") Long code, @WebParam(name="balance") Double balance, @WebParam(name="creation_date") String creation_date) throws SQLException {
        return Account.store(code, balance, creation_date);
    }

    @WebMethod
    public void deposit(@WebParam(name="code") Long code, @WebParam(name="amount") Double amount) throws SQLException{
        Account.deposit(code, amount);
    }

    @WebMethod
    public void withdraw(@WebParam(name="code") Long code, @WebParam(name="amount") Double amount) throws SQLException{
        Account.withdraw(code, amount);
    }

    @WebMethod
    public void transfer(@WebParam(name="src_code") Long src_code,@WebParam(name="dest_code") Long dest_code, @WebParam(name="amount") Double amount) throws SQLException{
        Account.transafert(src_code, dest_code, amount);
    }

    @WebMethod
    public void delete(@WebParam(name="code") Long code) throws SQLException{
        Account.delete(code);
    }



}
