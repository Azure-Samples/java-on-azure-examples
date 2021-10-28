package cosmos2storage;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public interface ChangeFeedHandler {

    void processChanges(List<JsonNode> changes);
}
