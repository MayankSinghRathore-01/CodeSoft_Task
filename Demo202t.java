import java.awt.*;
import java.awt.event.*;

class FDemo extends Frame implements ActionListener {
    Button b1[] = new Button[9];
    boolean gameOver = false;

    FDemo() {
        setTitle("TIC TAC TOE");
        Font f = new Font("Broadway", Font.BOLD, 25);
        setFont(f);
        setLayout(null);

        int i, j, k = 0;
        int x = 100;
        int y = 100;
        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++) {
                b1[k] = new Button();
                b1[k].setSize(100, 100);
                b1[k].setLocation(x, y);
                add(b1[k]);
                b1[k].addActionListener(this);
                x += 100;
                k++;
            }
            y += 100;
            x = 100;
        }

    }

    int c = 1;

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            Button b = (Button) e.getSource();
            if (b.getLabel().isEmpty()) {
                if (c % 2 == 1) {
                    b.setLabel("0");
                } else {
                    b.setLabel("x");
                }
                c++;
                checkWin();
                b.removeActionListener(this);
            }
        }
    }

    void checkWin() {
       
        for (int i = 0; i < 9; i += 3) {
            if (!b1[i].getLabel().isEmpty() 
				&& b1[i].getLabel().equals(b1[i + 1].getLabel()) &&
                b1[i + 1].getLabel().equals(b1[i + 2].getLabel())) {
                gameOver = true;
                displayWinner(b1[i].getLabel());
                return;
            }
        }

        
        for (int i = 0; i < 3; i++) {
            if (!b1[i].getLabel().isEmpty() &&
			b1[i].getLabel().equals(b1[i + 3].getLabel()) &&
                b1[i + 3].getLabel().equals(b1[i + 6].getLabel())) {
                gameOver = true;
                displayWinner(b1[i].getLabel());
                return;
            }
        }

        
        if ((!b1[4].getLabel().isEmpty() && b1[0].getLabel().equals(b1[4].getLabel())
			&& b1[4].getLabel().equals(b1[8].getLabel())) ||
            (!b1[4].getLabel().isEmpty() && b1[2].getLabel().equals(b1[4].getLabel())
			&& b1[4].getLabel().equals(b1[6].getLabel()))) {
            gameOver = true;
            displayWinner(b1[4].getLabel());
        }
    }

    void displayWinner(String winner) {
        if (winner.equals("0")) {
            System.out.println("Player 1 (0) wins!");
        } else {
            System.out.println("Player 2 (X) wins!");
        }
    }
}

class Demo202 {
    public static void main(String ar[]) {
        FDemo f = new FDemo();
        f.setVisible(true);
        f.setSize(800, 500);
        f.setLocation(200, 200);
    }
}