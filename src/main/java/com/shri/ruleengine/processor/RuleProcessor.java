package com.shri.ruleengine.processor;

import com.shri.ruleengine.context.AppRequestContextHolder;
import com.shri.ruleengine.rules.Data;
import com.shri.ruleengine.rules.IRule;
import com.shri.ruleengine.rules.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.TreeSet;
import java.util.UUID;

/**
 * Default {@link IRuleProcessor} implementation.
 *
 * Rules are processed according to their priority .
 * This implementation iterates over the set of rules, evaluates the condition
 * of each rule and executes its actions if the condition evaluates to true.
 *
 * @author smishra
 */
public class RuleProcessor implements IRuleProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuleProcessor.class);

    @Override
    public void process(List<IRule> rules, Data data) throws Exception {
        String trackingId = UUID.randomUUID().toString();
        AppRequestContextHolder.getRequestContext().setTrackingId(trackingId);

        log(rules);
        TreeSet<IRule> rulesTreeSet = new TreeSet(rules);
        for(IRule rule : rulesTreeSet){
            if(rule.evaluate(data)){
                LOGGER.debug("Rule - {} Priority {} ",rule.getName() ,rule.getPriority());
                rule.execute(data);
            }else {
                LOGGER.info(" Condition does not met.");
            }
        }
        LOGGER.info("Processing completed !");
    }

    private void log(List<IRule> rules) {
        LOGGER.debug("Registered rules:");
        for (IRule rule : rules) {
            LOGGER.debug("Rule { name = '{}', description = '{}', priority = '{}'}",
                    rule.getName(), rule.getDescription(), rule.getPriority());
        }
    }
}
