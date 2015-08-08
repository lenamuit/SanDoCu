package com.namlh.sandocu.presentation.internal.component;

import com.namlh.sandocu.presentation.internal.annotation.PerService;
import com.namlh.sandocu.presentation.internal.module.FindNewestModule;
import com.namlh.sandocu.presentation.view.service.FinderIntentService;

import dagger.Component;

/**
 * Created by namlh on 08/08/2015.
 */
@PerService
@Component(dependencies = ApplicationComponent.class,modules = FindNewestModule.class)
public interface FindNewestComponent {
    void inject(FinderIntentService intentService);
}
