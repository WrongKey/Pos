package com.wrongkey;

/**
 *@author wrongkey
 *@description
 *@date 2014/11/16
 *@version v1.0
 *
 */
public class Currency<T extends Currency> implements Add{
    protected float value;
    protected float rateToBase;//对美元的汇率

    public Currency(float value, float rateToBase) {
        this.value = value;
        this.rateToBase = rateToBase;
    }

    public float getRateToBase() {
        return rateToBase;
    }

    public void setRateToBase(float rateToBase) {
        this.rateToBase = rateToBase;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    /**
     * @param currency
     * @return com.wrongkey.Currency
     * @author wrongkey
     * @description
     * @date 2014/11/16
     */
    @Override
    public T add(Currency currency) {
        setValue((getValue()*getRateToBase()+currency.getValue()*currency.getRateToBase())/getRateToBase());
        return (T)this;
    }
}
