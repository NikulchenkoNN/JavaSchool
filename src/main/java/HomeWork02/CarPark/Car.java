package HomeWork02.CarPark;

public class Car {
    private String type;
    private String model;

    public Car(String model, String type) {
        this.type = type;
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
