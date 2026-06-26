import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private Player currentPlayer;
    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorers;
    private JButton btnExit;

    public MainMenuFrame(Player player) {
        this.currentPlayer = player;

        setTitle("Tic-Tac-Toe Main Menu");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        JLabel lblTitle = new JLabel("Main Menu", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        gbc.gridy = 0;
        panel.add(lblTitle, gbc);

        JLabel lblWelcome = new JLabel("Welcome, " + player.getUsername() + "!", SwingConstants.CENTER);
        gbc.gridy = 1;
        panel.add(lblWelcome, gbc);

        btnStartGame = new JButton("Start Game");
        btnStartGame.setBackground(new Color(34, 139, 34)); //hijau
        btnStartGame.setForeground(Color.WHITE);
        btnStartGame.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnStartGame.setFocusPainted(false);
        gbc.gridy = 2;
        panel.add(btnStartGame, gbc);

        btnStatistics = new JButton("My Statistics");
        btnStatistics.setBackground(new Color(70, 130, 180)); //biru
        btnStatistics.setForeground(Color.WHITE);
        btnStatistics.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnStatistics.setFocusPainted(false);
        gbc.gridy = 3;
        panel.add(btnStatistics, gbc);

        btnTopScorers = new JButton("Top 5 Scorers");
        btnTopScorers.setBackground(new Color(184, 134, 11)); //gold
        btnTopScorers.setForeground(Color.WHITE);
        btnTopScorers.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnTopScorers.setFocusPainted(false);
        gbc.gridy = 4;
        panel.add(btnTopScorers, gbc);

        btnExit = new JButton("Exit");
        btnExit.setBackground(new Color(178, 34, 34)); //merah
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnExit.setFocusPainted(false); 
        gbc.gridy = 5;
        panel.add(btnExit, gbc);

        add(panel);

        btnStartGame.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(currentPlayer);
            gameFrame.setVisible(true);
            MainMenuFrame.this.dispose();
        });

        btnStatistics.addActionListener(e -> {
            StatisticsFrame statsFrame = new StatisticsFrame(currentPlayer);
            statsFrame.setVisible(true);
        });

        btnTopScorers.addActionListener(e -> {
            TopScorersFrame topFrame = new TopScorersFrame();
            topFrame.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });
    }
}