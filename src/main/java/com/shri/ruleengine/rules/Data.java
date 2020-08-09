package com.shri.ruleengine.rules;

public class Data<D> {

    private final D value;

    public Data(D value) {
        this.value = value;
    }

    public D getValue() {
        return value;
    }
}
