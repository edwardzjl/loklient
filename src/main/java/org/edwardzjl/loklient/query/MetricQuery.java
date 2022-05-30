package org.edwardzjl.loklient.query;

import org.edwardzjl.loklient.query.pipeline.LogPipeline;
import org.edwardzjl.loklient.query.selector.LogStreamSelector;

/**
 * @author Junlin Zhou
 */
public class MetricQuery extends LogQuery {

    public MetricQuery(LogStreamSelector streamSelector, LogPipeline pipelineExpression) {
        super(streamSelector, pipelineExpression);
    }

}
