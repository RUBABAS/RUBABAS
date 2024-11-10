import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Form {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Form::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Магазин: Управление складом, продажами, клиентами и заказами");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Установка темного фона для всего окна
        frame.getContentPane().setBackground(Color.DARK_GRAY);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel warehousePanel = createWarehousePanel();
        JPanel salesPanel = createSalesPanel();
        JPanel customersPanel = createCustomersPanel();
        JPanel ordersPanel = createOrdersPanel();

        tabbedPane.addTab("Склад", warehousePanel);
        tabbedPane.addTab("Продажи", salesPanel);
        tabbedPane.addTab("Клиенты", customersPanel);
        tabbedPane.addTab("Заказы", ordersPanel);

        // Размещение логотипа с снежинками
        JLabel logoLabel = createLogoLabel("R:/Практика 10.11.2024/JX5JA0sFrGxxEFUwDlGEm8Ux0LWtfHxLiGXi2CqCR1l7asxtnPF_iU1oZAYwyBgMgQ4Emjla.jpg/"); // Укажите путь к вашему логотипу
        frame.add(logoLabel, BorderLayout.NORTH);
        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);

        Timer timer = new Timer(30, e -> frame.repaint());
        timer.start();
    }

    private static JLabel createLogoLabel(String path) {
        JLabel logoLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Загрузка логотипа
                try {
                    Image logo = ImageIO.read(new File(path));
                    logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Масштабирование логотипа
                    g.drawImage(logo, 0, 0, this);  // Отрисовка логотипа на панели
                } catch (IOException e) {
                    g.setColor(Color.WHITE);
                    g.drawString("Логотип не найден", 10, 20);
                }

                // Отрисовка снежинок на логотипе
                g.setColor(Color.WHITE);
                for (int i = 0; i < 50; i++) {
                    int x = new Random().nextInt(getWidth());
                    int y = new Random().nextInt(getHeight());
                    g.fillOval(x, y, 5, 5);
                }
            }
        };
        logoLabel.setPreferredSize(new Dimension(100, 100)); // Устанавливаем размер панели логотипа
        return logoLabel;
    }

    private static JPanel createWarehousePanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Тёмный фон
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JTextArea warehouseTextArea = new JTextArea();
        warehouseTextArea.setText("Информация о складе:\n- Товары в наличии\n- Остатки на складе");
        warehouseTextArea.setBackground(Color.DARK_GRAY);
        warehouseTextArea.setForeground(Color.WHITE);
        panel.add(new JScrollPane(warehouseTextArea), BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setBackground(Color.DARK_GRAY);
        buttonsPanel.add(new JButton("Добавить товар"));
        buttonsPanel.add(new JButton("Удалить товар"));
        buttonsPanel.add(new JButton("Обновить остатки"));

        panel.add(buttonsPanel, BorderLayout.SOUTH);
        return panel;
    }

    private static JPanel createSalesPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JTextArea salesTextArea = new JTextArea();
        salesTextArea.setText("Информация о продажах:\n- Проданные товары\n- Суммы продаж");
        salesTextArea.setBackground(Color.DARK_GRAY);
        salesTextArea.setForeground(Color.WHITE);
        panel.add(new JScrollPane(salesTextArea), BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setBackground(Color.DARK_GRAY);
        buttonsPanel.add(new JButton("Добавить продажу"));
        buttonsPanel.add(new JButton("Отчёт по продажам"));
        buttonsPanel.add(new JButton("Вернуть товар"));

        panel.add(buttonsPanel, BorderLayout.SOUTH);
        return panel;
    }

    private static JPanel createCustomersPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JTextArea customersTextArea = new JTextArea();
        customersTextArea.setText("Информация о клиентах:\n- Список клиентов\n- История покупок");
        customersTextArea.setBackground(Color.DARK_GRAY);
        customersTextArea.setForeground(Color.WHITE);
        panel.add(new JScrollPane(customersTextArea), BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setBackground(Color.DARK_GRAY);
        buttonsPanel.add(new JButton("Добавить клиента"));
        buttonsPanel.add(new JButton("Удалить клиента"));
        buttonsPanel.add(new JButton("Обновить данные"));

        panel.add(buttonsPanel, BorderLayout.SOUTH);
        return panel;
    }

    private static JPanel createOrdersPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JTextArea ordersTextArea = new JTextArea();
        ordersTextArea.setText("Информация о заказах:\n- Заказы в обработке\n- История заказов");
        ordersTextArea.setBackground(Color.DARK_GRAY);
        ordersTextArea.setForeground(Color.WHITE);
        panel.add(new JScrollPane(ordersTextArea), BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setBackground(Color.DARK_GRAY);
        buttonsPanel.add(new JButton("Добавить заказ"));
        buttonsPanel.add(new JButton("Изменить заказ"));
        buttonsPanel.add(new JButton("Отменить заказ"));

        panel.add(buttonsPanel, BorderLayout.SOUTH);
        return panel;
    }
}
