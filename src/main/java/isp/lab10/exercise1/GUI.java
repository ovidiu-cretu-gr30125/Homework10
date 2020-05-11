package isp.lab10.exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JLabel labelForAircraftId = null;
    JTextField textFieldForAircraftId = null;
    JLabel labelForAircraftStatus = null;
    JTextField textFieldForAircraftStatus = null;
    JButton addAircraftButton = null;
    JButton addCommandButton = null;
    JButton showAircraftList = null;
    JProgressBar progressBar = null;
    JDialog dialogForAddAircraft = null;
    JDialog dialogForAddCommand = null;
    JDialog dialogForShowAircraftList = null;
    JLabel dialogLabelForAircraftId = null;
    JTextField dialogTextFieldForAircraftId = null;
    JButton dialogAddAircraftButton = null;
    JLabel dialogLabelForAddCommand = null;
    JTextField dialogTextFieldForAddCommand = null;
    JButton dialogAddCommandButton = null;
    JLabel dialogAltitudeLabel = null;
    JTextField dialogAltitudeTextField = null;
    JScrollPane scrollPaneForAircraftList = null;
    JTextArea aircraftListTextArea = null;
    ATC atc = new ATC();


    public GUI(){
        setSize(600,200);
        getContentPane().setBackground(new java.awt.Color(0, 0, 0, 196));
        setTitle("Air Traffic Controller");
        setVisible(true);
        getContentPane().setLayout(null);
        Initializer();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Initializer(){

        this.labelForAircraftId = new JLabel("Aircraft ID");
        this.labelForAircraftId.setVisible(true);
        this.labelForAircraftId.setBounds(10,10,60,25);
        this.labelForAircraftId.setForeground(Color.white);
        add(labelForAircraftId);

        this.textFieldForAircraftId = new JTextField();
        this.textFieldForAircraftId.setVisible(true);
        this.textFieldForAircraftId.setBounds(80,10,150,25);
        this.textFieldForAircraftId.setEditable(false);
        add(textFieldForAircraftId);

        this.labelForAircraftStatus = new JLabel("Aircraft status");
        this.labelForAircraftStatus.setVisible(true);
        this.labelForAircraftStatus.setBounds(330,10,100,25);
        this.labelForAircraftStatus.setForeground(Color.white);
        add(labelForAircraftStatus);

        this.textFieldForAircraftStatus = new JTextField();
        this.textFieldForAircraftStatus.setVisible(true);
        this.textFieldForAircraftStatus.setBounds(420,10,150,25);
        this.textFieldForAircraftStatus.setEditable(false);
        add(textFieldForAircraftStatus);

        this.addAircraftButton = new JButton("Add aircraft");
        this.addAircraftButton.setVisible(true);
        this.addAircraftButton.setBackground(Color.white);
        this.addAircraftButton.setBounds(10,100,150,25);
        this.addAircraftButton.addActionListener(this);
        add(addAircraftButton);

        this.addCommandButton = new JButton("Add command");
        this.addCommandButton.setVisible(true);
        this.addCommandButton.setBackground(Color.white);
        this.addCommandButton.setBounds(215,100,150,25);
        this.addCommandButton.addActionListener(this);
        add(addCommandButton);

        this.showAircraftList = new JButton("Show aircraft list");
        this.showAircraftList.setVisible(true);
        this.showAircraftList.setBackground(Color.white);
        this.showAircraftList.setBounds(420,100,150,25);
        this.showAircraftList.addActionListener(this);
        add(showAircraftList);

        this.progressBar = new JProgressBar();
        this.progressBar.setVisible(true);
        this.progressBar.setBounds(185,60,200,20);
        this.progressBar.setValue(0);
        this.progressBar.setStringPainted(true);
        add(progressBar);

    }

    public void InitializeAddAircraftDialog() {

        this.dialogForAddAircraft = new JDialog();
        this.dialogForAddAircraft.setSize(250,150);
        this.dialogForAddAircraft.getContentPane().setLayout(null);
        this.dialogForAddAircraft.getContentPane().setBackground(new java.awt.Color(0, 0, 0, 196));
        this.dialogForAddAircraft.setLocationRelativeTo(null);
        this.dialogForAddAircraft.setVisible(true);

        this.dialogLabelForAircraftId = new JLabel("Enter aircraft ID");
        this.dialogLabelForAircraftId.setVisible(true);
        this.dialogLabelForAircraftId.setForeground(Color.white);
        this.dialogLabelForAircraftId.setBounds(10,10,100,25);
        dialogForAddAircraft.add(dialogLabelForAircraftId);

        this.dialogTextFieldForAircraftId = new JTextField();
        this.dialogTextFieldForAircraftId.setVisible(true);
        this.dialogTextFieldForAircraftId.setBounds(110,10,100,25);
        dialogForAddAircraft.add(dialogTextFieldForAircraftId);

        this.dialogAddAircraftButton = new JButton("Add aircraft");
        this.dialogAddAircraftButton.setBounds(45,50,150,25);
        this.dialogAddAircraftButton.setVisible(true);
        dialogForAddAircraft.add(dialogAddAircraftButton);

        dialogAddAircraftButton.addActionListener(actionEvent -> {
            try {
                atc.addAircraft(dialogTextFieldForAircraftId.getText());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dialogForAddAircraft.setVisible(false);
        });
    }


    public void InitializeAddCommandDialog() {

        this.dialogForAddCommand = new JDialog();
        this.dialogForAddCommand.setSize(250, 225);
        this.dialogForAddCommand.getContentPane().setLayout(null);
        this.dialogForAddCommand.getContentPane().setBackground(new java.awt.Color(0, 0, 0, 196));
        this.dialogForAddCommand.setLocationRelativeTo(null);
        this.dialogForAddCommand.setVisible(true);

        this.dialogLabelForAircraftId = new JLabel("Enter aircraft ID");
        this.dialogLabelForAircraftId.setVisible(true);
        this.dialogLabelForAircraftId.setForeground(Color.white);
        this.dialogLabelForAircraftId.setBounds(10, 10, 100, 25);
        dialogForAddCommand.add(dialogLabelForAircraftId);

        this.dialogTextFieldForAircraftId = new JTextField();
        this.dialogTextFieldForAircraftId.setVisible(true);
        this.dialogTextFieldForAircraftId.setBounds(110, 10, 100, 25);
        dialogForAddCommand.add(dialogTextFieldForAircraftId);

        this.dialogLabelForAddCommand = new JLabel("Command");
        this.dialogLabelForAddCommand.setVisible(true);
        this.dialogLabelForAddCommand.setForeground(Color.white);
        this.dialogLabelForAddCommand.setBounds(10, 45, 100, 25);
        dialogForAddCommand.add(dialogLabelForAddCommand);

        this.dialogTextFieldForAddCommand = new JTextField();
        this.dialogTextFieldForAddCommand.setVisible(true);
        this.dialogTextFieldForAddCommand.setBounds(110, 45, 100, 25);
        dialogForAddCommand.add(dialogTextFieldForAddCommand);

        this.dialogAltitudeLabel = new JLabel("Altitude");
        this.dialogAltitudeLabel.setVisible(true);
        this.dialogAltitudeLabel.setForeground(Color.white);
        this.dialogAltitudeLabel.setBounds(10, 80, 100, 25);
        dialogForAddCommand.add(dialogAltitudeLabel);

        this.dialogAltitudeTextField = new JTextField();
        this.dialogAltitudeTextField.setVisible(true);
        this.dialogAltitudeTextField.setBounds(110, 80, 100, 25);
        dialogForAddCommand.add(dialogAltitudeTextField);

        this.dialogAddCommandButton = new JButton("Send");
        this.dialogAddCommandButton.setVisible(true);
        this.dialogAddCommandButton.setBounds(65, 150, 100, 25);
        dialogForAddCommand.add(dialogAddCommandButton);
        dialogAddCommandButton.addActionListener(actionEvent -> {
            if (dialogTextFieldForAddCommand.getText().equals("TAKEOFF")) {
                AtcCommand takeoff = new TakeoffCommand(Integer.parseInt(dialogAltitudeTextField.getText()));
                atc.sendCommand(dialogTextFieldForAircraftId.getText(), takeoff);
                dialogForAddCommand.setVisible(false);
            } else if (dialogTextFieldForAddCommand.getText().equals("LAND")) {
                AtcCommand land = new LandCommand();
                atc.sendCommand(dialogTextFieldForAircraftId.getText(), land);
                dialogForAddCommand.setVisible(false);
            }
        });
    }
        public void InitializerShowAircraftListDialog(){

            this.dialogForShowAircraftList = new JDialog();
            this.dialogForShowAircraftList.setSize(250, 225);
            this.dialogForShowAircraftList.getContentPane().setLayout(null);
            this.dialogForShowAircraftList.getContentPane().setBackground(new java.awt.Color(0, 0, 0, 196));
            this.dialogForShowAircraftList.setLocationRelativeTo(null);
            this.dialogForShowAircraftList.setVisible(true);

            this.aircraftListTextArea = new JTextArea();

            this.scrollPaneForAircraftList = new JScrollPane(aircraftListTextArea);
            this.scrollPaneForAircraftList.setBounds(10,10,210,165);
            this.scrollPaneForAircraftList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            dialogForShowAircraftList.getContentPane().add(scrollPaneForAircraftList);
            this.aircraftListTextArea.setText(atc.showAircraft());
            this.aircraftListTextArea.setEditable(false);

        }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==addAircraftButton){
            InitializeAddAircraftDialog();
        }else if(actionEvent.getSource()==addCommandButton){
            InitializeAddCommandDialog();
        }else if(actionEvent.getSource()==showAircraftList){
            System.out.println(atc.showAircraft());
            InitializerShowAircraftListDialog();
        }
    }
}
