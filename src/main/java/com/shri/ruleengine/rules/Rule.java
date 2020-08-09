package com.shri.ruleengine.rules;

import com.shri.ruleengine.actions.IAction;
import com.shri.ruleengine.conditions.ICondition;

public class Rule implements IRule {

    protected String name;
    protected int priority;
    protected String description;

    ICondition condition;

    IAction action;

    public Rule(ICondition condition, IAction action) {
        this.condition = condition;
        this.action = action;
        this.name = DEFAULT_RULE_NAME;
        this.description = DEFAULT_RULE_DESCRIPTION;
        this.priority = DEFAULT_RULE_PRIORITY;
    }

    public Rule() {
    }

    public Rule(String ruleName,
                String ruleDescription,
                int rulePriority,
                ICondition condition,
                IAction action) {

        this.name = ruleName;
        this.description = ruleDescription;
        this.priority = rulePriority;
        this.condition = condition;
        this.action = action;

    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public int getPriority(){
        return this.priority;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    @Override
    public boolean evaluate(Data inputData) {

        return  condition.evaluate(inputData);
    }

    @Override
    public void execute(Data inputData) throws Exception {
        action.execute(inputData);
    }

    @Override
    public int compareTo(final IRule rule) {
        if (getPriority() < rule.getPriority()) {
            return -1;
        } else if (getPriority() > rule.getPriority()) {
            return 1;
        } else {
            return getName().compareTo(rule.getName());
        }
    }
}
