package com.test.task.controller;

import com.test.task.dto.TransformRequest;
import com.test.task.dto.TransformResponse;
import com.test.task.service.TransformService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "transform controller", description = "Secured endpoint for aut-api")
@RestController
@RequestMapping("api/transform")
@RequiredArgsConstructor
public class TransformController {

    private final TransformService transformService;

    @PostMapping
    @Operation(summary = "Transform text",
            description = "Add prefixes and return the resul")
    public ResponseEntity<TransformResponse> transformText(
            @RequestBody TransformRequest request) {
        return transformService.transform(request);
    }
}
