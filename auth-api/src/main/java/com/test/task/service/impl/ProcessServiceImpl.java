package com.test.task.service.impl;

import com.test.task.dto.process.ProcessLogDto;
import com.test.task.dto.process.TransformResponse;
import com.test.task.exception.ServiceBUnavailableException;
import com.test.task.mapper.ProcessLogMapper;
import com.test.task.model.ProcessingLog;
import com.test.task.model.User;
import com.test.task.repository.ProcessingLogRepository;
import com.test.task.service.ProcessService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final RestTemplate restTemplate;
    private final ProcessingLogRepository logRepository;
    private final ProcessLogMapper logMapper;

    @Value("${internal.token}")
    private String internalToken;

    @Value("${data.api.url}")
    private String dataApiUrl;

    @Override
    @Transactional
    public ProcessLogDto processText(String inputText, User user) {
        Map<String, String> requestBody = Map.of("text", inputText);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Internal-Token", internalToken);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<TransformResponse> responseEntity = restTemplate.postForEntity(
                    dataApiUrl + "/api/transform",
                    requestEntity,
                    TransformResponse.class
            );

            TransformResponse response = responseEntity.getBody();

            if (response == null || response.result() == null) {
                throw new ServiceBUnavailableException("Invalid response from Service B", null);
            }

            ProcessingLog log = logMapper.toModel(user,
                    inputText, response.result(), LocalDateTime.now());

            return logMapper.toDto(logRepository.save(log));

        } catch (RestClientException ex) {
            throw new ServiceBUnavailableException("Failed to contact Service B", ex);
        }
    }
}
