package data.dao;

import data.Game;


public interface GameDAOInterface {
    int firstSave (Game game);
    void saveGameInTable (Game game);
    Game getById(Integer id);
}
