package com.example.tae.recycleviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tae.recycleviewexample.View.StarWarsItemAdapter;
import com.example.tae.recycleviewexample.model.ApIService;
import com.example.tae.recycleviewexample.model.ApiClient;
import com.example.tae.recycleviewexample.model.StarWarsCharacter;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        //6 Finally,
        Call <StarWarsCharacter> starWarsCharacterCall; //cReate call to character to use it
        StarWarsCharacter starWarsCharacter;

private RecyclerView mRecycleViw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleViw=findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        mRecycleViw.setLayoutManager(layoutManager);


        ApIService apIService =
                ApiClient.getClient(this).
                          create(ApIService.class); //This is what is used to make calls!

        starWarsCharacterCall=apIService.getCharacter();

        starWarsCharacterCall.enqueue(new Callback<StarWarsCharacter>() {
            @Override
            public void onResponse(Call<StarWarsCharacter> call, Response<StarWarsCharacter> response) {
                starWarsCharacter=response.body();
                StarWarsItemAdapter starWarsItemAdapter=new StarWarsItemAdapter(starWarsCharacter.getResults());
                mRecycleViw.setAdapter(starWarsItemAdapter);

            }

            @Override
            public void onFailure(Call<StarWarsCharacter> call, Throwable t) {

            }
        });


    }
}
