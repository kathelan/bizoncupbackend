package pl.github.kathelan.bizoncup.api.dtos.ardf;

import lombok.Data;

import java.util.List;

@Data
public class ArdfDataRequest {
    public String SOURCE;
    public String CONTEST;
    public String DATE;
    public String BEGIN;
    public String BAND;
    public String LIMIT;
    public List<Competitor> COMPETITORS;
}
