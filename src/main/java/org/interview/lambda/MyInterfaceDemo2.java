package org.interview.lambda;

/**
 * MyInterface<T> 這邊的 T 要寫，意思是要用 T 來聲明類型
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyInterfaceDemo2<T> {
    public <T> T getValue(T t);
}

