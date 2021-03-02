/*
 * Copyright 2021 ZhaoYouZhi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.putty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Putty
import com.example.androiddevchallenge.data.putty1
import com.example.androiddevchallenge.ui.ThemedPreview

private val defaultSpacerSize = 16.dp

@Composable
fun PuttyContent(putty: Putty, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = defaultSpacerSize)
    ) {
        item {
            Spacer(Modifier.height(defaultSpacerSize))
            PostImage(putty)
        }
        item {
            Text(text = putty.name, style = MaterialTheme.typography.h4)
            Spacer(Modifier.height(8.dp))
        }
        putty.breed.let { subtitle ->
            item {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.subtitle2,
                        lineHeight = 20.sp
                    )
                }
                Spacer(Modifier.height(defaultSpacerSize))
            }
        }
        item {
            Text(text = putty.description, style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
private fun PostImage(putty: Putty) {
    val imageModifier = Modifier
        .heightIn(min = 180.dp)
        .fillMaxWidth()
        .clip(shape = MaterialTheme.shapes.medium)
    Image(
        painter = painterResource(putty.imageId),
        contentDescription = null,
        modifier = imageModifier,
        contentScale = ContentScale.Crop
    )
    Spacer(Modifier.height(defaultSpacerSize))
}

@Preview("Putty content")
@Composable
fun PreviewPutty() {
    ThemedPreview {
        PuttyContent(putty = putty1)
    }
}
