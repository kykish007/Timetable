package com.example.timetable.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainViewModel extends AndroidViewModel {

    public static OccupationDatabase database;
    private LiveData<List<Occupation>> occupation;

    public  LiveData<List<Occupation>> getOccupation() {
        return occupation;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        database = OccupationDatabase.getInstance(getApplication());
        occupation = database.occupationDAO().getAllOccupation();
    }

    public Occupation GetOccupationById(int id) {
        try {
            return new GetOccupationTask().execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class GetOccupationTask extends AsyncTask<Integer, Void, Occupation> {

        @Override
        protected Occupation doInBackground(Integer... integers) {
            if (integers != null && integers.length > 0) {
                return database.occupationDAO().getOccupationById(integers[0]);
            }
            return null;
        }
    }

    public void DeleteAllOccupation() {
        new DeleteAllOccupationTask().execute();
    }

    public static class DeleteAllOccupationTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            database.occupationDAO().deleteAllOccupation();
            return null;
        }
    }

    public void InsertOccupation(Occupation occupation) {
        new InsertOccupationTask().execute(occupation);
    }

    public static class InsertOccupationTask extends AsyncTask<Occupation, Void, Void> {

        @Override
        protected Void doInBackground(Occupation... occupations) {
            if (occupations != null && occupations.length > 0) {
                database.occupationDAO().insertOccupation(occupations[0]);
            }
            return null;
        }
    }
}
