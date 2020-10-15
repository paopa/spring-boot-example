package per.pao.example.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import per.pao.example.entity.SimpleDo;

@RepositoryRestResource
public interface SimpleRepository extends JpaRepository<SimpleDo, Long> {

    @Override
    @RestResource(exported = false)
    void delete(SimpleDo simpleDo);

}
