package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements java.io.Serializable {

	private Integer IdUser;
	private String roleName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date dateCreation;

	public User() {

	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="iduser")
	public Integer getIdUser() {
		return IdUser;
	}

	public void setIdUser(Integer idUser) {
		IdUser = idUser;
	}
	@Column(name="roleName")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Column(name="firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="DateCreation")
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
 
}
