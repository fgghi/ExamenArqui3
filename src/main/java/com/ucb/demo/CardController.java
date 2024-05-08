package com.ucb.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.ucb.demo.dto.CardRequest;
import com.ucb.demo.dto.CardResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import com.networknt.schema.SpecVersion.VersionFlag;
import java.util.Set;

@RestController
public class CardController {

    @PostMapping("/card")
    public ResponseEntity<?> request(@RequestBody CardRequest cardRequest) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(cardRequest);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(getClass().getClassLoader().getResourceAsStream("schemas/login.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

            if (!errors.isEmpty()) {
                String errorsCombined = "";
                for (ValidationMessage error : errors) {
                    errorsCombined += error.toString() + "\n";
                }
                return ResponseEntity.badRequest().body("Fix your JSON! Errors: " + errorsCombined);
            }
            
            CardResponse response = new CardResponse();
            response.setMessage("succesful");
            response.setStatusCode(0);
            return ResponseEntity.ok(response);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("JSON processing error");
        }
    }
}
