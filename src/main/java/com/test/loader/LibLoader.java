package com.test.loader;

import jdk.incubator.foreign.SymbolLookup;

public interface LibLoader {
    void loadLib(String filename);
    SymbolLookup getLookup();

    static LibLoader create(String filename) throws ReflectiveOperationException{
        LibLoader libLoader = (LibLoader) new LibClassLoader().loadClass(LibLoaderImpl.class.getName()).getDeclaredConstructors()[0].newInstance();
        libLoader.loadLib(filename);
        return libLoader;
    }

}