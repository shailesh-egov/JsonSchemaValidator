package egov.jsonschemavalidator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ValidateJson {

    public boolean getValidationStatus(JsonNode inputJsonSchema, JsonNode inputJsonData) throws Exception {
        JSONObject inputSchema = new JSONObject(inputJsonSchema.toString());
        Schema schema = SchemaLoader.load(inputSchema);

        // Create an instance of the ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert JsonNode to String
            String jsonString = objectMapper.writeValueAsString(inputJsonData);

            // Create JSONObject from the jsonString
            JSONObject jsonObject = new JSONObject(jsonString);

            schema.validate(jsonObject);
            return true;
        }
        catch (ValidationException e) {
            System.err.println("Invalid schema" + e);
            throw new Exception(e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Other exception" + e);
            throw new Exception(e.getMessage());
        }
    }
}
