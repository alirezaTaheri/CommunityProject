
package alireza.communityproject.app;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import alireza.communityproject.CultureProducts.Article;


/**
 * Created by alireza321 on 14/02/2018.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String TAG = DatabaseHandler.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;

    static SQLiteDatabase db;

    private static final String DATABASE_NAME = "TempDatabase";

    private static final String TABLE_ARTICLES = "TempArticlesTable";

    private static final String KEY_ARTICLE_ID = "articleId";
    private static final String KEY_ARTICLE_NAME = "articleName";
    private static final String KEY_ARTICLE_TITLE = "articleTitle";

    private static DatabaseHandler sInstance;
    public Context context;

    public static synchronized DatabaseHandler getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DatabaseHandler(context.getApplicationContext());

        }
        return sInstance;
    }

    Cursor cursor;
    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_ARTICLES + "("+
                KEY_ARTICLE_ID + " PRIMARY KEY," +
                KEY_ARTICLE_NAME + " TEXT,"+
                KEY_ARTICLE_TITLE + " TEXT"+
                ")";

        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);
        onCreate(db);
    }
    public void onLogOut(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ARTICLES);
        Log.e(TAG,"All Database Tables Were Dropped");
    }
    public void addArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ARTICLE_ID,article.getId());
        values.put(KEY_ARTICLE_NAME, article.getName());
        values.put(KEY_ARTICLE_TITLE,article.getTitle());

        db.insert(TABLE_ARTICLES, null, values);
        Log.e(TAG,"Article created: " + article.toString());

//        db.close();
    }
    public ArrayList<Article> getAllArticles() {
        ArrayList<Article> articles = new ArrayList<Article>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ARTICLES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Article article = new Article();
                article.setId(cursor.getString(cursor.getColumnIndex(KEY_ARTICLE_ID)));
                article.setName(cursor.getString(cursor.getColumnIndex(KEY_ARTICLE_NAME)));
                article.setName(cursor.getString(cursor.getColumnIndex(KEY_ARTICLE_TITLE)));

                articles.add(article);
            } while (cursor.moveToNext());
//            cursor.close();
//            db.close();
        }
        // return thing list
        return articles;
    }
    public Article getArticle(String articleId){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ARTICLES + " WHERE "
                + KEY_ARTICLE_ID+ " = " + "\'"+articleId+"\'";


        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();
        Article article = null;

        if (cursor != null && cursor.getCount() > 0){
            article = new Article();
            article.setId(cursor.getString(cursor.getColumnIndex(KEY_ARTICLE_ID)));
            article.setName(cursor.getString(cursor.getColumnIndex(KEY_ARTICLE_NAME)));
            article.setTitle(cursor.getString(cursor.getColumnIndex(KEY_ARTICLE_TITLE)));
        }
//        db.close();
//        if (cursor != null)
//        cursor.close();
        return article;
    }
    public void deleteArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ARTICLES, KEY_ARTICLE_ID + " = ?",
                new String[] { String.valueOf(article.getName()) });
//        db.close();
    }
    public void deleteAllArticles(){
        SQLiteDatabase db = this.getReadableDatabase();
//        db.execSQL("delete from "+ TABLE_ARTICLES);
        db.delete(TABLE_ARTICLES, null, null);
    }
    public void updateArticle(Article article){
        Log.e(TAG, "Updating Article..." + article.toString());
            ContentValues values = new ContentValues();
            db = DatabaseHandler.this.getWritableDatabase();
            values.put(KEY_ARTICLE_ID, article.getId());
            values.put(KEY_ARTICLE_NAME, article.getName());
            values.put(KEY_ARTICLE_TITLE, article.getTitle());

            db.update(TABLE_ARTICLES, values, KEY_ARTICLE_ID + " = ?",
                    new String[]{String.valueOf(article.getId())});
    }
}
