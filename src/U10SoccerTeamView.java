import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * This class provides a GUI view for managing a U10 soccer team. It allows for the addition,
 * removal, and creation of team players with various functionalities to display and interact with
 * the roster and starting lineup.
 */
public class U10SoccerTeamView {

  private JFrame frame;
  private JTextArea rosterTextArea;
  private JTextArea lineupTextArea;
  private JTextField firstNameField;
  private JTextField lastNameField;
  private JComboBox<PlayerPosition> positionComboBox;
  private JTextField dateOfBirthField;
  private JSlider skillLevelSlider;
  private JButton addButton;
  private JButton removeButton;
  private JButton createTeamButton;
  private JPanel lineupPanel;

  /**
   * Constructs and initializes the U10SoccerTeamView GUI components including panels, text areas,
   * input fields, and buttons. Sets the initial visibility and layout properties.
   */
  public U10SoccerTeamView() {
    frame = new JFrame("U10 Soccer Team Management");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    // Roster Panel
    JPanel rosterPanel = new JPanel(new BorderLayout());
    rosterPanel.setBorder(BorderFactory.createTitledBorder("Team Roster"));
    rosterTextArea = new JTextArea(10, 30);
    rosterTextArea.setEditable(false);
    rosterTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane rosterScrollPane = new JScrollPane(rosterTextArea);
    rosterPanel.add(rosterScrollPane, BorderLayout.CENTER);

    // Lineup Panel
    lineupPanel = new JPanel(new BorderLayout());
    lineupPanel.setBorder(BorderFactory.createTitledBorder("Starting Lineup"));
    lineupTextArea = new JTextArea(10, 30);
    lineupTextArea.setEditable(false);
    lineupTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane lineupScrollPane = new JScrollPane(lineupTextArea);
    lineupPanel.add(lineupScrollPane, BorderLayout.CENTER);
    lineupPanel.setVisible(false);

    // Central Panel holding both Roster and Lineup panels
    JPanel centerPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns
    centerPanel.add(rosterPanel);
    centerPanel.add(lineupPanel);
    frame.add(centerPanel, BorderLayout.CENTER);

    // Input Panel
    JPanel inputPanel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.anchor = GridBagConstraints.LINE_START;
    constraints.weightx = 0.5;
    constraints.insets = new Insets(5, 5, 5, 5); // Padding

    firstNameField = new JTextField();
    lastNameField = new JTextField();
    dateOfBirthField = new JTextField();
    positionComboBox = new JComboBox<>(PlayerPosition.values());
    skillLevelSlider = new JSlider(1, 5);
    skillLevelSlider.setMajorTickSpacing(1);
    skillLevelSlider.setPaintLabels(true);
    skillLevelSlider.setPaintTicks(true);
    addButton = new JButton("Add Player");
    removeButton = new JButton("Remove Player");
    createTeamButton = new JButton("Create Team");

    constraints.gridy = 0;
    inputPanel.add(new JLabel("First Name:"), constraints);
    constraints.gridx = 1;
    inputPanel.add(firstNameField, constraints);

    constraints.gridy++;
    constraints.gridx = 0;
    inputPanel.add(new JLabel("Last Name:"), constraints);
    constraints.gridx = 1;
    inputPanel.add(lastNameField, constraints);

    constraints.gridy++;
    constraints.gridx = 0;
    inputPanel.add(new JLabel("Date of Birth (yyyy-mm-dd):"), constraints);
    constraints.gridx = 1;
    inputPanel.add(dateOfBirthField, constraints);

    constraints.gridy++;
    constraints.gridx = 0;
    inputPanel.add(new JLabel("Preferred Position:"), constraints);
    constraints.gridx = 1;
    inputPanel.add(positionComboBox, constraints);

    constraints.gridy++;
    constraints.gridx = 0;
    inputPanel.add(new JLabel("Skill Level (1-5):"), constraints);
    constraints.gridx = 1;
    inputPanel.add(skillLevelSlider, constraints);


    JLabel addLabel = new JLabel("Add Player (fill in the information above):");
    constraints.gridy++;
    constraints.gridx = 0;
    constraints.gridwidth = 1;
    inputPanel.add(addLabel, constraints);
    constraints.gridx = 1;
    inputPanel.add(addButton, constraints);

    JLabel removeLabel = new JLabel("Remove Player (only First & Last Name needed):");
    constraints.gridy++;
    constraints.gridx = 0;
    constraints.gridwidth = 1;
    inputPanel.add(removeLabel, constraints);
    constraints.gridx = 1;
    inputPanel.add(removeButton, constraints);

    JLabel createTeamLabel = new JLabel("Create team if you have at least 10 players");
    createTeamButton = new JButton("Create Team");
    constraints.gridy++;
    constraints.gridx = 0;
    inputPanel.add(createTeamLabel, constraints);
    constraints.gridx = 1;
    inputPanel.add(createTeamButton, constraints);

    frame.add(inputPanel, BorderLayout.SOUTH);

    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Clears the input fields for adding a new player.
   */
  public void clearFields() {
    firstNameField.setText("");
    lastNameField.setText("");
    dateOfBirthField.setText("");
    positionComboBox.setSelectedIndex(0);
    skillLevelSlider.setValue(3);
  }

  /**
   * Sets the text for the roster text area.
   *
   * @param text The string representation of the team roster.
   */
  public void setRosterText(String text) {
    rosterTextArea.setText(text);
  }

  /**
   * Sets the text for the starting lineup text area.
   *
   * @param text The string representation of the starting lineup.
   */
  public void setLineupText(String text) {
    lineupTextArea.setText(text);
  }

  /**
   * Retrieves the first name input by the user.
   *
   * @return The text from the first name input field.
   */
  public String getFirstName() {
    return firstNameField.getText();
  }

  /**
   * Retrieves the last name input by the user.
   *
   * @return The text from the last name input field.
   */
  public String getLastName() {
    return lastNameField.getText();
  }

  /**
   * Retrieves the date of birth input by the user.
   *
   * @return The text from the date of birth input field.
   */
  public String getDateOfBirth() {
    return dateOfBirthField.getText();
  }

  /**
   * Retrieves the preferred player position selected by the user.
   *
   * @return The selected player position from the combo box.
   */
  public PlayerPosition getPosition() {
    return (PlayerPosition) positionComboBox.getSelectedItem();
  }

  /**
   * Retrieves the skill level set by the user using the slider.
   *
   * @return The integer value from the skill level slider.
   */
  public int getSkillLevel() {
    return skillLevelSlider.getValue();
  }
  /**
   * Adds an action listener to the "Add Player" button.
   *
   * @param listener The action listener to be added.
   */
  public void addAddPlayerListener(ActionListener listener) {
    addButton.addActionListener(listener);
  }

  /**
   * Adds an action listener to the "Remove Player" button.
   *
   * @param listener The action listener to be added.
   */
  public void addRemovePlayerListener(ActionListener listener) {
    removeButton.addActionListener(listener);
  }

  /**
   * Adds an action listener to the "Create Team" button.
   *
   * @param listener The action listener to be added.
   */
  public void addCreateTeamListener(ActionListener listener) {
    createTeamButton.addActionListener(listener);
  }

  /**
   * Makes the starting lineup panel visible to the user.
   */
  public void showStartingLineup() {
    lineupPanel.setVisible(true);
  }

  /**
   * Displays a message dialog with the specified message.
   *
   * @param message The message to be displayed in the dialog.
   */
  public void showMessage(String message) {
    JOptionPane.showMessageDialog(frame, message);
  }
}

