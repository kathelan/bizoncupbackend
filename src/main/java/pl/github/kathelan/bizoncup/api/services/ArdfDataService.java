package pl.github.kathelan.bizoncup.api.services;

import org.springframework.stereotype.Service;
import pl.github.kathelan.bizoncup.api.dtos.ardf.ArdfDataRequest;

@Service
public class ArdfDataService {
    private ArdfDataRequest ardfData;

    public synchronized ArdfDataRequest getArdfData() {
        return ardfData;
    }

    public synchronized void setArdfData(ArdfDataRequest ardfData) {
        this.ardfData = ardfData;
    }
}
