package com.test;

import com.test.loader.Fmi2FFI;
import com.test.loader.LibLoader;
import jdk.incubator.foreign.MemoryAddress;

import java.io.File;
import java.util.Optional;

public class Main17 {
    public static void main(String[] args) throws Throwable {
        LibLoader l1 = LibLoader.create("/Users/au443759/source/test/java17fmi/src/main/resources/binaries/darwin64/watertankcontroller-c.dylib");
        Optional<MemoryAddress> getVersion1 = l1.getLookup().lookup("fmi2GetVersion");
        Fmi2FFI f = new Fmi2FFI(l1);
        f.getVersion();


        LibLoader l2 = LibLoader.create("foo/bar/lib2.dll");
        Optional<MemoryAddress> getVersion2 = l2.getLookup().lookup("getVersion");
    }
}