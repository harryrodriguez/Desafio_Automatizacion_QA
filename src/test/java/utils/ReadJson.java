package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {



    public static String readJson(String val, String file) throws IOException, ParseException {
        String value= null;
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader( "./documents/data/" + file + ".json");
        Object obj = parser.parse(reader);
        JSONObject json = (JSONObject) obj;
        value = (String) json.get(val);
        return value;

    }


}
