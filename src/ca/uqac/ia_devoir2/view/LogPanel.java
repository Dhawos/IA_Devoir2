package ca.uqac.ia_devoir2.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LogPanel extends JPanel implements Consumer {
    private JTextArea textArea;

    public LogPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea(6,2);
        add(new JScrollPane(textArea),BorderLayout.CENTER);
    }

    @Override
    public void appendText(final String text) {
        if (EventQueue.isDispatchThread()) {
            textArea.append(text);
            textArea.setCaretPosition(textArea.getText().length());
        } else EventQueue.invokeLater(() -> {
            appendText(text);
        });
    }

}

interface Consumer {
    public void appendText(String text);
}
