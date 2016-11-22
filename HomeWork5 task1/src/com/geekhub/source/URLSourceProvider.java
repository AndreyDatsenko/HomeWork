package com.geekhub.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLSourceProvider implements SourceProvider {
    private static final String[] SCHEMES = {"http", "https", "ftp"};

    @Override
    public boolean isAllowed(String pathToSource) {
        final URL url;
        try {
            url = new URL(pathToSource);
        } catch (Exception e1) {
            return false;
        }
        for (String protocol : SCHEMES)
            if (protocol.equals(url.getProtocol())) {
                return true;
            }

        return false;
    }

    @Override
    public String load(String pathToSource) throws IOException {
        URL url = new URL(pathToSource);
        InputStream inputStream = url.openConnection().getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        String line2 = "";
        while ((line = reader.readLine()) != null) {
            line2 += line;
        }
        reader.close();
        return line2;
    }
}
