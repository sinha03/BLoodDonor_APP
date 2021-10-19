package myapps.myapplication.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by comsol on 13-Dec-17.
 */
public class DonnerHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "DonnerManager";

    // Contacts table name
    private static final String TABLE_DONNERS = "Donner";

    // Contacts Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_name = "name";
    public static final String KEY_gender = "gender";
    public static final String KEY_location = "location";
    public static final String KEY_blood_group = "blood_group";
    public static final String KEY_age = "age";
    public static final String KEY_phone = "phone";



    public DonnerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DOONERS_TABLE = "CREATE TABLE " + TABLE_DONNERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_name + " TEXT,"
                + KEY_gender + " TEXT,"+ KEY_location + " TEXT,"+ KEY_age + " TEXT,"+ KEY_blood_group + " TEXT,"
                + KEY_phone + " TEXT" +" )";
        db.execSQL(CREATE_DOONERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DONNERS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    public boolean addDonners(String name, String gender, String location, String age, String blood_group,String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_name, name);
        values.put(KEY_gender,gender);
        values.put(KEY_location,location);
        values.put(KEY_age, age);
        values.put(KEY_blood_group,blood_group);
        values.put(KEY_phone, phone);
        // Inserting Row
        // db.insert(TABLE_DONNERS, null, values);
        db.insert(TABLE_DONNERS, null, values);
        //  db.close();
        return true;// Closing database connection
    }

    public Cursor  getDonner_list(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =  db.rawQuery("SELECT * FROM " + TABLE_DONNERS + " WHERE " +
                KEY_ID + "=?", new String[]{Integer.toString(id)});

        return cursor;
    }


    // Getting All Contacts
    public Cursor getAllDonners() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "SELECT * FROM " + TABLE_DONNERS, null );

        return cursor;
    }
    // Updating single contact
    public boolean updatedonner(Integer id, String name, String gender, String location, String age, String blood_group,String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_name, name);
        values.put(KEY_gender, gender);
        values.put(KEY_location,location);
        values.put(KEY_age, age);
        values.put(KEY_blood_group, blood_group);
        values.put(KEY_phone, phone);

        // updating row
        db.update(TABLE_DONNERS, values, KEY_ID + " = ?",new String[]  { Integer.toString(id) });
        return true;
    }

    // Deleting single contact
    public int deletedonner(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_DONNERS,
                KEY_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }


    // Getting contacts Count
    public int getdonnerCount() {
        String countQuery = "SELECT  * FROM " + TABLE_DONNERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }





}
