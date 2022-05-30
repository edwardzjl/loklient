package org.edwardzjl.loklient.query.metric;

/**
 * See <a href="https://grafana.com/docs/loki/latest/logql/metric_queries/#log-range-aggregations">this</a>
 *
 * @author Junlin Zhou
 */
public abstract class LogRangeAggregation extends RangeVectorAggregation {

    protected RangeVector rangeVector;

    public abstract String getFunctionName();

}
