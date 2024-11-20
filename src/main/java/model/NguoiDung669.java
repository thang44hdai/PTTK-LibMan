package model;

public class NguoiDung669 {
    private int id;
    private String tk;
    private String mk;
    private String ten;
    private int chucvu;

    public NguoiDung669() {}

    public NguoiDung669(int id, String tk, String mk, String ten, int chucvu) {
        this.id = id;
        this.tk = tk;
        this.mk = mk;
        this.ten = ten;
        this.chucvu = chucvu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getChucvu() {
        return chucvu;
    }

    public void setChucvu(int chucvu) {
        this.chucvu = chucvu;
    }
}
