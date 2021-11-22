package com.test.loader;

import jdk.incubator.foreign.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.Optional;

import static jdk.incubator.foreign.CLinker.*;

public class Fmi2FFI {
    private final LibLoader libLoader;

    public Fmi2FFI(LibLoader libLoader){
        this.libLoader = libLoader;
    }
    public String getVersion() throws Throwable {
        Optional<MemoryAddress> getVersion1 = libLoader.getLookup().lookup("fmi2GetVersion");
        if(getVersion1.isPresent()) {
            MethodType mt = MethodType.methodType(MemoryAddress.class);
            FunctionDescriptor fd = FunctionDescriptor.of(C_POINTER);
            MethodHandle methodHandle = CLinker.getInstance().downcallHandle(getVersion1.get(), mt, fd);
            Object invoke = methodHandle.invoke();
            String c = CLinker.toJavaString(((MemoryAddress) invoke));
            return c;
        }
        return null;
    }
}
