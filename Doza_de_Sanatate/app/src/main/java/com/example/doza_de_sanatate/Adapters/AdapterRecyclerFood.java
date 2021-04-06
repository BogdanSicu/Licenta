package com.example.doza_de_sanatate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doza_de_sanatate.R;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Mancare;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerFood extends RecyclerView.Adapter<AdapterRecyclerFood.MancareHolder> {

    private List<Mancare> mancareList;
    private Context myContext;

    public static class MancareHolder extends RecyclerView.ViewHolder{

        private ConstraintLayout adapterFoodLayout;
        private ImageView adapterFoodImage;
        private TextView adapterFoodName;
        private TextView adapterFoodKcal;
        private TextView adapterFoodCarb;
        private TextView adapterFoodProtein;

        public MancareHolder(@NonNull View itemView) {
            super(itemView);
            adapterFoodImage = (ImageView) itemView.findViewById(R.id.adapter_food_image);
            adapterFoodName = (TextView) itemView.findViewById(R.id.adapter_food_name);
            adapterFoodKcal =(TextView) itemView.findViewById(R.id.adapter_food_kcal);
            adapterFoodCarb =(TextView) itemView.findViewById(R.id.adapter_food_carb);
            adapterFoodProtein =(TextView) itemView.findViewById(R.id.adapter_food_protein);
            adapterFoodLayout =  (ConstraintLayout) itemView.findViewById(R.id.adapter_food_layout);
        }
    }

    public AdapterRecyclerFood(List<Mancare> mancareList, Context context) {
        this.mancareList = mancareList;
        this.myContext = context;
    }

    @NonNull
    @Override
    public MancareHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_food_view, parent, false);
        MancareHolder mancareHolder = new MancareHolder(view);
        return mancareHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MancareHolder holder, int position) {
          Mancare mancareItem = this.mancareList.get(position);

          if(mancareItem != null){
             holder.adapterFoodName.setText(mancareItem.getDenumire().toString());

              int pozaGasita = myContext.getResources().getIdentifier(mancareItem.getPoza(), "drawable", myContext.getPackageName());
              holder.adapterFoodImage.setImageResource(pozaGasita);

              holder.adapterFoodKcal.append(String.valueOf(mancareItem.getKcal()));
              holder.adapterFoodCarb.append(String.valueOf(mancareItem.getCarbs()));
              holder.adapterFoodProtein.append(String.valueOf(mancareItem.getProtein()));
          }else{
              holder.adapterFoodImage.setVisibility(View.INVISIBLE);
              holder.adapterFoodProtein.setVisibility(View.INVISIBLE);
              holder.adapterFoodCarb.setVisibility(View.INVISIBLE);
              holder.adapterFoodKcal.setVisibility(View.INVISIBLE);
              holder.adapterFoodName.setVisibility(View.INVISIBLE);
              holder.adapterFoodLayout.setMaxHeight(290);
          }
    }

    @Override
    public int getItemCount() {
        return mancareList.size();
    }
}
