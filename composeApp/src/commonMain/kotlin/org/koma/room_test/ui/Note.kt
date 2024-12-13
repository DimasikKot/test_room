package org.koma.room_test.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.koma.room_test.database.Note
import org.koma.room_test.database.NoteDao

@Composable
fun UiNote(modifier: Modifier = Modifier, noteDao: NoteDao, it: Note) {
    val scope = rememberCoroutineScope()
    Card(elevation = 8.dp, modifier = modifier.fillMaxWidth()) {
        Text(
            text = it.text,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    scope.launch {
                        noteDao.delete(it)
                    }
                })
                .padding(8.dp)
        )
    }
}