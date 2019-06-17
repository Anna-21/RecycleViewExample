package com.example.tae.recycleviewexample.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tae.recycleviewexample.R;
import com.example.tae.recycleviewexample.model.Result;


import java.util.List;

//Create the extend class and Import the 3 methods to bind which are
// ( onCreateViewHolder, onBindViewHolder, onBindViewHolder)
public class StarWarsItemAdapter extends RecyclerView.Adapter <StarWarsItemAdapter.StarWarsViewHolder>{

    public List<Result> characterMap;

    public StarWarsItemAdapter ( List characterMap){
        this.characterMap = characterMap;
    }
// The methods override have been imported
    @NonNull
    @Override
    public StarWarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

//will give us a view. it is false to don't attachet to the vire straight away
        // this ia the constructor
       View view = inflater.inflate(R.layout.star_wars_character_row,parent,false);
        return new StarWarsViewHolder(view);
    }
//on bind viewholder we put the information that we are going to display. we bind the information from the object to the view.
    @Override
    public void onBindViewHolder(@NonNull StarWarsViewHolder holder, int position) {
        holder.characterName.setText(characterMap.get(position).getName());
        holder.characterBirthday.setText(characterMap.get(position).getBirthYear());

    }
// we get the number o the row we used
    @Override
    public int getItemCount() {
        return characterMap.size();
    }
    public class StarWarsViewHolder extends RecyclerView.ViewHolder{

  // now we can access the text files that we added to the UI (xml file)

  private TextView characterName;
  private TextView characterBirthday;

        public StarWarsViewHolder(@NonNull View itemView) {
            super(itemView);

            //create the viw
            characterName=itemView.findViewById(R.id.characterName);
            characterBirthday=itemView.findViewById(R.id.characterBirthday);
        }
    }
}
