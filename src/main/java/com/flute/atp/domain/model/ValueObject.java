package com.flute.atp.domain.model;

public abstract class ValueObject<T> {

    @Override

    public boolean equals(Object obj) {

        T valueObject = (T) obj;

        if (valueObject == null)

            return false;

        return equalsCore(valueObject);

    }

    @Override

    public int hashCode() {

        return getHashCodeCore();

    }

    /**
     * 但是这种做法有两个优点。首先，这两个新方法是抽象的，这意味着我们不会忘记在派生值对象类中实现它们。
     * 编译器会通知我们的。其次，我们要确保equalsCore方法的公共对象与当前valueObject的类型相同，并且它不是null。
     * 因此，我们不需要在派生类中复制这些检查，我们可以把它们收集到这里
     * @param other
     * @return
     */
    protected abstract boolean equalsCore(T other);

    protected abstract int getHashCodeCore();

}
