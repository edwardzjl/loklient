package org.edwardzjl.loklient;

import org.edwardzjl.loklient.query.pipeline.parser.JsonParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Junlin Zhou
 */
public class ParserTests {

    @Test
    void jsonParserTest() {
        JsonParser parser = JsonParser.builder().build();
        assertEquals("| json", parser.toString());
    }

    @Test
    void jsonParserWithParamTest() {
        JsonParser parser = JsonParser.builder().params((Map.of("key", "value"))).build();
        assertEquals("| json key=`value`", parser.toString());
    }

}
