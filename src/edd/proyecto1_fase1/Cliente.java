
package edd.proyecto1_fase1;

public class Cliente {

    String id, name, img_c, img_bw;

    public Cliente(String id, String name, String img_c, String img_bw) {
        this.id = id;
        this.name = name;
        this.img_c = img_c;
        this.img_bw = img_bw;
    }

    
    
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg_c(String img_c) {
        this.img_c = img_c;
    }

    public void setImg_bw(String img_bw) {
        this.img_bw = img_bw;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg_c() {
        return img_c;
    }

    public String getImg_bw() {
        return img_bw;
    }
    
    

    
}
