package com.iuh.factory;

import com.iuh.entity.Computer;
import com.iuh.entity.PC;
import com.iuh.entity.Server;

public class ComputerFactory {

//    public static Computer getComputer(String type, String ram, String hdd, String cpu){
//        if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
//        else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
//        return null;
//    }

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}

