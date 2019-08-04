package com.example.hector.annotations

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PreferenceInfo

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApiInfo

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseInfo

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext