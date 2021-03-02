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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R


val putty1 = Putty(
    name = "GUNTHER",
    location = "Morris, NY",
    age = 1,
    gender = "Male",
    breed = " Pointer & Terrier Mix ",
    imageId = R.mipmap.puppy_1,
    description = "Gunther is young, strong and a very good dog.\n" +
            "He is a very good nature puppy, playful, willing to learn,crate trained and affectionate and he was left at the shelter because of his prey drive (chasing small critters.)\n" +
            "He is beautiful, loves playing with his toys and is good with calmer and more submissive dogs.\n" +
            "We suggest that it would be easier for him to adjust in a home without other dogs and not small kids.\n" +
            "Gunther is beautiful, walks very well on leash and loves to play. He is about 65 lbs, beautiful marking and hazel eyes."
)

val putty2 = Putty(
    name = "Montey",
    location = "Clay, NY",
    age = 1,
    gender = "Male",
    breed = "Pit Bull Terrier",
    imageId = R.mipmap.puppy_2,
    description = "Montey is an 11 week old pit mix. He has been socialized with cats, dogs and kids.\n" +
            "\n" +
            "But he does have puppy behaviors such as nipping and jumping and working on house training.\n" +
            "\n" +
            "He is currently crate trained and will need a home who will continue to work on manners with him. As well as socialization"
)

val putty3 = Putty(
    name = "FLINT",
    location = " Thompson, PA",
    age = 1,
    gender = "Male",
    breed = " Australian Shepherd & Chow Chow Mix",
    imageId = R.mipmap.puppy_3,
    description = "Meet the Foxy F bunch! They were about to be abandoned in the woods down South and left to fend for themselves. Sadly, one of the pups was hit by a car and didn't make it. We are guessing they were born Mid-December 2020. They are a cute mix that we are guessing may be some of these breeds... Australian Shepherd, Chow, and ABD mix. They will be arriving Mid-March to our Thompson, PA facility.\n" +
            "\n" +
            "They will be altered, vaccinated, and microchipped before being placed for adoption. Please visit http://www.rdrne.org for more information. Please also read the info on the Adoption Process tab so you know what to expect."
)

val putty4 = Putty(
    name = "MINA",
    location = " Thompson, PA",
    age = 1,
    gender = "Male",
    breed = " American Bulldog Mix",
    imageId = R.mipmap.puppy_4,
    description = "Shes sweet pup!! Fully vetted, ready for home She will be arriving at our Thompson PA facility on 3/6/21.\n" +
            "\n" +
            "If interested please go to our website www.rdrne.org to fill out an application. Please while there, open the Adoption Process tab to learn what to expect once we receive and applicaton."
)

val putty5 = Putty(
    name = "Sheldon",
    location = " Union Dale, PA",
    age = 1,
    gender = "Male",
    breed = " American Staffordshire Terrier Mix",
    imageId = R.mipmap.puppy_5,
    description = "Happy go lucky, playful, social and active little Sheldon is looking for a home. Sheldon is an American Staffordshire Terrier puppy - estimated to be about 4 months old. He loves to run and play and say Hello to every person he meets. He would love a calm and social older dog sibling to show him how the world works."
)

val puttys: List<Putty> =
    listOf(
        putty1,
        putty2,
        putty3,
        putty4,
        putty5
    )