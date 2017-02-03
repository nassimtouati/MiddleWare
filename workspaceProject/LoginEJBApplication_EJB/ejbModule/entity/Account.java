package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account")
@NamedQueries({
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a"),
@NamedQuery(name="Account.findById", query="SELECT a FROM Account a  where a.id=:id"),
@NamedQuery(name="Account.checkLogin", query="SELECT a FROM Account a where a.usename=:usename and a.password=:password"),
@NamedQuery(name="Account.findByPassword", query="SELECT a FROM Account a where a.password=:password"),
@NamedQuery(name="Account.findByEmail", query="SELECT a FROM Account a where a.email=:email"),
@NamedQuery(name="Account.findByTel", query="SELECT a FROM Account a where a.tel=:tel"),
})
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="tel")
	private String tel;
	@Column(name="username")
	private String usename;

	
	public Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsename() {
		return this.usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((usename == null) ? 0 : usename.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (usename == null) {
			if (other.usename != null)
				return false;
		} else if (!usename.equals(other.usename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + "]";
	}
	
	

}