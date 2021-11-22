package com.test.loader;

import java.io.IOException;

public class LibClassLoader extends ClassLoader {
    static final byte[] implBytes;

    static {
        try (var is = LibClassLoader.class.getResourceAsStream("LibLoaderImpl.class")) {
            implBytes = is.readAllBytes();
        }
        catch (IOException io) {
            throw new RuntimeException(io);
        }
    }

    LibClassLoader() {
        super(LibClassLoader.class.getClassLoader());
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        if (c != null) {
            return c;
        }
        if (name.equals(LibLoaderImpl.class.getName())) {
            return defineClass(name, implBytes, 0, implBytes.length);
        }
        else {
            return super.loadClass(name, resolve);
        }
    }
}