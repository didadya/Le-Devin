package com.examen.ledevin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.TextView;

public class AsyncDisplayTask extends AsyncTask<Void,Stats,Void> {
    Context ctx;
    TextView tvscore_recent , tvmax_score,tvmin_score,tvnb_won,tvnb_lose;

    public AsyncDisplayTask(Context ctx, TextView tvscore_recent, TextView tvmax_score, TextView tvmin_score, TextView tvnb_won, TextView tvnb_lose) {
        this.ctx = ctx;
        this.tvscore_recent = tvscore_recent;
        this.tvmax_score = tvmax_score;
        this.tvmin_score = tvmin_score;
        this.tvnb_won = tvnb_won;
        this.tvnb_lose = tvnb_lose;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Stats... stats) {

        tvscore_recent.setText(tvscore_recent.getText().toString()+": "+stats[0].getScore_recent());
        tvmax_score.setText(tvmax_score.getText().toString()+": "+stats[0].getScore_max());
        tvmin_score.setText( tvmin_score.getText().toString()+": "+stats[0].getScore_min());
        tvnb_lose.setText(tvnb_lose.getText().toString()+": "+stats[0].getGames_lost());
        tvnb_won.setText(tvnb_won.getText().toString()+": "+stats[0].getGames_won());


    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        BdOperations bddevin = new BdOperations(ctx);
      Stats stats=  bddevin.getAllData();
      publishProgress(stats);


return null;
    }


}
