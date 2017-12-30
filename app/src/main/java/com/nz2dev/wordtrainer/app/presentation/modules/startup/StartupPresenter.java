package com.nz2dev.wordtrainer.app.presentation.modules.startup;

import com.nz2dev.wordtrainer.app.preferences.AppPreferences;
import com.nz2dev.wordtrainer.app.presentation.infrastructure.BasePresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by nz2Dev on 30.11.2017
 */
@Singleton
public class StartupPresenter extends BasePresenter<StartupView> {

    private static final long SPLASH_DELAY_MS = 300;

    private AppPreferences appPreferences;

    @Inject
    public StartupPresenter(AppPreferences appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    protected void onViewReady() {
        super.onViewReady();
        Single.timer(SPLASH_DELAY_MS, MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(z -> {
            if (appPreferences.isCourseIdSpecified()) {
                getView().navigateHome();
            } else {
                getView().navigateCourseCreation();
            }
        });
    }

//    TODO read about AUTO_BOOT_COMPLETE broadcast and test how it works exactly
//    TODO and if it can be equivalent to this approach below

//    TODO it can be useful to store name of services with should be started right after app starts
//    private void initAutoStartedServices() {
//        try {
//            String autoStartedServiceName = TrainingScheduleService.class.getName();
//            Class<?> clazz = Class.forName(autoStartedServiceName);
//
//            if (clazz.isAssignableFrom(Service.class)) {
//                context.startService(new Intent(context, clazz));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
