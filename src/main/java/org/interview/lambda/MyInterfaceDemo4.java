package org.interview.lambda;

/**
 * 指定回傳使用 String，這是跟之前 MyInterfaceDemo2、MyInterfaceDemo3 不一樣的地方
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyInterfaceDemo4<T> {
    public String getValue(T t);
}