package com.shri.ruleengine.rules;

import com.shri.ruleengine.conditions.ICondition;

/**
 * Interface for a rule that can be fired by a rules engine.
 *
 * @author smishra
 */
public interface IRule extends Comparable<IRule> {
    /**
     * Default rule name.
     */
    String DEFAULT_RULE_NAME = "rule";

    /**
     * Default rule description.
     */
    String DEFAULT_RULE_DESCRIPTION = "description";

    /**
     * Default rule priority.
     */
    int DEFAULT_RULE_PRIORITY = Integer.MAX_VALUE - 1;

    /**
     * Get rule name.
     * @return the rule name
     */
    default String getName() {
        return DEFAULT_RULE_NAME;
    }

    /**
     * Get rule description.
     * @return rule description
     */
    default String getDescription() {
        return DEFAULT_RULE_DESCRIPTION;
    }

    /**
     * Get rule priority.
     * @return rule priority
     */
    default int getPriority() {
        return DEFAULT_RULE_PRIORITY;
    }

    /**
     * Execute the rule condition on the input data.
     *
     * @return true if the rule should be applied for the given condition, false otherwise
     */
    boolean evaluate(Data inputData);

    /**
     * This method implements the rule's action(s).
     * @throws Exception thrown if an exception occurs when performing action(s)
     */
    void execute(Data inputData) throws Exception;


}
