package com.namlh.sandocu.presentation.internal.component;

import com.namlh.sandocu.presentation.internal.annotation.PerService;
import com.namlh.sandocu.presentation.internal.module.HunterModule;
import com.namlh.sandocu.presentation.view.service.HunterIntentService;

import dagger.Component;

/**
 * Created by namlh on 08/08/2015.
 */
@PerService
@Component(dependencies = ApplicationComponent.class,modules = HunterModule.class)
public interface HunterComponent {
    void inject(HunterIntentService intentService);
}
