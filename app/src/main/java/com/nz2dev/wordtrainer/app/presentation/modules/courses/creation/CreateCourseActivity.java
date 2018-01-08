package com.nz2dev.wordtrainer.app.presentation.modules.courses.creation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nz2dev.wordtrainer.app.R;
import com.nz2dev.wordtrainer.app.presentation.infrastructure.HasDependencies;
import com.nz2dev.wordtrainer.app.utils.DependenciesUtils;

/**
 * Created by nz2Dev on 30.12.2017
 */
public class CreateCourseActivity extends AppCompatActivity implements HasDependencies<CreateCourseComponent> {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, CreateCourseActivity.class);
    }

    private CreateCourseComponent dependencies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_default, CreateCourseFragment.newInstance())
                .commit();
    }

    @Override
    public CreateCourseComponent getDependencies() {
        if (dependencies == null) {
            dependencies = DependenciesUtils
                    .appComponentFrom(this)
                    .createCreateCourseComponent();
        }
        return dependencies;
    }
}
