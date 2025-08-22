package com.test.task.controller;

import com.test.task.dto.process.ProcessLogDto;
import com.test.task.dto.process.ProcessRequest;
import com.test.task.model.User;
import com.test.task.service.ProcessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "process management",
        description = "Endpoints for management process")
@RestController
@RequestMapping("/api/process")
@Validated
@RequiredArgsConstructor
public class ProcessingController {
    private final ProcessService processService;

    @PostMapping
    @Operation(summary = "Transform text",
            description = "Send request to data-api and save the result")
    public ProcessLogDto processText(@RequestBody ProcessRequest request,
                                     Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return processService.processText(request.text(), user);
    }
}
