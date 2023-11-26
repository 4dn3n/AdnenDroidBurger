package fr.isen.kaddouri.droidburger.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import fr.isen.kaddouri.droidburger.R;
import fr.isen.kaddouri.droidburger.ui.BurgerItem;

public class BurgerAdapter extends ArrayAdapter {
    public BurgerAdapter(Context context, ArrayList<BurgerItem> burgerlist){
        super(context, 0,burgerlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView== null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.burger_spinner_row, parent, false
            );
        }
        ImageView imageViewBurger = convertView.findViewById(R.id.image_view_cheesebg);
        TextView  textViewName= convertView.findViewById(R.id.text_view_name);

        BurgerItem currentItem = (BurgerItem) getItem(position);

        if(currentItem != null) {
            imageViewBurger.setImageResource(currentItem.getBurgerImage());
            textViewName.setText(currentItem.getBurgerName());
        }
        return convertView;
    }
}
