package com.example.timetable.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetable.R;
import com.example.timetable.data.Occupation;

import java.util.ArrayList;
import java.util.List;

public class OccupationAdapter extends RecyclerView.Adapter<OccupationAdapter.OccupationViewHolder> {

    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
        notifyDataSetChanged();
    }

    private List<Occupation> occupations;

    private TextView textViewName;
    private TextView textViewDescription;
    private TextView textViewTeacher;
    private TextView textViewPlace;
    private TextView textViewTime;

    @NonNull
    @Override
    public OccupationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_occupation, parent, false);
        return new OccupationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OccupationViewHolder holder, int position) {
        Occupation occupation = occupations.get(position);
        textViewName.setText(dayOfInt(occupation.getWeekDay()) + " - " + occupation.getName());
        textViewDescription.setText(occupation.getDescription());
        textViewPlace.setText(occupation.getPlace());
        textViewTeacher.setText(occupation.getTeacher());
        textViewTime.setText(occupation.getStartTime() + " - " + occupation.getEndTime());
    }

    private String dayOfInt(int day) {
        String result = null;
        switch (day) {
            case 1: {
                result = "Понедельник";
                break;
            }
            case 2: {
                result = "Вторник";
                break;
            }
            case 3: {
                result = "Среда";
                break;
            }
            case 4: {
                result = "Четверг";
                break;
            }
            case 5: {
                result = "Пятница";
                break;
            }
            case 6: {
                result = "Суббота";
                break;
            }
            case 7: {
                result = "Воскресенье";
                break;
            }
        }
        return result;
    }

    @Override
    public int getItemCount() {
        return occupations.size();
    }

    public class OccupationViewHolder extends RecyclerView.ViewHolder {


        public OccupationViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewPlace = itemView.findViewById(R.id.textViewPlace);
            textViewTeacher = itemView.findViewById(R.id.textViewTeacher);
            textViewTime = itemView.findViewById(R.id.textViewTime);
        }
    }
}
