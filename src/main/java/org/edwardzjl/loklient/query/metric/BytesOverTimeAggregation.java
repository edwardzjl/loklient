package org.edwardzjl.loklient.query.metric;

/**
 * @author Junlin Zhou
 */
public class BytesOverTimeAggregation extends LogRangeAggregation {
    private static final String FUNCTION_NAME = "bytes_over_time";

    @Override
    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
