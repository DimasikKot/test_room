package org.koma.room_test.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

fun getMainDatabase(): MainDatabase {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "main2.db")
    return Room.databaseBuilder<MainDatabase>(
        name = dbFile.absolutePath,
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}