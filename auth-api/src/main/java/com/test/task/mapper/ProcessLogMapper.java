package com.test.task.mapper;

import com.test.task.config.MapperConfig;
import com.test.task.dto.process.ProcessLogDto;
import com.test.task.model.ProcessingLog;
import com.test.task.model.User;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface ProcessLogMapper {
    @Mapping(source = "model.user.id", target = "userId")
    @Mapping(source = "model.id", target = "processId")
    ProcessLogDto toDto(ProcessingLog model);

    @Mapping(target = "id", ignore = true)
    ProcessingLog toModel(User user,
                          String inputText,
                          String outputText,
                          LocalDateTime createdAt);
}
