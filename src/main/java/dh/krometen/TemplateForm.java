package dh.krometen;

import javax.persistence.*;

@Entity
public class TemplateForm {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public int id;

    String name;
    int x;
    int y;
    double hash;
    String humanName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getHash() {
        return hash;
    }

    public void setHash(double hash) {
        this.hash = hash;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public TemplateForm(String name, int x, int y, int id, double hash, String humanName) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.id = id;
        this.hash = hash;
        this.humanName = humanName;
    }

    public TemplateForm() {
    }
}