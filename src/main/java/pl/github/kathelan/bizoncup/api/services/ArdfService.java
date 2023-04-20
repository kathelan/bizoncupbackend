package pl.github.kathelan.bizoncup.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.kathelan.bizoncup.api.dtos.ardf.ArdfDataRequest;
import pl.github.kathelan.bizoncup.exceptions.JsonMappingRuntimeException;
import pl.github.kathelan.bizoncup.exceptions.JsonProcessingRuntimeException;

@RequiredArgsConstructor
@Service
public class ArdfService {

    private final ObjectMapper objectMapper;
    private final ArdfDataService ardfDataService;

    public void processJsonData(String key) {
        try {
            ArdfDataRequest ardfData = objectMapper.readValue(key, ArdfDataRequest.class);
            if (!"READOUT".equals(ardfData.getSOURCE())) {
                ardfDataService.setArdfData(ardfData);
            }
        } catch (JsonMappingException e) {
            throw new JsonMappingRuntimeException("Error mapping JSON data", e);
        } catch (JsonProcessingException e) {
            throw new JsonProcessingRuntimeException("Error processing JSON data", e);
        }
    }

    public ArdfDataRequest getArdfData() {
        return ardfDataService.getArdfData();
    }
}
