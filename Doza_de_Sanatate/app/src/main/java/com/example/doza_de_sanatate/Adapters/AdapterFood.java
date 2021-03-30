package com.example.doza_de_sanatate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.doza_de_sanatate.Classes.Mancare;
import com.example.doza_de_sanatate.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterFood extends ArrayAdapter<Mancare> {

    private Context myContext;
    private int resourceID;
    private LayoutInflater inflater;

    private ConstraintLayout adapterFoodLayout;
    private ImageView adapterFoodImage;
    private TextView adapterFoodName;
    private TextView adapterFoodKcal;
    private TextView adapterFoodCarb;
    private TextView adapterFoodProtein;


    public AdapterFood(@NonNull Context context, int resource, @NonNull List<Mancare> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.myContext = context;
        this.resourceID = resource;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = inflater.inflate(resourceID, parent, false);

        adapterFoodImage = (ImageView) view.findViewById(R.id.adapter_food_image);
        adapterFoodName = (TextView) view.findViewById(R.id.adapter_food_name);
        adapterFoodKcal =(TextView) view.findViewById(R.id.adapter_food_kcal);
        adapterFoodCarb =(TextView) view.findViewById(R.id.adapter_food_carb);
        adapterFoodProtein =(TextView) view.findViewById(R.id.adapter_food_protein);


        if(getItem(position) != null){
            adapterFoodName.setText(getItem(position).getDenumire().toString());

            int pozaGasita = myContext.getResources().getIdentifier(getItem(position).getPoza(), "drawable", myContext.getPackageName());
            adapterFoodImage.setImageResource(pozaGasita);

            adapterFoodKcal.append(String.valueOf(getItem(position).getKcal()));
            adapterFoodCarb.append(String.valueOf(getItem(position).getCarbs()));
            adapterFoodProtein.append(String.valueOf(getItem(position).getProtein()));
        }
        else{
            adapterFoodImage.setVisibility(View.INVISIBLE);
            adapterFoodProtein.setVisibility(View.INVISIBLE);
            adapterFoodCarb.setVisibility(View.INVISIBLE);
            adapterFoodKcal.setVisibility(View.INVISIBLE);
            adapterFoodName.setVisibility(View.INVISIBLE);

            adapterFoodLayout =  (ConstraintLayout) view.findViewById(R.id.adapter_food_layout);
            adapterFoodLayout.setMaxHeight(290);
        }

        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
