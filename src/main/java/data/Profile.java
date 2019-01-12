package data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Profile {
    @NotBlank(message = "Логин не может быть пустым или состоять из пробелов")
    @Length(min = 3,max = 10,  message = "Размер логина не должен быть менее трёх символов и не более 10")
    String login;

    @NotBlank(message = "Логин не может быть пустым или состоять из пробелов")
    @Length(min = 3,max = 10, message = "Размер имени не должен быть менее трёх символов и не более 10")
    String name;

    @NotBlank(message = "Параль не может быть пустым или состоять из пробелов")
    @Length(min = 3,max = 10, message = "Размер пароля не должен быть менее трёх символов и не более 10")
    String password;

    @Email(message = "неверный формат емейла")
    String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile(String login, String name, String password, String email) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Profile() {
    }
}
