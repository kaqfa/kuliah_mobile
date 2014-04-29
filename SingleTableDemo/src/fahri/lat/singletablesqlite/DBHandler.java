package fahri.lat.singletablesqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbMhs.db";
    private static final String TABLE_MHS = "mahasiswa";
    
    SQLiteDatabase db;

	public DBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_table = "Create table "+TABLE_MHS+" (id integer primary key,"
								+ "nim text, nama text, email text, phone text, ipk number)";
		db.execSQL(create_table);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists mahasiswa");
		onCreate(db);
	}
	
	public void insertMhs(Mahasiswa mhs){
		db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("nim", mhs.get_nim());
		cv.put("nama", mhs.get_nama());
		cv.put("email", mhs.get_email());
		cv.put("phone", mhs.get_phone());
		cv.put("ipk", mhs.get_ipk());
		
		db.insert(TABLE_MHS, null, cv);
		db.close();
	}
	
	public Mahasiswa getMhs(int id){
		db = this.getReadableDatabase();
		
		Cursor cur = db.query(TABLE_MHS, new String[] {String.valueOf(id)}, 
											"id = ?", null, null, null, null);
		if(cur != null){
			cur.moveToFirst();
		}
		
		Mahasiswa mhs = new Mahasiswa(cur.getInt(0), cur.getString(1), cur.getString(2), 
									cur.getString(3), cur.getString(4), cur.getDouble(5));
		return mhs;
	}
	
	public List<Mahasiswa> getAllMhs(){
		List<Mahasiswa> mhss = new ArrayList<Mahasiswa>();
		
		String query = "select * from "+TABLE_MHS;
		db = this.getWritableDatabase();
		Cursor cur = db.rawQuery(query, null);
		
		if(cur.moveToFirst()){
			do{
				Mahasiswa mhs = new Mahasiswa(cur.getInt(0), cur.getString(1), cur.getString(2), 
									cur.getString(3), cur.getString(4), cur.getDouble(5));
				
				mhss.add(mhs);
			}while(cur.moveToNext());
		}
		
		return mhss;
	}
	
	public void updateMhs (Mahasiswa mhs){
		db = this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put("nim", mhs.get_nim());
		cv.put("nama", mhs.get_nama());
		cv.put("email", mhs.get_email());
		cv.put("phone", mhs.get_phone());
		cv.put("ipk", mhs.get_ipk());
		
		db.update(TABLE_MHS, cv, "id = ?", new String[]{String.valueOf(mhs.get_id())});
	}
	
	public void delMhs(Mahasiswa mhs){
		
	}

}
