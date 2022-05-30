package org.edwardzjl.loklient.query.metric;

/**
 * @author Junlin Zhou
 */
public class CountOverTimeAggregation extends LogRangeAggregation {

    private static final String FUNCTION_NAME = "count_over_time";

    @Override
    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
