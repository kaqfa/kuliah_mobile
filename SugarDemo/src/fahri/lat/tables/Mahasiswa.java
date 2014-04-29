package fahri.lat.tables;

import android.content.Context;

import com.orm.SugarRecord;

public class Mahasiswa extends SugarRecord<Mahasiswa> {
	
	public String nim;
	public String nama;
	public String email;
	public String phone;
	public double ipk;

	public Mahasiswa(Context arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public Mahasiswa(Context ctx, String nim, String nama, String email, String phone, double ipk){
		super(ctx);
		
		this.nim = nim;
		this.nama = nama;
		this.email = email;
		this.phone = phone;
		this.ipk = ipk;
	}
	
}
