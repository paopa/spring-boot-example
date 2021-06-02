package per.pao.practice.dao;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.isNull;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDo {

    private Integer id;
    private String username;
    private String password;

    public UserDo(String username, String password) {
        this(null, username, password);
    }

    public interface UserRepository extends IRepository<Integer, UserDo> {
        UserDo findByUserName(String name);
    }
}

@Repository
class UserRepositoryImpl implements UserDo.UserRepository {

    private final Map<Integer, Map.Entry<String, UserDo>> table = new ConcurrentHashMap<>();
    private final AtomicInteger trigger = new AtomicInteger(0);

    {
        save(new UserDo("test", "123"));
        save(new UserDo("test2", "123"));
        save(new UserDo("test3", "123"));
    }

    @Override
    public UserDo save(UserDo user) {
        user.setId(trigger.getAndIncrement());
        table.put(user.getId(), Map.entry(user.getUsername(), user));
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        return !isNull(table.remove(id));
    }

    @Override
    public UserDo findById(Integer id) {
        return table.get(id).getValue();
    }

    @Override
    public UserDo findByUserName(String name) {
        return table.values().stream()
                .filter(user -> user.getKey().equals(name))
                .findFirst().get().getValue();
    }
}


