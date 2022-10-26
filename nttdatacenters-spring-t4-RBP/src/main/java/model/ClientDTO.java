package model;


public class ClientDTO {
	
	private Integer id;
	private String name;
	private String surname;
	private String dni;
	private String dateOfBirth;
	
	
	
	//BUILDER
	public ClientDTO(String name, String surname, String dni, String dateOfBirth) {
		super();
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.dateOfBirth = dateOfBirth;
	}

	public ClientDTO() {}

	
	
	//GET AND SET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", name=" + name + ", surname=" + surname + ", dni=" + dni + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

}
