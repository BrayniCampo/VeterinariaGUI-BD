package vo;

public class MascotaVo {
	private Long idMascota;
	private String nombre;
	private String raza;
	private String colorMascota;
	private String idDueno;
	private String sexo;
	
	public MascotaVo() {
	}
	
	

	public MascotaVo(Long idMascota, String nombre, String raza, String colorMascota, String idDueno, String sexo) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.raza = raza;
		this.colorMascota = colorMascota;
		this.idDueno = idDueno;
		this.sexo = sexo;
	}



	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColorMascota() {
		return colorMascota;
	}

	public void setColorMascota(String colorMascota) {
		this.colorMascota = colorMascota;
	}

	public String getIdDueno() {
		return idDueno;
	}

	public void setIdDueno(String idDueno) {
		this.idDueno = idDueno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	@Override
	public String toString() {
		return "MascotaVo [idMascota=" + idMascota + ", nombre=" + nombre + ", raza=" + raza + ", colorMascota="
				+ colorMascota + ", idDueno=" + idDueno + ", sexo=" + sexo + "]";
	}
	
	
	
}
