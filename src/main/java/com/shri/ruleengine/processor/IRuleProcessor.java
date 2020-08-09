package com.shri.ruleengine.processor;

import com.shri.ruleengine.rules.Data;
import com.shri.ruleengine.rules.IRule;

import java.util.List;

/**
 * Rules processor interface.
 *
 * @author smishra
 */
public interface IRuleProcessor {

    /**
     * Process all registered rules on given data.
     */
    public void process(List<IRule> rules, Data data) throws Exception;
}
