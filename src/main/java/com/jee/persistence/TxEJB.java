package com.jee.persistence;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.*;

@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TxEJB {
    private double balance;

    @Resource
    private UserTransaction userTransaction;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void setBalance(double deposit){
        try {
            userTransaction.begin();
        } catch (NotSupportedException | SystemException e) {
            e.printStackTrace();
        }
        this.balance += deposit;

    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void deposit(double deposit) {
        try {
            userTransaction.begin();
            this.balance = deposit;
            userTransaction.commit();
        } catch (RollbackException | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }


    }

    public double getBalance(){
        return balance;

    }
}
