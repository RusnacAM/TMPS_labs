package Lab2.AbstractFactory.Styles;

import Lab2.AbstractFactory.Styles.Style;

public class Victorian implements Style {
    @Override
    public void getStyle() {
        System.out.println("Victorian style.");
    }
}
