package com.robotnec.reactivetodo.core.di;

import android.content.Context;

import com.robotnec.reactivetodo.core.di.module.ServiceModule;

public class ApplicationGraph {

    private final Context context;

    public ApplicationGraph(Context context) {
        this.context = context;
    }

    public ApplicationComponent buildApplicationComponent() {
        return DaggerApplicationComponent
                .builder()
                .serviceModule(new ServiceModule())
                .build();
    }
}
