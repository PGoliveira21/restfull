package demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public List<Telefone> getTelefones() {
	return telefones;
}

public void setTelefones(List<Telefone> telefones) {
	this.telefones = telefones;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String senha;

private String login;

private String nome;

@OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL)
private List<Telefone> telefones = new ArrayList<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Usuario other = (Usuario) obj;
	return Objects.equals(id, other.id);
}




}
