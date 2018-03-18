package unapec.arquitectura.opensource.di_visor;

/**
 * Created by Daniel on 17/03/2018.
 */

public class Price {
    private double price;
    private String bank;
    private int imageResource;

    public Price(double price, String bank, int image) {
        this.price = price;
        this.bank = bank;
        this.imageResource = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
