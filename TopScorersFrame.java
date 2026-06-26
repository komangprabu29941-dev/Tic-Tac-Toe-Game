import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TopScorersFrame extends JFrame {
    private JTable table;
    private PlayerService playerService;

    public TopScorersFrame() {
        playerService = new PlayerService();
        
        setTitle("Top 5 Scorer");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitle = new JLabel("Top 5 Scorer", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        String[] columns = {"Rank", "Username", "Win", "Lose", "Draw", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int col) { return false; }
        };

        ArrayList<Player> topPlayers = playerService.getTopFiveScorers();
        int rank = 1;
        for (Player p : topPlayers) {  // ← ada 'p'
        model.addRow(new Object[]{
            rank++,           
            p.getUsername(),  
            p.getWins(),      
            p.getLosses(),    
            p.getDraws(),     
            p.getScore()      
            });
        }

        table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.setRowHeight(28);

        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnClose = new JButton("Tutup");
        btnClose.addActionListener(e -> dispose());
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(btnClose);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}