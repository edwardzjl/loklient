package org.edwardzjl.loklient.query.structure;

/**
 * @author Junlin Zhou
 */
public interface BinaryPredicate<K, O, V> extends Predicate {

    K getKey();

    O getOperator();

    V getValue();

}
