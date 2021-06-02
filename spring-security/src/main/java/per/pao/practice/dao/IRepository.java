package per.pao.practice.dao;

public interface IRepository<K,T> {
    T save(T user);

    boolean delete(K id);

    T findById(K id);
}
