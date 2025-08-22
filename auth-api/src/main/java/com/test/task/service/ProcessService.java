package com.test.task.service;

import com.test.task.dto.process.ProcessLogDto;
import com.test.task.model.User;

public interface ProcessService {
    ProcessLogDto processText(String text, User user);
}
