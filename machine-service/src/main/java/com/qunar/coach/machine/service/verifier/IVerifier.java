package com.qunar.coach.machine.service.verifier;

/**
 * Created by niuli on 15-10-30.
 */
public interface IVerifier<T> {
    /**
     * @param t
     * @return true if t is verified valid, false on the opposite.
     */
    boolean verify(T t);
}