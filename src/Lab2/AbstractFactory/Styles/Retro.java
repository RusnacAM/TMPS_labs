package Lab2.AbstractFactory.Styles;

import Lab2.AbstractFactory.Styles.Style;

public class Retro implements Style {
    @Override
    public void getStyle() {
        System.out.println("Retro style.");
    }
}
