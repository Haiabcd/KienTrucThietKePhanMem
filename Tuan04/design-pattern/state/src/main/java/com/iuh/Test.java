package com.iuh;

public class Test {
    public static void main(String args[]){

        // Cach dung cu
//        TVRemoteBasic remote = new TVRemoteBasic();
//        remote.setState("ON");
//        remote.doAction();
//
//        remote.setState("OFF");
//        remote.doAction();

        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setState(tvStartState);
        context.doAction();


        context.setState(tvStopState);
        context.doAction();
    }
}
