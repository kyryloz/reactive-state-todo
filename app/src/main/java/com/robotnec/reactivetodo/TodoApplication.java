package com.robotnec.reactivetodo;

import android.app.Application;

import com.robotnec.reactivetodo.di.ApplicationComponent;
import com.robotnec.reactivetodo.di.ApplicationGraph;

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
