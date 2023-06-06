package egov.jsonschemavalidator.controllers;

import egov.jsonschemavalidator.model.Request;
import egov.jsonschemavalidator.model.Response;
import egov.jsonschemavalidator.service.ValidateJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Validate {

    @Autowired
    ValidateJson validateJson;

    @RequestMapping(value = "/api/validate", method = RequestMethod.POST)
    public Response validateApi(@RequestBody Request request) {
        String message = "";
        Boolean is_valid = false;
        try {
            is_valid = validateJson.getValidationStatus(request.getSchema(), request.getData());
            message = "Correct";
        } catch (Exception e) {
            message = e.getMessage();
        }

        return new Response(is_valid, message);
    }
}
