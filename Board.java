import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Board {
	JButton rollButton;
	JButton endTurnButton;
	JPanel boardPanel;
	JLabel die1;
	JLabel die2;
	JLabel playerLabel;
	JLabel cashLabel;
	JLabel property;
	private int[] currentRole;
	JPanel panel1;
	JFrame frame;
	User currentUser;
	int doublesCount = 0;
	BoardSpace currentSpace;
	public static int UTIL = 999;
	public static ArrayList<BoardSpace> allSpaces = new ArrayList<>();




	public Board(User user) {
		this.currentUser = user;
	}

	public static void initSpaces() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("BoardSpaces.csv"));

			String line = "";
			int counter = 0;
			while ((line = reader.readLine()) != null) {
				if (line.equals("Name,Cost,Rent,ID")) {
					continue;
				}
				String[] splitline = line.split(",");
				String name = splitline[0];
				int cost = Integer.parseInt(splitline[1]);
				String rent = splitline[2];
				int ID = Integer.parseInt(splitline[3]);
				int rentVal;
				if (rent.equals("UTIL")) {
					rentVal = UTIL;
				} else {
					rentVal = Integer.parseInt(rent);
				}
				allSpaces.add(new Property(name,null, counter++, rentVal));

			}
			reader.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"File Not Found!", "File Error!", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ee){
			ee.printStackTrace();
		}
	}
	private void DisplayPlayer(User user) {
		BoardSpace location = user.getCurrentSpace();
	}

	public void displayBoard() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {


				frame = new JFrame();
				frame.setBounds(new Rectangle(1700, 1000));
				frame.setResizable(true);
				frame.setTitle("Monopoly");
				boardPanel = new JPanel() {
					@Override
					public void paint(Graphics g) {
						g.setColor(Color.black);
						g.drawRect(10, 10, 150, 150);      // Top Left corner
						g.drawRect(10, 800, 150, 150);    // Bottom Left corner
						g.drawRect(800, 10, 150, 150);    // Top Right corner
						g.drawRect(800, 800, 150, 150);  // Bottom Right corner

						// Top Row
						int x = 160;
						int y = 10;
						for (int i = 0; i < 8; i++) {
							g.drawRect(x, y, 80, 150);
							x += 80;
						}

						// Right Row
						x = 800;
						y = 160;
						for (int i = 0; i < 8; i++) {
							g.drawRect(x, y, 150, 80);
							y += 80;
						}

						// Left Row
						x = 10;
						y = 160;
						for (int i = 0; i < 8; i++) {
							g.drawRect(x, y, 150, 80);
							y += 80;
						}

						// Bottom Row
						x = 160;
						y = 800;
						for (int i = 0; i < 8; i++) {
							g.drawRect(x, y, 80, 150);
							x += 80;
						}
					}

				};


				ActionListener actionListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == rollButton) {
							boolean doubles = currentUser.roll();
							rollButton.setVisible(false);
							if (doubles) {
								rollButton.setVisible(true);
								doublesCount++;
							}
							currentRole = currentUser.getRoll();
							die1.setText(String.format("Die 1: %d", currentRole[0]));
							die2.setText(String.format("Die 2: %d", currentRole[1]));
							movePiece();

						}
						if (e.getSource() == endTurnButton) {
							endTurn();

						}
					}
				};

				boardPanel.setSize(new Dimension(900, 1020));
				panel1 = new JPanel();
				panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
				panel1.setPreferredSize(new Dimension(300, 1020));
				panel1.setLocation(1300, 0);
				//panel1.setBackground(Color.blue);

				// rollButton
				rollButton = new JButton();
				rollButton.setText("Roll Dice");
				rollButton.addActionListener(actionListener);

				// endTurnButton
				endTurnButton = new JButton();
				endTurnButton.setText("End Turn");
				endTurnButton.addActionListener(actionListener);


				// die1
				die1 = new JLabel("Die 1: 0");
				die1.setPreferredSize(new Dimension(50, 50));
				die1.setFont(new Font("Arial", Font.PLAIN, 30));

				// die2
				die2 = new JLabel("Die 2: 0");
				die2.setPreferredSize(new Dimension(50, 50));
				die2.setFont(new Font("Arial", Font.PLAIN, 30));

				// player Label
				playerLabel = new JLabel("Player 1's Turn");
				playerLabel.setPreferredSize(new Dimension(50, 50));
				playerLabel.setFont(new Font("Arial", Font.PLAIN, 30));

				// cashLabel
				cashLabel = new JLabel("Cash: $1500");
				cashLabel.setPreferredSize(new Dimension(50, 50));
				cashLabel.setFont(new Font("Arial", Font.PLAIN, 30));

				// property
				property = new JLabel("GO");
				property.setPreferredSize(new Dimension(50, 50));
				property.setFont(new Font("Arial", Font.PLAIN, 30));


				// panel1 add
				panel1.add(playerLabel);
				panel1.add(cashLabel);
				panel1.add(rollButton);
				panel1.add(endTurnButton);
				panel1.add(die1);
				panel1.add(die2);
				panel1.add(property);


				// add panels to frame
				frame.add(boardPanel, BorderLayout.CENTER);
				frame.add(panel1, BorderLayout.LINE_END);

				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);

			}
		});
	}

	private void endTurn() {
		currentUser = Main.getNextUser();
		rollButton.setVisible(true);
		die1.setText("Die 1: 0");
		die2.setText("Die 2: 0");
		cashLabel.setText(String.format("Cash: $%s", currentUser.getCash()));
		property.setText(currentUser.getCurrentSpace().getName());

		playerLabel.setText(currentUser.getName() + "'s Turn");
		doublesCount = 0;

	}

	private void movePiece() {
		BoardSpace currentSpace = currentUser.getCurrentSpace();  // 39 (boardwalk)
		int distance = currentRole[0] + currentRole[1];   // {4,6}
		int newLocation = currentSpace.getLocation() + distance;     // 49
		if (newLocation > 39) {  // circles back on the board  //49 > 39
			newLocation = newLocation - 40;               // 9
		}
		currentUser.setLocation(allSpaces.get(newLocation));
		property.setText(currentUser.getCurrentSpace().getName());
	}

	private void doAction() {
		String locationName = currentUser.getCurrentSpace().getName();
		switch (locationName) {
			case "Chance":
				Card chanceCard = BoardSpace.drawChance();
				break;
			case "Community Chest":
				Card communityCard = BoardSpace.drawCommunity();
				break;
			case "GO":
				currentUser.setCash(currentUser.getCash() + 200);
				break;
			case "Go to Jail":
				currentUser.setLocation(allSpaces.get(40));
				break;
			case "Free Parking":
				FreeParking.check();
			default:
				int spaceStatus = currentSpace.getStatus();

		}


	}
}
