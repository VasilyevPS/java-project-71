package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parse(String content, String dataType) throws Exception {
        ObjectMapper mapper = chooseMapper(dataType);
        return mapper.readValue(content, new TypeReference<>() { });
    }

    public static ObjectMapper chooseMapper(String fileExtension) throws Exception {
        return switch (fileExtension) {
            case ("json") -> new ObjectMapper();
            case ("yaml"), ("yml") -> new ObjectMapper(new YAMLFactory());
            default -> throw new Exception("Format "  + fileExtension + " is not supported by gendiff");
        };
    }
}
