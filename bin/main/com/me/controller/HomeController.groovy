package com.me.controller

import com.me.client.DrummerClient
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.MediaType

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;

@Controller("/home")
class HomeController {
    private final DrummerClient drummerClient;

    HomeController(DrummerClient drummerClient) {
        this.drummerClient = drummerClient
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    def index() {

        Path path = Paths.get "/Users/ashish/Downloads/User.pdf";
        Files.write(path, drummerClient.play());
        return "cool se cooler tak";
    }

    @Get(value = "/ac", produces = MediaType.APPLICATION_JSON)
    def adv() {
        HttpResponse<byte[]> response = drummerClient.melody();
        Optional<String> filenameHeader = response.headers.findFirst(HttpHeaders.CONTENT_DISPOSITION);
        String downloadFilename = realName(filenameHeader?.isPresent() ? filenameHeader.get() : "404");
        Path path = Paths.get "/Users/ashish/Downloads/$downloadFilename";

        Files.write(path, response.getBody().get());
        return "k00l :D"
    }

    String realName(String value) {
        value.contains("filename=") ? value.split('filename=')[1] : 'untitled'
    }

}
