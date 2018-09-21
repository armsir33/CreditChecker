package cn.credit.checker.CreditChecker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AppUser {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Override
    public String toString() {
        return String.format(
                "AppUser[id=%d, name='%s']",
                id, name);
    }
}
