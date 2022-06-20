package br.com.entra21.modelo2022.principal.modelobase;

public class Pessoa {
	private String name;
	private byte age;
	private String sex;
	private String cpf;
	private String nameMother;
	private String nameFather;
	private String email;
	private String telephone;
	private String streetAddress;
	private String numberAddress;
	private String zipCode;
	private String city;
	private String state;
	private String country;

	public Pessoa() {
	}

	public Pessoa(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.cpf = cpf;
		this.nameMother = nameMother;
		this.nameFather = nameFather;
		this.email = email;
		this.telephone = telephone;
		this.streetAddress = streetAddress;
		this.numberAddress = numberAddress;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNameMother() {
		return nameMother;
	}

	public void setNameMother(String nameMother) {
		this.nameMother = nameMother;
	}

	public String getNameFather() {
		return nameFather;
	}

	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Pessoa(String nome, byte idade, String cpf) {
		super();
		this.name = nome;
		this.age = idade;
		this.cpf = cpf;
	}

}
