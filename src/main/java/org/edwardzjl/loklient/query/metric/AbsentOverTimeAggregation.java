package org.edwardzjl.loklient.query.metric;

/**
 * @author Junlin Zhou
 */
public class AbsentOverTimeAggregation extends LogRangeAggregation {

    private static final String FUNCTION_NAME = "absent_over_time";

    @Override
    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
