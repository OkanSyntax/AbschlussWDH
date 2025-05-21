package com.example.di_navi_wdh.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.di_navi_wdh.ui.component.TitleBar

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {

    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TitleBar(modifier, "Settings")
        Text("Volume")
        Text("Profile")
        Text("Dev Mode")
    }
}

