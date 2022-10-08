package com.example.springjunittest5.controller;

import org.junit.jupiter.api.Assertions;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.internal.verification.checkers.MissingInvocationChecker;
import org.mockito.internal.verification.checkers.NumberOfInvocationsChecker;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;
import org.springframework.util.Assert;

import java.util.List;

public class HelloServiceVerification implements VerificationMode {
    private String name;
    final int wantedCount;
    public HelloServiceVerification(int wantedNumberOfInvocations,String name) {
      this.wantedCount=wantedNumberOfInvocations;
        this.name=name;
    }

    public void verify(VerificationData data) {
        if (wantedCount > 0) {
            MissingInvocationChecker.checkMissingInvocation(data.getAllInvocations(),data.getTarget());
        }
        List<Invocation> invocations=data.getAllInvocations();
        if(invocations!=null) {
            for (Invocation invocation : invocations) {
                Object[] args = invocation.getArguments();
                if(data.getTarget().hasSameMethod(invocation)) {
                    System.out.println("invocation.getMethod():"+invocation.getMethod());
                    if (args != null) {
                        for (Object arg : args) {
                            //验证传入参数是否是world
                            this.verifyData(arg);
                        }
                    }
                }
            }
        }
        NumberOfInvocationsChecker.checkNumberOfInvocations(data.getAllInvocations(),data.getTarget(),wantedCount);
    }

    public void verifyData(Object args) {
        System.out.println("args="+args);
        Assert.notNull(args, "args must not be null");
        Assertions.assertEquals(name,args);
    }
}
