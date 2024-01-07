package org.interview.lambda;

/**
 * MyInterface<T> 這邊的 T 要寫，意思是要用 T 來聲明類型
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyInterfaceDemo3<T> {
    public T getValue(T t);
}