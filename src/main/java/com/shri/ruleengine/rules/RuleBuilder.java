package com.shri.ruleengine.rules;

import com.shri.ruleengine.actions.IAction;
import com.shri.ruleengine.conditions.ICondition;

public class RuleBuilder {

    private String ruleName = IRule.DEFAULT_RULE_NAME;
    private String ruleDescription = IRule.DEFAULT_RULE_DESCRIPTION;
    private  int rulePriority = IRule.DEFAULT_RULE_PRIORITY;

    private ICondition condition = ICondition.FALSE;
    private IAction action;

    public RuleBuilder() {
    }

    public RuleBuilder withRuleName(String ruleName){
        this.ruleName = ruleName;
        return this;
    }

    public RuleBuilder withDescription(String description){
        this.ruleDescription = description;
        return this;
    }

    public RuleBuilder withPriority(int priority){
        this.rulePriority = priority;
        return this;
    }

    public RuleBuilder withCondition(ICondition condition){
        this.condition = condition;
        return this;
    }

    public RuleBuilder withAction(IAction action){
        this.action = action;
        return this;
    }

    public Rule build() {
        return new Rule(ruleName, ruleDescription, rulePriority, condition, action);
    }
}
