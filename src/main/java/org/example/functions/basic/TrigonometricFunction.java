package org.example.functions.basic;

import org.example.functions.Function;

public abstract class TrigonometricFunction implements Function {

    public double getRightDomainBorder(){
        return Double.POSITIVE_INFINITY;
    }

    public double getLeftDomainBorder(){
        return Double.NEGATIVE_INFINITY;
    }

    public abstract double getFunctionValue(double x);

}