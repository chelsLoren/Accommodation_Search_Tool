package uk.co.lincoln.c14541565students.accommodationsearchtool;

/**
 * Created by Chelsey on 28/03/2016.
 */
public class Accommodation_Info {

    private String name;
    private int img;

    public Accommodation_Info(String name, int img){
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
