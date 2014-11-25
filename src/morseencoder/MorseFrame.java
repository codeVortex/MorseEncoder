package morseencoder;

/**
 * A simple GUI created with the Netbeans GUI designer. The most interesting part is the custom inner enum class 
 * Role which glues the display status of the toggle buttonn proper labels and its corresponding action to be 
 * performed when pushed.
 * 
 * @author Athanasios Kontis
 */
public class MorseFrame extends javax.swing.JFrame {
    
    private enum Role {
        ENCODE ("Encode text", "Plain Text", "Morse Code"),
        DECODE ("Decode text", "Morse Code", "Plain Text");
        private final String desc, mainLabel, dependentLabel;
        Role (String r, String m, String d) {desc = r; mainLabel = m; dependentLabel = d;}
        public String act(String s){
            switch (this) {
                case ENCODE: return Morse.encode(s);
                case DECODE: return Morse.decode(s);
                default: return s;
            }
        }
    }
    
    private Role activeRole = Role.ENCODE;
    
    /**
     * Creates new form MorseFrame
     */
    public MorseFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        mainScrollArea = new javax.swing.JScrollPane();
        mainArea = new javax.swing.JTextArea();
        dependentLabel = new javax.swing.JLabel();
        dependentScrollArea = new javax.swing.JScrollPane();
        dependentArea = new javax.swing.JTextArea();
        buttonPanel = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        toggleRolesButton = new javax.swing.JToggleButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Morse Code Encoder/Decoder");
        setLocationByPlatform(true);

        mainLabel.setLabelFor(mainScrollArea);
        mainLabel.setText(activeRole.mainLabel);
        mainLabel.setToolTipText("");
        mainLabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                mainLabelPropertyChange(evt);
            }
        });

        mainArea.setColumns(20);
        mainArea.setLineWrap(true);
        mainArea.setRows(5);
        mainArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                mainAreaCaretUpdate(evt);
            }
        });
        mainScrollArea.setViewportView(mainArea);

        dependentLabel.setLabelFor(dependentScrollArea);
        dependentLabel.setText(activeRole.dependentLabel);
        dependentLabel.setToolTipText("");

        dependentArea.setEditable(false);
        dependentArea.setColumns(20);
        dependentArea.setLineWrap(true);
        dependentArea.setRows(5);
        dependentArea.setAutoscrolls(false);
        dependentScrollArea.setViewportView(dependentArea);

        buttonPanel.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        clearButton.setText("Clear Text Areas");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(clearButton);

        toggleRolesButton.setText(activeRole.desc);
        toggleRolesButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toggleRolesButtonItemStateChanged(evt);
            }
        });
        buttonPanel.add(toggleRolesButton);

        exitButton.setText("Exit Application");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(exitButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(mainScrollArea)
                    .addComponent(dependentScrollArea, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mainLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dependentLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(mainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainScrollArea, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dependentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dependentScrollArea, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        mainArea.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void toggleRolesButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toggleRolesButtonItemStateChanged
        activeRole = activeRole == Role.ENCODE ? Role.DECODE : Role.ENCODE;
        mainLabel.setText(activeRole.mainLabel);
        dependentLabel.setText(activeRole.dependentLabel);
        toggleRolesButton.setText(activeRole.desc);
        mainArea.setText(dependentArea.getText().trim());
    }//GEN-LAST:event_toggleRolesButtonItemStateChanged

    private void mainAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_mainAreaCaretUpdate
        String encodedText = activeRole.act( mainArea.getText() );
        dependentArea.setText( encodedText );
    }//GEN-LAST:event_mainAreaCaretUpdate

    private void mainLabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_mainLabelPropertyChange
        if (evt.getPropertyName().equals("activeRole")) {
            mainLabel.setText(activeRole.mainLabel);
        }
    }//GEN-LAST:event_mainLabelPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MorseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MorseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MorseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MorseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MorseFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel buttonPanel;
    javax.swing.JButton clearButton;
    javax.swing.JTextArea dependentArea;
    javax.swing.JLabel dependentLabel;
    javax.swing.JScrollPane dependentScrollArea;
    javax.swing.JButton exitButton;
    javax.swing.JTextArea mainArea;
    javax.swing.JLabel mainLabel;
    javax.swing.JScrollPane mainScrollArea;
    javax.swing.JToggleButton toggleRolesButton;
    // End of variables declaration//GEN-END:variables
}
