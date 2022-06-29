package com.azure.example.changefeed;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public interface ChangeFeedHandler {

    /**
     * Process the changes.
     *
     * @param changes the changes.
     */
    public void processChanges(List<JsonNode> changes);
}
