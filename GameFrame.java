import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;
    private boolean gameOver;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();
        this.gameOver = false;

        setTitle("Tic-Tac-Toe - " + player.getUsername() + " vs Komputer");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblStatus = new JLabel("Your turn!", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 14));
        mainPanel.add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        boardPanel.setBackground(Color.DARK_GRAY);
        buttons = new JButton[9];

        for (int i=0; i<9; i++) {
            final int index = i;
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Segoe UI", Font.BOLD, 36));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            boardPanel.add(buttons[i]);
        }
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());

        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(e -> resetGame());
        bottomPanel.add(btnNewGame);

        JButton btnBack = new JButton("Back to Menu");
        btnBack.addActionListener(e -> {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            GameFrame.this.dispose();
        });
        bottomPanel.add(btnBack);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private void handlePlayerMove(int index) {
        if (gameOver) return;

        boolean moved = gameLogic.makeMove(index, 'X');
        if (!moved) {
            JOptionPane.showMessageDialog(this, "The cell is already filled! Please select another.");
            return;
        }

        buttons[index].setText("X");
        buttons[index].setEnabled(false);

        if (gameLogic.checkWinner('X')) { finishGame("WIN"); return; }
        if (gameLogic.isDraw()) { finishGame("DRAW"); return; }

        lblStatus.setText("Computer's turn...");

        int compIndex = gameLogic.computerMove();
        if (compIndex != -1) {
            gameLogic.makeMove(compIndex, '0');
            buttons[compIndex].setText("0");
            buttons[compIndex].setEnabled(false);
        }

        if (gameLogic.checkWinner('0')) { finishGame("LOSE"); return; }
        if (gameLogic.isDraw()) { finishGame("DRAW"); return; }

        lblStatus.setText("Your turn!");
    }

    private void finishGame(String result) {
        gameOver = true;
        playerService.updateStatistics(currentPlayer, result);

        String pesan;
        if (result.equals("WIN")) pesan = "Congratulations, you WIN! (+10 poin)";
        else if (result.equals("LOSE")) pesan = "You LOSE!. Please try again!";
        else pesan = "DRAW! (+3 poin)";

        lblStatus.setText(pesan);
        for (JButton btn : buttons) btn.setEnabled(false);
        JOptionPane.showMessageDialog(this, pesan, "Game is over", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetGame() {
        gameLogic.resetBoard();
        gameOver = false;
        lblStatus.setText("Your turn!");
        for (JButton btn : buttons) {
            btn.setText("");
            btn.setEnabled(true);
        }
    }
}