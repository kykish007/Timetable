package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.timetable.adapter.OccupationAdapter;
import com.example.timetable.data.MainViewModel;
import com.example.timetable.data.Occupation;
import com.example.timetable.utils.JSONUtils;
import com.example.timetable.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewOccupation;
    private OccupationAdapter adapter;
    private ArrayList<Occupation> occupationArrayList;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewOccupation = findViewById(R.id.recyclerViewOccupation);
        recyclerViewOccupation.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OccupationAdapter();
        recyclerViewOccupation.setAdapter(adapter);
        JSONArray jsonObject = NetworkUtils.GetJSONFromNetwork();
        occupationArrayList = JSONUtils.getOccupationFromJSON(jsonObject);
        adapter.setOccupations(occupationArrayList);
        if (occupationArrayList.size() == 0) {
            Toast.makeText(this, R.string.message_inet_off, Toast.LENGTH_LONG).show();
            viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            for (Occupation occupations : occupationArrayList) {
                viewModel.InsertOccupation(occupations);
            }
            LiveData<List<Occupation>> occupationFromLiveData = viewModel.getOccupation();
            occupationFromLiveData.observe(this, new Observer<List<Occupation>>() {
                @Override
                public void onChanged(List<Occupation> occupations) {
                    adapter.setOccupations(occupations);
                }
            });
        } else {
            Toast.makeText(this, R.string.message_inet_on, Toast.LENGTH_LONG).show();
        }

    }
}
