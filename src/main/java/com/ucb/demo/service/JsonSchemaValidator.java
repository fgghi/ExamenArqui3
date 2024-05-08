// package com.ucb.demo.service;


// import java.util.Set;

// import org.springframework.stereotype.Service;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.networknt.schema.JsonSchema;
// import com.networknt.schema.ValidationMessage;
// import com.networknt.schema.ValidationResult;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class JsonSchemaValidator {

//     private final JsonSchema jsonSchema;

//     public ValidationResult validate(JsonNode jsonNode) {

//         Set<ValidationMessage> validationErrors = jsonSchema.validate(jsonNode);

//         return ValidationResult.builder()
//                 .valid(validationErrors.isEmpty())
//                 .errors(validationErrors.stream()
//                     .map(result -> ValidationError.builder()
//                         .field(result.getPath())
//                         .message(result.getMessage())
//                         .build())
//                     .collect(Collectors.toSet()))
//                 .build();
//     }
// }
