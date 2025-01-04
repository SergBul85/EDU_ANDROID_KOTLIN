package com.example.notes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NotesApp() {
    var notes by remember { mutableStateOf(listOf<OneNote>()) }
    var showDialogAlert by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(
            modifier = Modifier.padding(12.dp)
        ) {
            items(notes) {

            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { showDialogAlert = true }
            ) {
                Text("+")
            }
        }
    }

    if (showDialogAlert) {
        AlertDialog(
            onDismissRequest = { showDialogAlert = false },
            confirmButton = { /*TODO*/ })
    }

}


data class OneNote(
    val id: Int,
    var name: String,
    var decription: String,
    var isEditing: Boolean = false
)
