package com.geekhub.source;

import java.io.IOException;

public interface SourceProvider {

    boolean isAllowed(String pathToSource);

    String load(String pathToSource) throws IOException;

}
