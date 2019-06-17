package com.example.tae.recycleviewexample.model;

//4? Create this (Interface, go to create new class but in a dropdown in there, change class to interface!

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApIService {

    @GET("people")
    Call<StarWarsCharacter> getCharacter();



}

