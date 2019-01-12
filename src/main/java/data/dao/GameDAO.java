package data.dao;

import data.Game;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class GameDAO implements GameDAOInterface{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int firstSave(Game game) {
        sessionFactory.getCurrentSession().save(game);
        return game.getObjrct_id();
    }

    @Override
    public void saveGameInTable(Game game) {
        sessionFactory.getCurrentSession().saveOrUpdate(game);
    }

    @Override
    public Game getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Game.class, id);
    }
}
