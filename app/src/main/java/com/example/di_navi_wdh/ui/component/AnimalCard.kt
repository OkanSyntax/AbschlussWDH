package com.example.di_navi_wdh.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.di_navi_wdh.data.model.Animal
import kotlinx.coroutines.delay

@Composable
fun AnimalCard(
    modifier: Modifier = Modifier,
    onFavorite: () -> Unit,
    animal: Animal,
    // fadeIn
    index: Int,

    // Sound
    onClick: () -> Unit
) {

    // rotation
    var rotation by remember { mutableStateOf(0f) }

    val rotationAnimation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = tween(durationMillis = 500)
    )
    LaunchedEffect(animal.isFavorite) {
        if (animal.isFavorite) {
            rotation += 360f
        }
    }

    // color change
    var isClicked by remember { mutableStateOf(false)}

    val color by animateColorAsState(
        targetValue = if (isClicked) Color.Green.copy(0.3f) else Color.Transparent,
        animationSpec = tween (2000)
    )

    val heartColor by animateColorAsState(
        targetValue = if (animal.isFavorite) Color.Red else Color.White,
        animationSpec = tween(durationMillis = 500)
    )

    // scale
    val scale by animateFloatAsState(
        targetValue =  if (animal.isFavorite) 1.3f else 1f,
        animationSpec = tween(durationMillis = 500)
    )

    // FadeIn
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(index * 200L)
        isVisible = true
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(tween(300)),
        exit = fadeOut(tween(300))
    ) {



    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            Modifier.fillMaxWidth()
                    // Sound
                .clickable{
                    onClick()
                    isClicked = !isClicked
                          }
                .background(color),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
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
                    tint = heartColor,
                    modifier = Modifier
                        .size(35.dp)
                        .rotate(rotationAnimation)
                        .scale(scale)
                )
            }
        }
    }

    }
}