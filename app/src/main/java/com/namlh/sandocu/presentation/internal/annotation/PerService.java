package com.namlh.sandocu.presentation.internal.annotation;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by namlh on 08/08/2015.
 */
@Scope
@Retention(RUNTIME)
public @interface PerService {
}
