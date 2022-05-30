package org.edwardzjl.loklient.query.metric;

/**
 * @author Junlin Zhou
 */
public class RateAggregation extends LogRangeAggregation {

    private static final String FUNCTION_NAME = "rate";

    @Override
    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
