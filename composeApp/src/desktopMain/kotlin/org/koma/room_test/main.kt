package org.koma.room_test

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koma.room_test.database.getMainDatabase

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "room_test",
    ) {
        val dao = getMainDatabase()
        App(dao)
    }
}

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()