package com.examen.ledevin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;

public class BdOperations extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "devin.db";
    public static final String TABLE_NAME = "stats_table";
    public static final String id_player = "id_player";
    public static final String score_recent = "score_recent";
    public static final String score_min = "score_min";
    public static final String score_max = "score_max";
    public static final String games_won = "games_won";
    public static final String games_lost = "games_lost";
    private SQLiteDatabase dbread;

    public BdOperations(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE IF NOT EXISTS " +TABLE_NAME+" ( "+score_recent+" INTEGER , "+score_min+"  INTEGER , "+score_max+"  INTEGER , "+games_won+" INTEGER , "+games_lost+" INTEGER ) ");
        Log.i("bob", "dddddddd");
 // dbread = getReadableDatabase();
       // Cursor cursor = dbread.rawQuery(" select * from "+TABLE_NAME,null);
      //  ContentValues values = new ContentValues();
       // values.put(score_recent, 0);
       // values.put(score_min, 0);
       // values.put(score_max, 0);
       // values.put(games_won, 0);
       // values.put(games_lost, 0);
        //db.insert(TABLE_NAME, null, values);
       Reset(db);
        }


    // db.execSQL(" CREATE TABLE IF NOT EXISTS " +TABLE_NAME+"(" +id_player+ " INTEGER DEFAULT "+0+" PRIMARY KEY AUTOINCREMENT , "+score_recent+" INTEGER DEFAULT "+0+" , " +score_min+" INTEGER DEFAULT "+0+" , "+score_max+" INTEGER DEFAULT "+0+" , "+games_won+" INTEGER DEFAULT "+0+" , "+games_lost+" INTEGER DEFAULT "+0+" )");


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public void Reset(SQLiteDatabase db) {

        ContentValues values = new ContentValues();
        values.put(score_recent, 0);
        values.put(score_min, 0);
        values.put(score_max, 0);
        values.put(games_won, 0);
        values.put(games_lost, 0);


        db.insert(TABLE_NAME, null, values);


    }
    public Stats getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from "+TABLE_NAME,null);

        Log.i("bd", String.valueOf(cursor.moveToFirst()));
        if (cursor.moveToFirst()) {


            do {




                int RecentScore =cursor.getInt(cursor.getColumnIndex(score_recent));
                int MinScore=cursor.getInt(cursor.getColumnIndex(score_min));
                int MaxScore=cursor.getInt(cursor.getColumnIndex(score_max));
                int GamesWon=cursor.getInt(cursor.getColumnIndex(games_won));
              int GamesLost=cursor.getInt(cursor.getColumnIndex(games_lost));

              Stats stat = new Stats(RecentScore,MinScore,MaxScore,GamesWon,GamesLost);

              return stat;

            } while (cursor.moveToNext());

        }
      //  db.close();

  return new Stats(-6,3,4,5,6);  }
    public boolean updateData(boolean iswon,Stats stat){

              int score ;
        //update score and get score
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       // contentValues.put(score_recent,stat.getScore_recent()+1);
        if(iswon){ score= stat.getScore_recent()+3;
            contentValues.put(games_won,stat.getGames_won()+1);
        }

        else{ score= stat.getScore_recent()-1;
            contentValues.put(games_lost,stat.getGames_lost()+1);
        }

        contentValues.put(score_recent,score);
        if(score<=stat.getScore_min())
            contentValues.put(score_min,score);
            else if (score>=stat.getScore_max())
            contentValues.put(score_max,score);




       // db.update(TABLE_NAME, contentValues, score_recent+" = ? ",new String[] { "25" });
        db.update(TABLE_NAME, contentValues,null,null);

        return true;
        //compare between min and max
        //compare if iswon

    }
    //getscore
}
