package test.tasklist.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import test.tasklist.domen.EntityPr;

public interface Rep extends JpaRepository<EntityPr, Long> {
}