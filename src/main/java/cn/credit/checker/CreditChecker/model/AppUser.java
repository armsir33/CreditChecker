package cn.credit.checker.CreditChecker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppUser {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
    public String toString() {
        return String.format(
                "AppUser[id=%d, name='%s']",
                id, name);
    }
}
