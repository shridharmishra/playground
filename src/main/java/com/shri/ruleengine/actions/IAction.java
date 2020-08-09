package com.shri.ruleengine.actions;

import com.shri.ruleengine.rules.Data;

/**
 * Interface for Rules Action
 *
 * @author smishra
 */

public interface IAction {

    /**
     *
     * @return Name of the Action
     */
    String getName();

    /**
     * Execute the action
     * @param input
     * @return Output
     */
    Data execute(Data input);
}
