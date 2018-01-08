package com.nz2dev.wordtrainer.app.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.nz2dev.wordtrainer.app.common.WordTrainerApp;
import com.nz2dev.wordtrainer.app.presentation.infrastructure.HasDependencies;
import com.nz2dev.wordtrainer.app.common.dependencies.AppComponent;

/**
 * Created by nz2Dev on 30.11.2017
 */
public class DependenciesUtils {

    public static AppComponent appComponentFrom(Context context) {
        return ((WordTrainerApp) context.getApplicationContext()).getDependenciesComponent();
    }

    @NonNull
    public static <C, A extends Activity & HasDependencies<C>> C fromAttachedActivity(Fragment f, Class<A> type) {
        A activity = type.cast(f.getActivity());
        if (activity == null) {
            throw new RuntimeException("fragment activity isn't " + type.toString());
        }
        return activity.getDependencies();
    }
}
