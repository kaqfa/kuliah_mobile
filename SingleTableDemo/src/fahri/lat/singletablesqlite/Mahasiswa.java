package fahri.lat.singletablesqlite;

public class Mahasiswa {
	private int _id;
	private String _nim;
	private String _nama;
	private String _email;
	private String _phone;
	private double _ipk;
	
	public Mahasiswa(){}
	
	public Mahasiswa(int _id, String _nim, String _nama, String _email,
			String _phone, double _ipk) {
		super();
		this._id = _id;
		this._nim = _nim;
		this._nama = _nama;
		this._email = _email;
		this._phone = _phone;
		this._ipk = _ipk;
	}
	
	public Mahasiswa(String _nim, String _nama, String _email, String _phone,
			double _ipk) {
		super();
		this._nim = _nim;
		this._nama = _nama;
		this._email = _email;
		this._phone = _phone;
		this._ipk = _ipk;
	}

	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_nim() {
		return _nim;
	}
	public void set_nim(String _nim) {
		this._nim = _nim;
	}
	public String get_nama() {
		return _nama;
	}
	public void set_nama(String _nama) {
		this._nama = _nama;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}
	public String get_phone() {
		return _phone;
	}
	public void set_phone(String _phone) {
		this._phone = _phone;
	}
	public double get_ipk() {
		return _ipk;
	}
	public void set_ipk(double _ipk) {
		this._ipk = _ipk;
	}
	
	
}
