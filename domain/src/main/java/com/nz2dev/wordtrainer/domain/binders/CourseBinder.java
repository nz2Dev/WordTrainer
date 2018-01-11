package com.nz2dev.wordtrainer.domain.binders;

import com.nz2dev.wordtrainer.domain.models.Course;
import com.nz2dev.wordtrainer.domain.models.CourseBase;
import com.nz2dev.wordtrainer.domain.models.Language;
import com.nz2dev.wordtrainer.domain.repositories.LanguageRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by nz2Dev on 10.01.2018
 */
@Singleton
public class CourseBinder {

    private LanguageRepository languageRepository;

    @Inject
    public CourseBinder(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Single<Course> bindCourse(Course course) {
        return Single.create(emitter -> {
            if (!course.isFullSpecified()) {
                if (!course.getOriginalLanguage().isQuiteDefined()) {
                    course.setOriginalLanguage(languageRepository
                            .getLanguage(course.getOriginalLanguage().getKey())
                            .blockingGet());
                }
                if (!course.getTranslationLanguage().isQuiteDefined()) {
                    course.setTranslationLanguage(languageRepository
                            .getLanguage(course.getTranslationLanguage().getKey())
                            .blockingGet());
                }
            }
            emitter.onSuccess(course);
        });
    }

    public Single<CourseBase> bindCourseBase(CourseBase courseBase) {
        return Single.create(emitter -> {
            if (!courseBase.isFullSpecified()) {
                if (!courseBase.getOriginalLanguage().isQuiteDefined()) {
                    courseBase.setOriginalLanguage(languageRepository
                            .getLanguage(courseBase.getOriginalLanguage().getKey())
                            .blockingGet());
                }
            }
            emitter.onSuccess(courseBase);
        });
    }

}