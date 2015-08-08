package com.namlh.sandocu.presentation.internal.component;

import com.namlh.sandocu.presentation.internal.annotation.PerActivity;
import com.namlh.sandocu.presentation.internal.module.ActivityModule;
import com.namlh.sandocu.presentation.internal.module.SearchModule;
import com.namlh.sandocu.presentation.view.activity.ListResultActivity;
import com.namlh.sandocu.presentation.view.fragment.ListResultFragment;

import dagger.Component;

/**
 * Created by namlh on 06/08/2015.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, SearchModule.class})
public interface SearchComponent extends ActivityComponent {
    void inject(ListResultFragment fragment);
    void inject(ListResultActivity activity);
}
