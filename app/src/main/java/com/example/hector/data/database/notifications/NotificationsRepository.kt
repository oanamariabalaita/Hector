package com.example.hector.data.database.notifications

import io.reactivex.Observable
import javax.inject.Inject

class NotificationsRepository @Inject constructor(private val notificationsDao: NotificationsDao) : NotificationsRepo {

    override fun isNotificationsRepoEmpty(): Observable<Boolean> = Observable.fromCallable {
        notificationsDao.loadAll().isEmpty()
    }

    override fun insertNotifications(notifications: List<Notification>): Observable<Boolean> {

        notificationsDao.insertAll(notifications)
        return Observable.just(true)
    }

    override fun loadNotifications():
            Observable<List<Notification>> =
        Observable.fromCallable {
            notificationsDao.loadAll()
        }
}