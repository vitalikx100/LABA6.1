package org.example.functions.meta;

import org.example.functions.Function;

public class Power implements Function {

    private Function base;
    private double rate;

    public Power(Function base, double rate){
        this.base=base;
        this.rate=rate;
    }

    public double getRightDomainBorder(){
      return base.getRightDomainBorder();
    }

    public double getLeftDomainBorder(){
       return base.getLeftDomainBorder();
    }

    public double getFunctionValue(double x){
        return Math.pow(base.getFunctionValue(x),rate);
    }
}
