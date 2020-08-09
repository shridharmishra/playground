package com.shri.ruleengine.conditions;

import com.shri.ruleengine.rules.Data;

/**
 * Interface for condition associated with the Rule
 *
 * @author smishra
 */
@FunctionalInterface
public interface ICondition {

    /**
     * Evaluate the condition.
     *
     * @param D data .
     *
     * @return true if the rule should be triggered, false otherwise
     */
    boolean evaluate(Data D);

    /**
     * A NoOp {@link ICondition} that always returns true.
     */
    ICondition TRUE = (D)->true;

    /**
     * A NoOp {@link ICondition} that always returns false.
     */
    ICondition FALSE = (D)->false;
}
