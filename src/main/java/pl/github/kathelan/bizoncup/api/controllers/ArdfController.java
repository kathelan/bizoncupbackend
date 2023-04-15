package pl.github.kathelan.bizoncup.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.github.kathelan.bizoncup.api.dtos.ardf.ArdfDataRequest;
import pl.github.kathelan.bizoncup.api.services.ArdfService;

import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ardf")
public class ArdfController {

    private final ArdfService ardfService;

    @PostMapping(value = "/receive", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Void> receiveARDFData(@RequestParam Map<String, String> allParams) {
        for (String key : allParams.keySet()) {
            ardfService.processJsonData(key);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/results")
    public ResponseEntity<ArdfDataRequest> getArdfData() {
        ArdfDataRequest ardfData = ardfService.getArdfData();
        if (ardfData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ardfData);
    }
}