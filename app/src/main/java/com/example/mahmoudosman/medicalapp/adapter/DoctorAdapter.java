package com.example.mahmoudosman.medicalapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mahmoudosman.medicalapp.R;
import com.example.mahmoudosman.medicalapp.activity.DoctorDetails;
import com.example.mahmoudosman.medicalapp.model.DoctorModel;

import java.util.List;

public class DoctorAdapter  extends RecyclerView.Adapter<DoctorAdapter.MyViewHolder> {

    List<DoctorModel> data ;
    Context context;
    private LayoutInflater inflater;

    public DoctorAdapter(List<DoctorModel> data, Context context){
        this.data = data;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public DoctorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_doctor, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DoctorAdapter.MyViewHolder holder, int position) {
        DoctorModel inboxData = data.get(position);
        holder.Name.setText(inboxData.getDoctorName());
        holder.about.setText(inboxData.getDoctorDesc());
//        holder.about.setText(inboxData.getDoctorRating());
        holder.ratingBar.setRating(inboxData.getDoctorRating());

//        if (!inboxData.getDoctorPhoto().equals("")){
//                 Glide.with(context).load(inboxData.getDoctorPhoto()).into(holder.ChatImg);
//        }

        //set on click for favorite .
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView favouriteImage = ((ImageView) v);

                if (favouriteImage.getTag().toString().equals("normal")) {
                    favouriteImage.setTag("pressed");
                    favouriteImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_like_done));
                    } else {
                    favouriteImage.setTag("normal");
                    favouriteImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_like_before));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView ChatImg;
        TextView Name;
        TextView about;
        RatingBar ratingBar;
        ImageButton favorite;


        public MyViewHolder(final View itemView) {
            super(itemView);

            ChatImg = itemView.findViewById(R.id.doctor_img);
            Name = itemView.findViewById(R.id.doctor_name_textview);
            about = itemView.findViewById(R.id.doctor_description_textview);
            ratingBar=itemView.findViewById(R.id.rating_view);
            favorite = itemView.findViewById(R.id.favorite_button_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent= new Intent(context,DoctorDetails.class);
                    intent.putExtra(Intent.EXTRA_TEXT, data.get(position));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }

    }
}
