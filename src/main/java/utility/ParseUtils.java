package utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseUtils {

    public static String getValueFromJson(String key, String jsonPath) {
        LogUtils.getLogger().debug("Parsing " + jsonPath + " by key: " + key);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File(jsonPath));
            return root.path(key).asText();
        } catch (IOException e) {
            LogUtils.getLogger().info("Caught IOException");
            throw new RuntimeException(e);
        }
    }

    public static List<String> getConfigDataFromJson(String key, String jsonPath) {
        LogUtils.getLogger().debug("Parsing " + jsonPath + " by key: " + key);
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(jsonPath));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonData);
            JsonNode optionsNode = rootNode.path(key);
            List<String> list = new ArrayList<>();
            Iterator<JsonNode> elements = optionsNode.elements();
            while (elements.hasNext()) {
                JsonNode a = elements.next();
                list.add(a.asText());
            }
            return list;
        } catch (IOException e) {
            LogUtils.getLogger().info("Caught IOException");
            throw new RuntimeException(e);
        }
    }
}
