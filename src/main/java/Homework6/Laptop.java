package Homework6;

public class Laptop {
    private String brand;
    private String model;
    private double screenSize;
    private String color;
    private int ram;
    private int hddSize;
    private String os;
    private int id;

    public Laptop(String brand,
                  String model,
                  double screenSize,
                  String color,
                  int ram,
                  int hddSize,
                  String os,
                  int id) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.color = color;
        this.ram = ram;
        this.hddSize = hddSize;
        this.os = os;
        this.id = id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("Ноутбук: ");
        sb.append(this.brand);
        sb.append(" ");
        sb.append(this.model);
        sb.append(" ");
        sb.append(this.screenSize);
        sb.append(" ");
        sb.append(this.color);
        sb.append(" ");
        sb.append("ОЗУ:");
        sb.append(this.ram);
        sb.append(" ");
        sb.append("ЖД:");
        sb.append(this.hddSize);
        sb.append(" ");
        sb.append(this.os);
        sb.append(" ");
        sb.append(this.id);

        return (sb.toString());
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getColor() {
        return color;
    }

    public int getRam() {
        return ram;
    }

    public int getHddSize() {
        return hddSize;
    }

    public String getOs() {
        return os;
    }

    public int getId() {
        return id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
