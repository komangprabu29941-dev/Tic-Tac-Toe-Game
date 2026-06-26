import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;

    public StatisticsFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();

        setTitle("Statistik - " + player.getUsername());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        JLabel lblTitle = new JLabel("My Statistics", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        JLabel lblName = new JLabel("Player: " + player.getUsername(), SwingConstants.CENTER);
        gbc.gridy = 1;
        panel.add(lblName, gbc);

        gbc.gridwidth = 1;
        addRow(panel, gbc, 2, "Win:", String.valueOf(player.getWins()));
        addRow(panel, gbc, 3, "Lose:", String.valueOf(player.getLosses()));
        addRow(panel, gbc, 4, "Draw:", String.valueOf(player.getDraws()));
        addRow(panel, gbc, 5, "Total Score:", String.valueOf(player.getScore()));

        JButton btnClose = new JButton("Tutup");
        gbc.gridy = 6; gbc.gridwidth = 2;
        panel.add(btnClose, gbc);
        btnClose.addActionListener(e -> dispose());

        add(panel);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, String label, String value) {
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(value), gbc);
    }
}