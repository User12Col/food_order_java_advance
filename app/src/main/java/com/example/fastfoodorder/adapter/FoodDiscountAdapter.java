package com.example.fastfoodorder.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfoodorder.R;
import com.example.fastfoodorder.Screens.FoodDetailActivity;
import com.example.fastfoodorder.models.Food;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodDiscountAdapter extends RecyclerView.Adapter<FoodDiscountAdapter.ViewHolder>{
    private Context context;
    private List<Food> foods;

    public FoodDiscountAdapter(Context context, List<Food> foods) {
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View heroView = inflater.inflate(R.layout.food_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtFoodName.setText(foods.get(position).getName());
        holder.txtFoodDescribe.setText(foods.get(position).getDescription());
        holder.txtFoodPrice.setText(String.valueOf(foods.get(position).getUnitPrice()));

        Picasso.get().load(foods.get(position).getImage()).into(holder.imgFood);

        Food selectFood = foods.get(position);
        holder.foodItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                Intent intent = new Intent(context.getApplicationContext(), FoodDetailActivity.class);
                intent.putExtra("food", gson.toJson(selectFood));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtFoodName, txtFoodDescribe, txtFoodPrice;
        private Button btnDecrease, btnIncrease;
        private ImageView imgFood;
        private LinearLayout foodItemLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFoodName = itemView.findViewById(R.id.txtFoodName);
            txtFoodDescribe = itemView.findViewById(R.id.txtFoodDescribe);
            txtFoodPrice = itemView.findViewById(R.id.txtFoodPrice);

            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);

            imgFood = itemView.findViewById(R.id.imgFood);
            foodItemLayout = itemView.findViewById(R.id.foodItemLayout);
        }
    }
}
