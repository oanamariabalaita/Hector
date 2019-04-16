package com.example.hector.data.database.notifications
import io.reactivex.Observable

interface NotificationsRepo {

    fun isNotificationsRepoEmpty(): Observable<Boolean>

    fun insertNotifications(healthIndicators: List<Notification>): Observable<Boolean>

    fun loadNotifications(): Observable<List<Notification>>
}