package com.test.task.service;

import com.test.task.dto.TransformRequest;
import com.test.task.dto.TransformResponse;
import org.springframework.http.ResponseEntity;

public interface TransformService {
    ResponseEntity<TransformResponse> transform(TransformRequest request);
}
