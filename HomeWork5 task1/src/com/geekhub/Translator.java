package com.geekhub;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {

    private static final String YANDEX_API_KEY = "trnsl.1.1.20131116T095927Z.86fe567e8de2cf44.5be1510f166cd444fdd9363db18bb3b5537bb7e9";
    private static final String TRANSLATION_DIRECTION = "ru";

    public String translate(String original) throws Exception {
        URL url = new URL(prepareURL(original));
        HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();

        final StringBuilder outputBuilder = new StringBuilder();
        String string;
        InputStream inputStream = uc.getInputStream();
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (null != (string = reader.readLine())) {
                outputBuilder.append(string.replaceAll("\uFEFF", ""));
            }
        }
        return parseContent(outputBuilder.toString());
    }

    private String prepareURL(String text) {
        return "https://translate.yandex.net/api/v1.5/tr/translate?key="
                + YANDEX_API_KEY + "&text=" + encodeText(text) + "&lang=" + TRANSLATION_DIRECTION;
    }

    private String parseContent(String content) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(new InputSource(new StringReader(content)));
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName("text").item(0).getTextContent();
    }

    private String encodeText(String text) {
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
