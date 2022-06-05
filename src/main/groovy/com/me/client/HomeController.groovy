package com.me.client

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.client.annotation.Client;
@Client("https://app.onenotary.us/api/v2")
@Header (name = "X-ONENOTARY-API-TOKEN", value = "1faba275-411f-4972-8a27-a9f0f18deaa0")
interface DrummerClient {

    @Get( value = "/sessions/08f95ca5-eaf4-46c2-9c70-6ef2571e529a/documents/2d406236-75cb-4e39-87f9-e9e4db95cf88/download" ,
            produces = MediaType.TEXT_PLAIN)
    byte[] play();

    @Get( value = "/sessions/08f95ca5-eaf4-46c2-9c70-6ef2571e529a/documents/2d406236-75cb-4e39-87f9-e9e4db95cf88/download" ,
            produces = MediaType.TEXT_PLAIN)
    HttpResponse<byte[]> melody();


}
