package com.example.di_navi_wdh.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.di_navi_wdh.data.model.Animal

@Composable
fun AnimalCard(
    modifier: Modifier = Modifier,
    onFavorite: () -> Unit,
    animal: Animal
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(16.dp).weight(1f)) {
                Text(
                    text = animal.name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = animal.color,
                    fontSize = 20.sp
                )

            }
            IconButton(onClick = onFavorite) {
                Icon(
                    imageVector = if (animal.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (animal.isFavorite) "Unfavorite Animal" else "Favorite Animal",
                    modifier = Modifier.size(35.dp)
                )
            }
        }


    }
}