package com.test;

import com.test.loader.Fmi2FFI;
import com.test.loader.LibLoader;
import jdk.incubator.foreign.MemoryAddress;

import java.io.File;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Throwable {
        LibLoader l1 = LibLoader.create("/Users/au443759/source/test/java17fmi/src/main/resources/binaries/darwin64/watertankcontroller-c.dylib");
        Fmi2FFI f = new Fmi2FFI(l1);
        String fmi2Version = f.getVersion();
        if(fmi2Version != null) {
            System.out.println("Retrieved version: " + fmi2Version);
            System.exit(0);
        }
        else {
            System.out.println("Failed to retrieve version.");
            System.exit(1);
        }
    }
}