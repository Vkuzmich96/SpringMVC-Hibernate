package controller;

import data.Game;
import data.dao.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
//todo Написать этот класс с большой буквы
@Controller
@RequestMapping("/controller")
public class Сontroller {

    private int SIZE =3;
    private String[] X_O = {"x", "0"};
    private String WORK_PAGE = "page1";
    private String WIN_PAGE = "winPage";
    private String LOSE_PAGE = "winPage";

    @Autowired
    GameDAO gameDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String parmGeter(Model model, HttpSession session) {
        model.addAttribute("gameKey", gameDAO.getById((Integer)session.getAttribute("gameKey")));
        return WORK_PAGE;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String parmSeter(@ModelAttribute("gameKey") Game game, HttpSession session) {
        return goGame(game, session);
    }

    //заходим поочереди для х и 0 в медод для проверки собралась ли строка одинаковых символов
    private String goGame(Game game, HttpSession session) {
        Field[] gameFields = fieldConverter(game);

        if (isWin(gameFields, X_O[0], game)) return WIN_PAGE;

        if (isWin(gameFields, X_O[1], game)) return LOSE_PAGE;

        gameDAO.saveGameInTable((Game)session.getAttribute("gameKey"));

        return "redirect:/controller";
    }

    //вытаскиваем филды из класса объекта игра
    private Field[] fieldConverter(Game game) {
        return game.getClass().getDeclaredFields();
    }

    //todo добавить в алгоритм выход из проверки, если первый элимент в строке не равен testParm
    private boolean isWin(Field[] fields, String testParm, Game game) {

        // проверка по горизонтали и вертикали и диагонали
        int diagonalOneWin = 0;
        int diagonalTwoWin = 0;
        for (int i = 0; i < SIZE; i++) {

            if (openAndCast(fields, i*SIZE+i, game).equals(testParm)) {
                if ((diagonalOneWin ++) == SIZE) return true;
            }
            if (openAndCast(fields, (SIZE-i)*(SIZE-1), game).equals(testParm)) {
                if ((diagonalTwoWin++) == SIZE) return true;
            }

            int horizontWin = 0;
            int verticalWin = 0;

            for (int j = 0; j < SIZE; j++) {
                if (openAndCast(fields, SIZE*i+j, game).equals(testParm)) {
                    if ((horizontWin++)==SIZE) return true;
                }
                if (openAndCast(fields, SIZE*j+i, game).equals(testParm)) {
                    if ((verticalWin++)==SIZE) return true;
                }
            }
        }
        return false;
    }

    // открываем доступ к полям объекта филд, приводим его значение к строке
    private String openAndCast(Field[] fields, int i, Game game) {
        try {
            fields[i].setAccessible(true);
            return (String) fields[i].get(game);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }
 }
