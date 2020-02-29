package es.api.atw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "user_entity")
public class UserEntity {

	@Id
	@Column(name = "USR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "USR_PWD")
	private String password;

	@Column(name = "USR_NCK", unique = true)
	private String nickname;

	@Column(name = "USR_NAM")
	private String name;

	@Column(name = "USR_BTH")
	private int birthYear;

	@Override
	public String toString() {
		return "{'id': " + this.id + ", 'password': " + this.password + ", 'nickname': " + this.nickname + ", 'name': "
				+ this.name + ", 'birthYear': " + this.birthYear + "}";
	}

}
