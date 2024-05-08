package com.ucb.demo;

import org.springframework.http.ResponseEntity;

import com.ucb.demo.dto.CardRequest;
import com.ucb.demo.dto.CardResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Card Request", description = "For paying with the card")
public interface ICardApi {

    @Operation(summary = "Request Card", description = "Insert the data from your card")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = CardResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<CardResponse> request(CardRequest cardRequest);
}
