package com.test.task.dto.process;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProcessLogDto {
    private String processId;
    private String userId;
    private String inputText;
    private String outputText;
    private LocalDateTime createdAt;
}
