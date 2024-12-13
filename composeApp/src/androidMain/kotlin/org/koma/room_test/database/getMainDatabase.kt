package org.koma.room_test.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getMainDatabase(context: Context) : MainDatabase {
    val dbFile = context.getDatabasePath("main.db")
    return  Room.databaseBuilder<MainDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}