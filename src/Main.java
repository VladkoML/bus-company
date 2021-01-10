import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Автобусна компанія");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Main main = new Main();

        System.out.println("Hello World!!!");

        main.setVisible(true);

    }

}
