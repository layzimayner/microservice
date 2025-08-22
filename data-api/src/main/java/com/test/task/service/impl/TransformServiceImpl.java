package com.test.task.service.impl;

import com.test.task.dto.TransformRequest;
import com.test.task.dto.TransformResponse;
import com.test.task.service.TransformService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransformServiceImpl implements TransformService {

    @Override
    public ResponseEntity<TransformResponse> transform(
            TransformRequest request) {
        TransformResponse response = new TransformResponse(
                "---(" + request.text() + ")---");
        return ResponseEntity.ok(response);
    }
}
