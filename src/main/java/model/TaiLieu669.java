package model;

public class TaiLieu669 {
    private int id;
    private String ten;
    private String tacgia;
    private int namXB;

    public TaiLieu669() {}

    public TaiLieu669(int id, String ten, String tacgia, int namXB) {
        this.id = id;
        this.ten = ten;
        this.tacgia = tacgia;
        this.namXB = namXB;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    // Phương thức tiện ích để hiển thị thông tin
    @Override
    public String toString() {
        return "TaiLieu669{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", namXB=" + namXB +
                '}';
    }
}
