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
package com.example.androiddevchallenge.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PuppyId
import com.example.androiddevchallenge.repository.PuppyRepository
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.paddingLarge
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyPage(puppyId: String) {
    val puppy = PuppyRepository().get(PuppyId(puppyId))
    puppy?.let {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = puppy.imageResId),
                contentDescription = puppy.name,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(paddingLarge)
                    .clip(shapes.medium)
                    .fillMaxWidth()
            )
            Text(
                text = puppy.name,
                style = typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(paddingLarge)
            )
            Text(
                text = puppy.profile,
                style = typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(paddingLarge, 0.dp, paddingLarge)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyPageLightPreview() {
    MyTheme {
        PuppyPage("1")
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyPageDarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyPage("1")
    }
}
