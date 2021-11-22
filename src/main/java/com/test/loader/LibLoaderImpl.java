package com.test.loader;

import jdk.incubator.foreign.SymbolLookup;

public class LibLoaderImpl implements LibLoader {
    @Override
    public void loadLib(String filename) {
        System.load(filename);
    }

    @Override
    public SymbolLookup getLookup() {
        return SymbolLookup.loaderLookup();
    }
}