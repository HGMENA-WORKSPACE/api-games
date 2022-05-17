package com.api.games.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String img;

    // Si la columna se llama igual que el atributo, no es necesario el @JoinColumn
    // @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne()
    private Distributor distributor;

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return
     */
    public Distributor getDistributor() {
        return distributor;
    }

    /**
     * @param distributor
     */
    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    /**
     * @param name
     * @param description
     * @param img
     */
    public Game setGame(String name, String description, String img) {
        this.name = name;
        this.description = description;
        this.img = img;
        return this;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", distributor=" + distributor +
                '}';
    }

    /**
     *
     */
    public boolean isEmpty() {
        return name == null && description == null && img == null && distributor == null;
    }

}
