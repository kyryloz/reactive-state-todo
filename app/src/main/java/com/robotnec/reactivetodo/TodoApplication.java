package com.robotnec.reactivetodo;

import android.app.Application;

import com.robotnec.reactivetodo.core.di.ApplicationComponent;
import com.robotnec.reactivetodo.core.di.ApplicationGraph;

public class TodoApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = new ApplicationGraph(this).buildApplicationComponent();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
