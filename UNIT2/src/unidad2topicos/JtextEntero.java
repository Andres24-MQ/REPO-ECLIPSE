package unidad2topicos;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JtextEntero  extends JTextField implements KeyListener{
    
    private int tamanio;

    public JtextEntero() {
        super();
        tamanio = Integer.MAX_VALUE;
        addKeyListener(this);
    }

    public JtextEntero(int columns) {
        super(columns);
        tamanio = columns;
        addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()) 
            if (e.getKeyCode() == KeyEvent.VK_X || e.getKeyCode() == KeyEvent.VK_C
                || e.getKeyCode() == KeyEvent.VK_V)
                e.consume();
            }

            public void keyReleased(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    JOptionPane.showMessageDialog(this, "backspace");
                }
                if(e.getKeyCode() == KeyEvent.VK_DELETE){
                    JOptionPane.showMessageDialog(this,"Delete");
                }
            }
            public void keyTyped(KeyEvent e) {
                if(getText().length() == tamanio)
                e.consume();
                else if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') 
                e.consume();
                
            }
        }


    

    


