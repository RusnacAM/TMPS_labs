package Lab2.AbstractFactory.Styles;

import Lab2.AbstractFactory.Styles.Style;

public class Modern implements Style {
    @Override
    public void getStyle() {
        System.out.println("Modern style.");
    }
}
