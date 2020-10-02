package per.pao.example.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import per.pao.example.entity.AccountRoleDo;

@RepositoryRestResource
public interface AccountRoleRepository extends JpaRepository<AccountRoleDo, Long> {
}
