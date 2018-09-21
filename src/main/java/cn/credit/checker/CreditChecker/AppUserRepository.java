package cn.credit.checker.CreditChecker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.credit.checker.CreditChecker.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByName(String name);
}
