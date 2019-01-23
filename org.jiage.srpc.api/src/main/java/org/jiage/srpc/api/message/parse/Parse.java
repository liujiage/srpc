package org.jiage.srpc.api.message.parse;

public interface Parse<T,E> {

     T convert(E e) throws Exception;
}
