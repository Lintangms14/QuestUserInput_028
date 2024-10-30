package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview (showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var noTeleponsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("") }

    val listJK = listOf("Laki-Laki", "Perempuan")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Biodata", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = modifier.fillMaxWidth().padding(5.dp),
            value = namasv,
            onValueChange = { namasv = it },
            label = { Text("nama") },
            placeholder = { Text("Masukkan Nama Anda") }
        )

        Row {
            listJK.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = memilihJKsv == item,
                        onClick = {
                            memilihJKsv == item
                        }
                    )
                    Text(item)
                }
            }
            TextField(
                modifier = modifier.fillMaxWidth().padding(5.dp),
                value = emailsv,
                onValueChange = { emailsv = it },
                label = { Text("email") },
                placeholder = { Text("Masukkan email Anda") }
            )

            TextField(
                modifier = modifier.fillMaxWidth().padding(5.dp),
                value = noTeleponsv,
                onValueChange = { noTeleponsv = it },
                label = { Text("noTelepon") },
                placeholder = { Text("Masukkan noTelepon Anda") }
            )

            TextField(
                modifier = modifier.fillMaxWidth().padding(5.dp),
                value = alamatsv,
                onValueChange = { alamatsv = it },
                label = { Text("alamat") },
                placeholder = { Text("Masukkan alamat Anda") }
            )
            ElevatedButton(onClick = {
                namasv = nama
                emailsv = email
                noTeleponsv = noTelepon
                alamatsv = alamat
                memilihJKsv = memilihJK
            }) {
                Text("Submit")
            }
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.Black),
            ) {
                DetailSurat()
            }
        }
    }
}