package main.atividade.integradora.entity;

import java.util.UUID;

public class Bonus {

    private final String id = UUID.randomUUID().toString();
    private Double perc;
    private boolean usado;

    private Bonus() {}

    public Bonus(Double perc) {

        this.perc = perc;
    }

    public String getId() {
        return id;
    }

    public Double getPerc() {
        return perc;
    }

    public void setPerc(Double perc) {
        this.perc = perc;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "id='" + id + '\'' +
                ", perc=" + perc +
                ", usado=" + usado +
                '}';
    }
}
