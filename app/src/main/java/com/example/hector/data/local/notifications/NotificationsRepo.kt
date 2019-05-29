package com.example.hector.data.local.notifications
import io.reactivex.Observable

interface NotificationsRepo {

    fun isNotificationsRepoEmpty(): Observable<Boolean>

    fun insertNotifications(notifications: List<Notification>): Observable<Boolean>

    fun loadNotifications(): Observable<List<Notification>>
}