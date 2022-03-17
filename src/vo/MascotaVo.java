package vo;

public class MascotaVo {
	private Long idMascota;
	private String nombre;
	private String raza;
	private String colorMascota;
	private String sexo;
	private Long idDueno;
	
	
	
	public MascotaVo(Long idMascota, String nombre, String raza, String colorMascota, String sexo, Long idDueno) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.raza = raza;
		this.colorMascota = colorMascota;
		this.sexo = sexo;
		this.idDueno = idDueno;
	}

	public MascotaVo() {
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Long getIdDueno() {
		return idDueno;
	}

	public void setIdDueno(Long idDueno) {
		this.idDueno = idDueno;
	}

	@Override
	public String toString() {
		return "MascotaVo [idMascota=" + idMascota + ", nombre=" + nombre + ", raza=" + raza + ", colorMascota="
				+ colorMascota + ", sexo=" + sexo + ", idDueno=" + idDueno + "]";
	}
	
	
}
