/*
 * Copyright 2021 The Android Open Source Project
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Putty
import com.example.androiddevchallenge.data.putty1
import com.example.androiddevchallenge.data.puttys
import com.example.androiddevchallenge.ui.Screen
import com.example.androiddevchallenge.ui.ThemedPreview
import com.example.androiddevchallenge.ui.theme.purple700


@Preview("PuttyPreview")
@Composable
fun PuttyPreview() {
    ThemedPreview {
        PostCardHistory(putty = putty1) {}
    }
}

@Preview("Putty screen body")
@Composable
fun PreviewPuttyScreenBody() {
    ThemedPreview {
        val posts = puttys
        PostList(posts, {}, setOf(), {})
    }
}

@Composable
fun PuttyScreen(
    navigateTo: (Screen) -> Unit
) {
    ThemedPreview {
        val posts = puttys
        PostList(posts, navigateTo, setOf(), {})
    }
}

@Composable
private fun PostList(
    posts: List<Putty>,
    navigateTo: (Screen) -> Unit,
    favorites: Set<String>,
    onToggleFavorite: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item { PuttyBody(posts, navigateTo = navigateTo) }
    }
}


/**
 * The Putty screen.
 */
@Composable
fun PuttyBody(putty: List<Putty>, navigateTo: (Screen) -> Unit) {
    Column {
        putty.forEach { post ->
            PostCardHistory(post, navigateTo = navigateTo)
            PostListDivider()
        }
    }
}

/**
 * Full-width divider with padding for [PostList]
 */
@Composable
private fun PostListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Composable
fun PostCardHistory(putty: Putty, navigateTo: (Screen) -> Unit) {
    Row(
        Modifier
            .clickable(onClick = {
                navigateTo(Screen.DetailS(putty))
            })
            .padding(16.dp)
    ) {
        PostImage(
            putty = putty,
            modifier = Modifier.padding(end = 16.dp)
        )
        Column(Modifier.weight(1f)) {
            PostTitle(putty = putty)
            BreedAndLocation(
                putty = putty,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun PostImage(putty: Putty, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(putty.imageId),
        contentDescription = null, // decorative
        modifier = modifier
            .size(60.dp, 60.dp)
            .clip(MaterialTheme.shapes.medium)
    )
}

@Composable
fun PostTitle(putty: Putty) {
    Text(
        putty.name,
        style = MaterialTheme.typography.subtitle1,
        fontSize = 20.sp,
        color = purple700
    )
}

@Composable
fun BreedAndLocation(
    putty: Putty,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            val textStyle = MaterialTheme.typography.body2
            Column(Modifier.weight(1f)) {
                Text(
                    text = putty.breed,
                    style = textStyle
                )
                Text(
                    text = putty.location,
                    style = textStyle
                )
            }

        }
    }
}
