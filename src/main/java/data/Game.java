package data;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Column(name = "a1")
    private  String   a1= "";

    @Column(name = "a2")
    private  String   a2= "";

    @Column(name = "a3")
    private  String   a3= "";

    @Column(name = "b1")
    private  String   b1= "";

    @Column(name = "b2")
    private  String   b2= "";

    @Column(name = "b3")
    private  String   b3= "";

    @Column(name = "c1")
    private  String   c1= "";

    @Column(name = "c2")
    private  String   c2= "";

    @Column(name = "c3")
    private  String   c3= "";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private  Integer objrct_id;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public Integer getObjrct_id() {
        return objrct_id;
    }

    public void setObjrct_id(Integer objrct_id) {
        this.objrct_id = objrct_id;
    }

    public Game(String a1, String a2, String a3, String b1, String b2, String b3, String c1, String c2, String c3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public Game() {
    }
}
