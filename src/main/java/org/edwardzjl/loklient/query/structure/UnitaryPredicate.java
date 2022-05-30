package org.edwardzjl.loklient.query.structure;

import org.edwardzjl.loklient.query.structure.Predicate;

/**
 * @author Junlin Zhou
 */
public interface UnitaryPredicate <O, V> extends Predicate {

    O getOperator();

    V getValue();

}
