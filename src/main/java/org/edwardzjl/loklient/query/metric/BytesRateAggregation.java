package org.edwardzjl.loklient.query.metric;

/**
 * @author Junlin Zhou
 */
public class BytesRateAggregation extends LogRangeAggregation {

    private static final String FUNCTION_NAME = "bytes_rate";

    @Override
    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
