package com.geekhub.source;

import java.util.ArrayList;
import java.util.List;

public class SourceLoader {

    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        sourceProviders.add(new FileSourceProvider());
        sourceProviders.add(new URLSourceProvider());
    }

    public String loadSource(String pathToSource) throws Exception {
        for (SourceProvider sp : sourceProviders) {
            if (sp.isAllowed(pathToSource)) {
                return sp.load(pathToSource);
            }else {
                Throwable myException =  new Exception();
            }
        }

        return null;
    }
}
