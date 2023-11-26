package fr.isen.kaddouri.droidburger.ui;

public class BurgerItem {
    private String mBurgerName;
    private int mBurgerImage;

    public BurgerItem(String burgername, int burgerimage){
        mBurgerName = burgername;
        mBurgerImage = burgerimage;
    }

    public String getBurgerName(){
        return mBurgerName;
    }

    public int getBurgerImage(){
        return mBurgerImage;
    }
}
