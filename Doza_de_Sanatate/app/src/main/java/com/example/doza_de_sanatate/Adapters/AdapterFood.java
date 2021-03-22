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

    static class ViewHolder{
        private ImageView adapterFoodImage;
        private TextView adapterFoodName;
        private TextView adapterFoodKcal;
        private TextView adapterFoodCarb;
        private TextView adapterFoodProtein;
        private ConstraintLayout adapterFoodLayout;
    }

    public AdapterFood(@NonNull Context context, int resource, @NonNull List<Mancare> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.myContext = context;
        this.resourceID = resource;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(resourceID, parent, false);

        AdapterFood.ViewHolder holder = new AdapterFood.ViewHolder();
        holder.adapterFoodImage = (ImageView) convertView.findViewById(R.id.adapter_food_image);
        holder.adapterFoodName = (TextView) convertView.findViewById(R.id.adapter_food_name);
        holder.adapterFoodKcal =(TextView) convertView.findViewById(R.id.adapter_food_kcal);
        holder.adapterFoodCarb =(TextView) convertView.findViewById(R.id.adapter_food_carb);
        holder.adapterFoodProtein =(TextView) convertView.findViewById(R.id.adapter_food_protein);
        holder.adapterFoodLayout = (ConstraintLayout) convertView.findViewById(R.id.adapter_food_layout);
        convertView.setTag(holder);

        if(getItem(position) != null){
            holder.adapterFoodName.setText(getItem(position).getDenumire().toString());

            int pozaGasita = myContext.getResources().getIdentifier(getItem(position).getPoza(), "drawable", myContext.getPackageName());
            holder.adapterFoodImage.setImageResource(pozaGasita);

            holder.adapterFoodKcal.append(String.valueOf(getItem(position).getKcal()));
            holder.adapterFoodCarb.append(String.valueOf(getItem(position).getCarbs()));
            holder.adapterFoodProtein.append(String.valueOf(getItem(position).getProtein()));
        }
        else{
            holder.adapterFoodImage.setVisibility(View.INVISIBLE);
            holder.adapterFoodProtein.setVisibility(View.INVISIBLE);
            holder.adapterFoodCarb.setVisibility(View.INVISIBLE);
            holder.adapterFoodKcal.setVisibility(View.INVISIBLE);
            holder.adapterFoodName.setVisibility(View.INVISIBLE);
            holder.adapterFoodLayout.setMinHeight(180);
            holder.adapterFoodLayout.setMaxHeight(220);
        }

        return convertView;
    }
}
