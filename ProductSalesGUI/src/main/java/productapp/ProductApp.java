package productapp;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductApp extends JFrame {
    // Q2.2: text box for name, combo box for product, text box for price
    private final JTextField txtName = new JTextField(20);
    private final JComboBox<String> cboProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField txtPrice = new JTextField(20);
    private final JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null); // centres the window on screen

        // Q2.4: menu bar with File > Exit and Tools > Process / Clear
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        JMenu tools = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        file.add(exit);
        tools.add(processItem);
        tools.add(clearItem);
        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);

        // Q2.1: lay out the form like the sample screenshot (4 rows, 2 columns)
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 15));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        form.add(new JLabel("Customer Name:"));
        form.add(txtName);
        form.add(new JLabel("Select Product:"));
        form.add(cboProduct);
        form.add(new JLabel("Enter Price:"));
        form.add(txtPrice);
        form.add(new JLabel("")); // empty cell so the button sits under the text boxes
        form.add(btnProcess);
        add(form);

        // Q2.4: the Process button and Process menu item both call the same method
        exit.addActionListener(e -> System.exit(0));
        processItem.addActionListener(e -> processSale());
        btnProcess.addActionListener(e -> processSale());
        clearItem.addActionListener(e -> clearFields());
    }

    // Q2.3: runs when Process is clicked (button or menu)
    private void processSale() {
        String name = txtName.getText().trim();

        // make sure they actually typed a name
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // make sure the price is a real positive number
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
            if (price <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String product = (String) cboProduct.getSelectedItem();

        // let the calculations class do the maths
        IProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        // show the results in a message box like the sample
        JOptionPane.showMessageDialog(this,
                "Customer Name: " + name + "\n"
                + "Product: " + product + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total,
                "Message", JOptionPane.INFORMATION_MESSAGE);

        saveToFile(name, product, vat, commission, total);
    }

    // Q2.3: writes everything to data.txt in the format from the sample
    private void saveToFile(String name, String product,
                            double vat, double commission, double total) {
        String stars = "*".repeat(30);
        // "true" means append, so old sales don't get wiped
        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
            out.println("DATA LOG");
            out.println(stars);
            out.println("Customer Name: " + name);
            out.println("Product: " + product);
            out.println("VAT: R " + vat);
            out.println("COMMISSION: R " + commission);
            out.println("TOTAL: R " + total);
            out.println(stars);
            out.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save to data.txt.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Q2.4: Clear menu item, empties the boxes and resets the combo box to index 0
    private void clearFields() {
        txtName.setText("");
        txtPrice.setText("");
        cboProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}