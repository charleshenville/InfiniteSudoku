package Sudoku;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class InfiniteSudoku extends GeneratePuzzle {

	public static Container maincontainer;
	static Container popupcontainer;

	static Font menufont = new Font("Helvetica", Font.PLAIN, 18);
	static Font menufont2 = new Font("Helvetica", Font.BOLD, 24);
	static Font menufont3 = new Font("Helvetica", Font.BOLD, 12);

	public static Font titlefont = new Font("Times New Roman", Font.BOLD, 80);
	public static Font minititlefont = new Font("Times New Roman", Font.BOLD, 12);

	public static JLabel popuplabel = new JLabel(" ", SwingConstants.CENTER);
	public static JFrame popupframe = new JFrame("Notification");

	public static JPanel titlepan = new JPanel();
	public static JButton begin = new JButton("Begin");

	public static String tstring;
	public static char[][] sudokuarray = new char[9][9];
	public static char[][] sudokuarraysolution = new char[9][9];
	public static char[][] playsudokuarray = new char[9][9];
	public static char[][] failsafearray = new char[9][9];

	public static int rve;
	public static int cve;
	public static int vve;

	public static int autopressed;

	public static int t;
	public static int m;
	public static int score;

	//81 Label declarations for 81 Sudoku cells: May look extensive but is easy to understand and work around.
	
	public static JLabel R1C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R1C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R2C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R2C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R3C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R3C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R4C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R4C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R5C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R5C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R6C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R6C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R7C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R7C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R8C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R8C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JLabel R9C1 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C2 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C3 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C4 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C5 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C6 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C7 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C8 = new JLabel(" ", SwingConstants.CENTER);
	public static JLabel R9C9 = new JLabel(" ", SwingConstants.CENTER);

	public static JFrame main = new JFrame("Infinite Sudoku - Charles Henville");

	public static void main(String[] args) {
		
		autopressed = 0;
		//will either be 1 or 0 depending on wether or not the autosolve feature has been used
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(1280, 720);
		main.setLayout(null);
		maincontainer = main.getContentPane();

		TitleScreen();

		//all setup for graphical user interface
		
		JPanel menu = new JPanel();
		JPanel menu2 = new JPanel();

		menu.setBounds(1000, 0, 280, 720);
		menu2.setBounds(0, 0, 280, 720);

		menu.setLayout(null);
		menu2.setLayout(null);

		menu.setBackground(new Color(93, 93, 112));
		menu2.setBackground(new Color(178, 178, 191));

		maincontainer.add(menu);
		maincontainer.add(menu2);

		JButton reset = new JButton("Reset");
		reset.setBounds(70, 72, 140, 72);
		reset.setFont(menufont);

		JButton checksolution = new JButton("Check Solution");
		checksolution.setBounds(70, 216, 140, 72);
		checksolution.setFont(menufont);

		JButton newpuzzle = new JButton("New Puzzle");
		newpuzzle.setBounds(70, 360, 140, 72);
		newpuzzle.setFont(menufont);

		JButton autosolve = new JButton("Auto Solve");
		autosolve.setBounds(70, 504, 140, 72);
		autosolve.setFont(menufont);

		JLabel row = new JLabel("Row# [1-9]");
		row.setBounds(70, 80, 140, 20);
		row.setFont(menufont);

		JTextField rowe = new JTextField(1);
		rowe.setBounds(70, 100, 140, 60);
		rowe.setFont(menufont);

		JLabel colu = new JLabel("Column# [1-9]");
		colu.setBounds(70, 240, 140, 20);
		colu.setFont(menufont);

		JTextField colue = new JTextField(1);
		colue.setBounds(70, 260, 140, 60);
		colue.setFont(menufont);

		JLabel entryval = new JLabel("Value# [1-9]");
		entryval.setBounds(70, 400, 140, 20);
		entryval.setFont(menufont);

		JTextField entryvale = new JTextField(1);
		entryvale.setBounds(70, 420, 140, 60);
		entryvale.setFont(menufont);

		JButton enter = new JButton("Enter");
		enter.setBounds(70, 560, 140, 80);
		enter.setFont(menufont);

		rowe.setVisible(false);
		colue.setVisible(false);
		entryvale.setVisible(false);
		reset.setVisible(false);
		enter.setVisible(false);
		checksolution.setVisible(false);
		autosolve.setVisible(false);
		newpuzzle.setVisible(false);

		menu.add(autosolve);
		menu.add(reset);
		menu.add(newpuzzle);
		menu.add(checksolution);

		menu2.add(row);
		menu2.add(rowe);
		menu2.add(colu);
		menu2.add(colue);
		menu2.add(entryval);
		menu2.add(entryvale);
		menu2.add(enter);

		JLabel timerpanel = new JLabel(" ", SwingConstants.CENTER);
		timerpanel.setBounds(20, 10, 240, 30);
		menu2.add(timerpanel);
		timerpanel.setFont(menufont);

		ActionListener inc = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				//this method activates once every second if timer is activated
				
				t++;

				if (t > 59) {
					t = 0;
					m++;
				}

				if (t > 9) {
					tstring = m + ":" + t;
				} else {
					tstring = m + ":0" + t;
				}

				timerpanel.setText(tstring);

			}
		};
		Timer timer = new Timer(1000, inc);
		timer.setRepeats(true);

		JPanel TR1 = new JPanel();
		TR1.setBounds(280, 0, 720, 4);
		TR1.setBackground(new Color(0, 0, 0));
		maincontainer.add(TR1);

		JPanel TR2 = new JPanel();
		TR2.setBounds(280, 240, 720, 4);
		TR2.setBackground(new Color(0, 0, 0));
		maincontainer.add(TR2);

		JPanel TR3 = new JPanel();
		TR3.setBounds(280, 478, 720, 4);
		TR3.setBackground(new Color(0, 0, 0));
		maincontainer.add(TR3);

		JPanel TR4 = new JPanel();
		TR4.setBounds(280, 716, 720, 4);
		TR4.setBackground(new Color(0, 0, 0));
		maincontainer.add(TR4);

		JPanel TC1 = new JPanel();
		TC1.setBounds(280, 0, 4, 720);
		TC1.setBackground(new Color(0, 0, 0));
		maincontainer.add(TC1);

		JPanel TC2 = new JPanel();
		TC2.setBounds(520, 0, 4, 720);
		TC2.setBackground(new Color(0, 0, 0));
		maincontainer.add(TC2);

		JPanel TC3 = new JPanel();
		TC3.setBounds(758, 0, 4, 720);
		TC3.setBackground(new Color(0, 0, 0));
		maincontainer.add(TC3);

		JPanel TC4 = new JPanel();
		TC4.setBounds(996, 0, 4, 720);
		TC4.setBackground(new Color(0, 0, 0));
		maincontainer.add(TC4);

		JPanel SR1 = new JPanel();
		SR1.setBounds(280, 79, 720, 2);
		SR1.setBackground(new Color(173, 173, 173));
		maincontainer.add(SR1);

		JPanel SR2 = new JPanel();
		SR2.setBounds(280, 159, 720, 2);
		SR2.setBackground(new Color(173, 173, 173));
		maincontainer.add(SR2);

		JPanel SR3 = new JPanel();
		SR3.setBounds(280, 560, 720, 2);
		SR3.setBackground(new Color(173, 173, 173));
		maincontainer.add(SR3);

		JPanel SR4 = new JPanel();
		SR4.setBounds(280, 319, 720, 2);
		SR4.setBackground(new Color(173, 173, 173));
		maincontainer.add(SR4);

		JPanel SR5 = new JPanel();
		SR5.setBounds(280, 399, 720, 2);
		SR5.setBackground(new Color(173, 173, 173));
		maincontainer.add(SR5);

		JPanel SR6 = new JPanel();
		SR6.setBounds(280, 642, 720, 2);
		SR6.setBackground(new Color(173, 173, 173));
		maincontainer.add(SR6);

		JPanel SC1 = new JPanel();
		SC1.setBounds(359, 0, 2, 720);
		SC1.setBackground(new Color(173, 173, 173));
		maincontainer.add(SC1);

		JPanel SC2 = new JPanel();
		SC2.setBounds(439, 0, 2, 720);
		SC2.setBackground(new Color(173, 173, 173));
		maincontainer.add(SC2);

		JPanel SC3 = new JPanel();
		SC3.setBounds(838, 0, 2, 720);
		SC3.setBackground(new Color(173, 173, 173));
		maincontainer.add(SC3);

		JPanel SC4 = new JPanel();
		SC4.setBounds(599, 0, 2, 720);
		SC4.setBackground(new Color(173, 173, 173));
		maincontainer.add(SC4);

		JPanel SC5 = new JPanel();
		SC5.setBounds(679, 0, 2, 720);
		SC5.setBackground(new Color(173, 173, 173));
		maincontainer.add(SC5);

		JPanel SC6 = new JPanel();
		SC6.setBounds(919, 0, 2, 720);
		SC6.setBackground(new Color(173, 173, 173));
		maincontainer.add(SC6);

		JPanel board = new JPanel();
		board.setLayout(new GridLayout(9, 9));
		board.setBounds(280, 0, 720, 720);
		board.setOpaque(false);
		maincontainer.add(board);

		//adding previously declared 81 labels into the GUI
		
		board.add(R1C1);
		board.add(R1C2);
		board.add(R1C3);
		board.add(R1C4);
		board.add(R1C5);
		board.add(R1C6);
		board.add(R1C7);
		board.add(R1C8);
		board.add(R1C9);
		R1C1.setFont(menufont2);
		R1C2.setFont(menufont2);
		R1C3.setFont(menufont2);
		R1C4.setFont(menufont2);
		R1C5.setFont(menufont2);
		R1C6.setFont(menufont2);
		R1C7.setFont(menufont2);
		R1C8.setFont(menufont2);
		R1C9.setFont(menufont2);

		board.add(R2C1);
		board.add(R2C2);
		board.add(R2C3);
		board.add(R2C4);
		board.add(R2C5);
		board.add(R2C6);
		board.add(R2C7);
		board.add(R2C8);
		board.add(R2C9);
		R2C1.setFont(menufont2);
		R2C2.setFont(menufont2);
		R2C3.setFont(menufont2);
		R2C4.setFont(menufont2);
		R2C5.setFont(menufont2);
		R2C6.setFont(menufont2);
		R2C7.setFont(menufont2);
		R2C8.setFont(menufont2);
		R2C9.setFont(menufont2);

		board.add(R3C1);
		board.add(R3C2);
		board.add(R3C3);
		board.add(R3C4);
		board.add(R3C5);
		board.add(R3C6);
		board.add(R3C7);
		board.add(R3C8);
		board.add(R3C9);
		R3C1.setFont(menufont2);
		R3C2.setFont(menufont2);
		R3C3.setFont(menufont2);
		R3C4.setFont(menufont2);
		R3C5.setFont(menufont2);
		R3C6.setFont(menufont2);
		R3C7.setFont(menufont2);
		R3C8.setFont(menufont2);
		R3C9.setFont(menufont2);

		board.add(R4C1);
		board.add(R4C2);
		board.add(R4C3);
		board.add(R4C4);
		board.add(R4C5);
		board.add(R4C6);
		board.add(R4C7);
		board.add(R4C8);
		board.add(R4C9);
		R4C1.setFont(menufont2);
		R4C2.setFont(menufont2);
		R4C3.setFont(menufont2);
		R4C4.setFont(menufont2);
		R4C5.setFont(menufont2);
		R4C6.setFont(menufont2);
		R4C7.setFont(menufont2);
		R4C8.setFont(menufont2);
		R4C9.setFont(menufont2);

		board.add(R5C1);
		board.add(R5C2);
		board.add(R5C3);
		board.add(R5C4);
		board.add(R5C5);
		board.add(R5C6);
		board.add(R5C7);
		board.add(R5C8);
		board.add(R5C9);
		R5C1.setFont(menufont2);
		R5C2.setFont(menufont2);
		R5C3.setFont(menufont2);
		R5C4.setFont(menufont2);
		R5C5.setFont(menufont2);
		R5C6.setFont(menufont2);
		R5C7.setFont(menufont2);
		R5C8.setFont(menufont2);
		R5C9.setFont(menufont2);

		board.add(R6C1);
		board.add(R6C2);
		board.add(R6C3);
		board.add(R6C4);
		board.add(R6C5);
		board.add(R6C6);
		board.add(R6C7);
		board.add(R6C8);
		board.add(R6C9);
		R6C1.setFont(menufont2);
		R6C2.setFont(menufont2);
		R6C3.setFont(menufont2);
		R6C4.setFont(menufont2);
		R6C5.setFont(menufont2);
		R6C6.setFont(menufont2);
		R6C7.setFont(menufont2);
		R6C8.setFont(menufont2);
		R6C9.setFont(menufont2);

		board.add(R7C1);
		board.add(R7C2);
		board.add(R7C3);
		board.add(R7C4);
		board.add(R7C5);
		board.add(R7C6);
		board.add(R7C7);
		board.add(R7C8);
		board.add(R7C9);
		R7C1.setFont(menufont2);
		R7C2.setFont(menufont2);
		R7C3.setFont(menufont2);
		R7C4.setFont(menufont2);
		R7C5.setFont(menufont2);
		R7C6.setFont(menufont2);
		R7C7.setFont(menufont2);
		R7C8.setFont(menufont2);
		R7C9.setFont(menufont2);

		board.add(R8C1);
		board.add(R8C2);
		board.add(R8C3);
		board.add(R8C4);
		board.add(R8C5);
		board.add(R8C6);
		board.add(R8C7);
		board.add(R8C8);
		board.add(R8C9);
		R8C1.setFont(menufont2);
		R8C2.setFont(menufont2);
		R8C3.setFont(menufont2);
		R8C4.setFont(menufont2);
		R8C5.setFont(menufont2);
		R8C6.setFont(menufont2);
		R8C7.setFont(menufont2);
		R8C8.setFont(menufont2);
		R8C9.setFont(menufont2);

		board.add(R9C1);
		board.add(R9C2);
		board.add(R9C3);
		board.add(R9C4);
		board.add(R9C5);
		board.add(R9C6);
		board.add(R9C7);
		board.add(R9C8);
		board.add(R9C9);
		R9C1.setFont(menufont2);
		R9C2.setFont(menufont2);
		R9C3.setFont(menufont2);
		R9C4.setFont(menufont2);
		R9C5.setFont(menufont2);
		R9C6.setFont(menufont2);
		R9C7.setFont(menufont2);
		R9C8.setFont(menufont2);
		R9C9.setFont(menufont2);

		//playing panels are set as visible, then title screen is layered on top
		
		main.setVisible(true);
		TitleScreenVisible();

		//setup for the pop up frame that appears if certain buttons are pushed in certain conditions
		
		popupframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		popupframe.setLayout(null);
		popupcontainer = popupframe.getContentPane();

		JPanel popuppanel = new JPanel();
		popuppanel.setBackground(new Color(153, 136, 112));
		popuppanel.setBounds(0, 0, 426, 160);
		popupcontainer.add(popuppanel);
		popuppanel.setLayout(null);

		popuppanel.add(popuplabel);
		popuplabel.setFont(menufont);
		popuplabel.setBounds(20, 10, 386, 50);

		JLabel scorelabel = new JLabel(" ", SwingConstants.CENTER);
		popuppanel.add(scorelabel);
		scorelabel.setFont(menufont3);
		scorelabel.setBounds(20, 35, 386, 50);

		JButton okaywidget = new JButton("Okay");
		okaywidget.setBounds(107, 75, 214, 50);
		okaywidget.setFont(menufont);
		popuppanel.add(okaywidget);

		popupframe.setSize(426, 160);

		begin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// "begin" button will hide the title screen panel.
				titlepan.setVisible(false);

				rowe.setVisible(true);
				colue.setVisible(true);
				entryvale.setVisible(true);
				reset.setVisible(true);
				enter.setVisible(true);
				checksolution.setVisible(true);
				autosolve.setVisible(true);
				newpuzzle.setVisible(true);
			}
		});

		newpuzzle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				score = 0;
				timer.start();
				t = 0;
				m = 0;

				autopressed = 0;

				//calling other class with object to generate a random puzzle
				
				GeneratePuzzle puzgenobj = new GeneratePuzzle();

				puzgenobj.main();

				int temporal;
				String temporal2;

				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						temporal = forsolve[i][j];
						temporal2 = String.valueOf(temporal);

						if (temporal == 0) {
							sudokuarray[i][j] = ' ';
						} else {
							sudokuarray[i][j] = temporal2.charAt(0);
						}
					}
				}

				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						temporal = testarray[i][j];
						temporal2 = String.valueOf(temporal);
						sudokuarraysolution[i][j] = temporal2.charAt(0);

					}
				}
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						temporal = presolvedarray[i][j];
						temporal2 = String.valueOf(temporal);
						failsafearray[i][j] = temporal2.charAt(0);

					}
				}

				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						playsudokuarray[i][j] = sudokuarray[i][j];

					}
				}

				Designation();

			}
		});

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t = 0;
				m = 0;
				Designation();

			}
		});

		autosolve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				timer.stop();
				autopressed = 1;
				SoloutionDesignation();

			}
		});

		checksolution.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				timer.stop();
				calculateScore();
				scorelabel.setText(" ");
				boolean isval = checkPlayerSolution();
				
				//Determining whether or not user has solved the puzzle correctly
				if (isval == true) {

					if (autopressed == 0) {

						calculateScore();
						scorelabel.setText("Score: " + score);
						popuplabel.setText("Congratulations! Puzzle Solved In " + tstring);
						popupframe.setVisible(true);

					} else {

						popuplabel.setText("Autosolve Has Been Used For This Puzzle.");
						popupframe.setVisible(true);
					}

				}

				else {

					if (autopressed == 0) {

						timer.start();
						popuplabel.setText("Incorrect or Incomplete Solution. Check Again.");
						popupframe.setVisible(true);

					} else {

						popuplabel.setText("Autosolve Has Been Used For This Puzzle.");
						popupframe.setVisible(true);
					}

				}

			}
		});

		okaywidget.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				popupframe.setVisible(false);

			}
		});

		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//taking all values from the text fields and ensuring they are actually valid. 
				scorelabel.setText(" ");

				timer.start();
				String rows = rowe.getText();
				String columns = colue.getText();
				String valueentered = entryvale.getText();

				rve = Integer.valueOf(rows);
				cve = Integer.valueOf(columns);
				vve = Integer.valueOf(valueentered);

				if (rve >= 1 && rve <= 9 && cve >= 1 && cve <= 9 && vve >= 1 && vve <= 9) {

					if (forsolve[rve - 1][cve - 1] == 0) {

						playsudokuarray[rve - 1][cve - 1] = Integer.toString(vve).charAt(0);
						PlayerDesignation();

					}

					else {

						popuplabel.setText("Cannot overwrite given numbers.");
						popupframe.setVisible(true);

					}
				}

				else {

					popuplabel.setText("Values entered must be integers [1-9]");
					popupframe.setVisible(true);

				}

			}
		});

	}

	public static void Designation() {

		//Assigns the 81 JLabels all values of array (puzzle to be solved).
		
		String SR1C1 = String.valueOf(sudokuarray[0][0]);
		String SR1C2 = String.valueOf(sudokuarray[0][1]);
		String SR1C3 = String.valueOf(sudokuarray[0][2]);
		String SR1C4 = String.valueOf(sudokuarray[0][3]);
		String SR1C5 = String.valueOf(sudokuarray[0][4]);
		String SR1C6 = String.valueOf(sudokuarray[0][5]);
		String SR1C7 = String.valueOf(sudokuarray[0][6]);
		String SR1C8 = String.valueOf(sudokuarray[0][7]);
		String SR1C9 = String.valueOf(sudokuarray[0][8]);

		String SR2C1 = String.valueOf(sudokuarray[1][0]);
		String SR2C2 = String.valueOf(sudokuarray[1][1]);
		String SR2C3 = String.valueOf(sudokuarray[1][2]);
		String SR2C4 = String.valueOf(sudokuarray[1][3]);
		String SR2C5 = String.valueOf(sudokuarray[1][4]);
		String SR2C6 = String.valueOf(sudokuarray[1][5]);
		String SR2C7 = String.valueOf(sudokuarray[1][6]);
		String SR2C8 = String.valueOf(sudokuarray[1][7]);
		String SR2C9 = String.valueOf(sudokuarray[1][8]);

		String SR3C1 = String.valueOf(sudokuarray[2][0]);
		String SR3C2 = String.valueOf(sudokuarray[2][1]);
		String SR3C3 = String.valueOf(sudokuarray[2][2]);
		String SR3C4 = String.valueOf(sudokuarray[2][3]);
		String SR3C5 = String.valueOf(sudokuarray[2][4]);
		String SR3C6 = String.valueOf(sudokuarray[2][5]);
		String SR3C7 = String.valueOf(sudokuarray[2][6]);
		String SR3C8 = String.valueOf(sudokuarray[2][7]);
		String SR3C9 = String.valueOf(sudokuarray[2][8]);

		String SR4C1 = String.valueOf(sudokuarray[3][0]);
		String SR4C2 = String.valueOf(sudokuarray[3][1]);
		String SR4C3 = String.valueOf(sudokuarray[3][2]);
		String SR4C4 = String.valueOf(sudokuarray[3][3]);
		String SR4C5 = String.valueOf(sudokuarray[3][4]);
		String SR4C6 = String.valueOf(sudokuarray[3][5]);
		String SR4C7 = String.valueOf(sudokuarray[3][6]);
		String SR4C8 = String.valueOf(sudokuarray[3][7]);
		String SR4C9 = String.valueOf(sudokuarray[3][8]);

		String SR5C1 = String.valueOf(sudokuarray[4][0]);
		String SR5C2 = String.valueOf(sudokuarray[4][1]);
		String SR5C3 = String.valueOf(sudokuarray[4][2]);
		String SR5C4 = String.valueOf(sudokuarray[4][3]);
		String SR5C5 = String.valueOf(sudokuarray[4][4]);
		String SR5C6 = String.valueOf(sudokuarray[4][5]);
		String SR5C7 = String.valueOf(sudokuarray[4][6]);
		String SR5C8 = String.valueOf(sudokuarray[4][7]);
		String SR5C9 = String.valueOf(sudokuarray[4][8]);

		String SR6C1 = String.valueOf(sudokuarray[5][0]);
		String SR6C2 = String.valueOf(sudokuarray[5][1]);
		String SR6C3 = String.valueOf(sudokuarray[5][2]);
		String SR6C4 = String.valueOf(sudokuarray[5][3]);
		String SR6C5 = String.valueOf(sudokuarray[5][4]);
		String SR6C6 = String.valueOf(sudokuarray[5][5]);
		String SR6C7 = String.valueOf(sudokuarray[5][6]);
		String SR6C8 = String.valueOf(sudokuarray[5][7]);
		String SR6C9 = String.valueOf(sudokuarray[5][8]);

		String SR7C1 = String.valueOf(sudokuarray[6][0]);
		String SR7C2 = String.valueOf(sudokuarray[6][1]);
		String SR7C3 = String.valueOf(sudokuarray[6][2]);
		String SR7C4 = String.valueOf(sudokuarray[6][3]);
		String SR7C5 = String.valueOf(sudokuarray[6][4]);
		String SR7C6 = String.valueOf(sudokuarray[6][5]);
		String SR7C7 = String.valueOf(sudokuarray[6][6]);
		String SR7C8 = String.valueOf(sudokuarray[6][7]);
		String SR7C9 = String.valueOf(sudokuarray[6][8]);

		String SR8C1 = String.valueOf(sudokuarray[7][0]);
		String SR8C2 = String.valueOf(sudokuarray[7][1]);
		String SR8C3 = String.valueOf(sudokuarray[7][2]);
		String SR8C4 = String.valueOf(sudokuarray[7][3]);
		String SR8C5 = String.valueOf(sudokuarray[7][4]);
		String SR8C6 = String.valueOf(sudokuarray[7][5]);
		String SR8C7 = String.valueOf(sudokuarray[7][6]);
		String SR8C8 = String.valueOf(sudokuarray[7][7]);
		String SR8C9 = String.valueOf(sudokuarray[7][8]);

		String SR9C1 = String.valueOf(sudokuarray[8][0]);
		String SR9C2 = String.valueOf(sudokuarray[8][1]);
		String SR9C3 = String.valueOf(sudokuarray[8][2]);
		String SR9C4 = String.valueOf(sudokuarray[8][3]);
		String SR9C5 = String.valueOf(sudokuarray[8][4]);
		String SR9C6 = String.valueOf(sudokuarray[8][5]);
		String SR9C7 = String.valueOf(sudokuarray[8][6]);
		String SR9C8 = String.valueOf(sudokuarray[8][7]);
		String SR9C9 = String.valueOf(sudokuarray[8][8]);

		R1C1.setText(SR1C1);
		R1C2.setText(SR1C2);
		R1C3.setText(SR1C3);
		R1C4.setText(SR1C4);
		R1C5.setText(SR1C5);
		R1C6.setText(SR1C6);
		R1C7.setText(SR1C7);
		R1C8.setText(SR1C8);
		R1C9.setText(SR1C9);

		R2C1.setText(SR2C1);
		R2C2.setText(SR2C2);
		R2C3.setText(SR2C3);
		R2C4.setText(SR2C4);
		R2C5.setText(SR2C5);
		R2C6.setText(SR2C6);
		R2C7.setText(SR2C7);
		R2C8.setText(SR2C8);
		R2C9.setText(SR2C9);

		R3C1.setText(SR3C1);
		R3C2.setText(SR3C2);
		R3C3.setText(SR3C3);
		R3C4.setText(SR3C4);
		R3C5.setText(SR3C5);
		R3C6.setText(SR3C6);
		R3C7.setText(SR3C7);
		R3C8.setText(SR3C8);
		R3C9.setText(SR3C9);

		R4C1.setText(SR4C1);
		R4C2.setText(SR4C2);
		R4C3.setText(SR4C3);
		R4C4.setText(SR4C4);
		R4C5.setText(SR4C5);
		R4C6.setText(SR4C6);
		R4C7.setText(SR4C7);
		R4C8.setText(SR4C8);
		R4C9.setText(SR4C9);

		R5C1.setText(SR5C1);
		R5C2.setText(SR5C2);
		R5C3.setText(SR5C3);
		R5C4.setText(SR5C4);
		R5C5.setText(SR5C5);
		R5C6.setText(SR5C6);
		R5C7.setText(SR5C7);
		R5C8.setText(SR5C8);
		R5C9.setText(SR5C9);

		R6C1.setText(SR6C1);
		R6C2.setText(SR6C2);
		R6C3.setText(SR6C3);
		R6C4.setText(SR6C4);
		R6C5.setText(SR6C5);
		R6C6.setText(SR6C6);
		R6C7.setText(SR6C7);
		R6C8.setText(SR6C8);
		R6C9.setText(SR6C9);

		R7C1.setText(SR7C1);
		R7C2.setText(SR7C2);
		R7C3.setText(SR7C3);
		R7C4.setText(SR7C4);
		R7C5.setText(SR7C5);
		R7C6.setText(SR7C6);
		R7C7.setText(SR7C7);
		R7C8.setText(SR7C8);
		R7C9.setText(SR7C9);

		R8C1.setText(SR8C1);
		R8C2.setText(SR8C2);
		R8C3.setText(SR8C3);
		R8C4.setText(SR8C4);
		R8C5.setText(SR8C5);
		R8C6.setText(SR8C6);
		R8C7.setText(SR8C7);
		R8C8.setText(SR8C8);
		R8C9.setText(SR8C9);

		R9C1.setText(SR9C1);
		R9C2.setText(SR9C2);
		R9C3.setText(SR9C3);
		R9C4.setText(SR9C4);
		R9C5.setText(SR9C5);
		R9C6.setText(SR9C6);
		R9C7.setText(SR9C7);
		R9C8.setText(SR9C8);
		R9C9.setText(SR9C9);

	}

	public static void PlayerDesignation() {

		//Assigns the 81 JLabels all values of array (player inputs).
		
		String SR1C1 = String.valueOf(playsudokuarray[0][0]);
		String SR1C2 = String.valueOf(playsudokuarray[0][1]);
		String SR1C3 = String.valueOf(playsudokuarray[0][2]);
		String SR1C4 = String.valueOf(playsudokuarray[0][3]);
		String SR1C5 = String.valueOf(playsudokuarray[0][4]);
		String SR1C6 = String.valueOf(playsudokuarray[0][5]);
		String SR1C7 = String.valueOf(playsudokuarray[0][6]);
		String SR1C8 = String.valueOf(playsudokuarray[0][7]);
		String SR1C9 = String.valueOf(playsudokuarray[0][8]);

		String SR2C1 = String.valueOf(playsudokuarray[1][0]);
		String SR2C2 = String.valueOf(playsudokuarray[1][1]);
		String SR2C3 = String.valueOf(playsudokuarray[1][2]);
		String SR2C4 = String.valueOf(playsudokuarray[1][3]);
		String SR2C5 = String.valueOf(playsudokuarray[1][4]);
		String SR2C6 = String.valueOf(playsudokuarray[1][5]);
		String SR2C7 = String.valueOf(playsudokuarray[1][6]);
		String SR2C8 = String.valueOf(playsudokuarray[1][7]);
		String SR2C9 = String.valueOf(playsudokuarray[1][8]);

		String SR3C1 = String.valueOf(playsudokuarray[2][0]);
		String SR3C2 = String.valueOf(playsudokuarray[2][1]);
		String SR3C3 = String.valueOf(playsudokuarray[2][2]);
		String SR3C4 = String.valueOf(playsudokuarray[2][3]);
		String SR3C5 = String.valueOf(playsudokuarray[2][4]);
		String SR3C6 = String.valueOf(playsudokuarray[2][5]);
		String SR3C7 = String.valueOf(playsudokuarray[2][6]);
		String SR3C8 = String.valueOf(playsudokuarray[2][7]);
		String SR3C9 = String.valueOf(playsudokuarray[2][8]);

		String SR4C1 = String.valueOf(playsudokuarray[3][0]);
		String SR4C2 = String.valueOf(playsudokuarray[3][1]);
		String SR4C3 = String.valueOf(playsudokuarray[3][2]);
		String SR4C4 = String.valueOf(playsudokuarray[3][3]);
		String SR4C5 = String.valueOf(playsudokuarray[3][4]);
		String SR4C6 = String.valueOf(playsudokuarray[3][5]);
		String SR4C7 = String.valueOf(playsudokuarray[3][6]);
		String SR4C8 = String.valueOf(playsudokuarray[3][7]);
		String SR4C9 = String.valueOf(playsudokuarray[3][8]);

		String SR5C1 = String.valueOf(playsudokuarray[4][0]);
		String SR5C2 = String.valueOf(playsudokuarray[4][1]);
		String SR5C3 = String.valueOf(playsudokuarray[4][2]);
		String SR5C4 = String.valueOf(playsudokuarray[4][3]);
		String SR5C5 = String.valueOf(playsudokuarray[4][4]);
		String SR5C6 = String.valueOf(playsudokuarray[4][5]);
		String SR5C7 = String.valueOf(playsudokuarray[4][6]);
		String SR5C8 = String.valueOf(playsudokuarray[4][7]);
		String SR5C9 = String.valueOf(playsudokuarray[4][8]);

		String SR6C1 = String.valueOf(playsudokuarray[5][0]);
		String SR6C2 = String.valueOf(playsudokuarray[5][1]);
		String SR6C3 = String.valueOf(playsudokuarray[5][2]);
		String SR6C4 = String.valueOf(playsudokuarray[5][3]);
		String SR6C5 = String.valueOf(playsudokuarray[5][4]);
		String SR6C6 = String.valueOf(playsudokuarray[5][5]);
		String SR6C7 = String.valueOf(playsudokuarray[5][6]);
		String SR6C8 = String.valueOf(playsudokuarray[5][7]);
		String SR6C9 = String.valueOf(playsudokuarray[5][8]);

		String SR7C1 = String.valueOf(playsudokuarray[6][0]);
		String SR7C2 = String.valueOf(playsudokuarray[6][1]);
		String SR7C3 = String.valueOf(playsudokuarray[6][2]);
		String SR7C4 = String.valueOf(playsudokuarray[6][3]);
		String SR7C5 = String.valueOf(playsudokuarray[6][4]);
		String SR7C6 = String.valueOf(playsudokuarray[6][5]);
		String SR7C7 = String.valueOf(playsudokuarray[6][6]);
		String SR7C8 = String.valueOf(playsudokuarray[6][7]);
		String SR7C9 = String.valueOf(playsudokuarray[6][8]);

		String SR8C1 = String.valueOf(playsudokuarray[7][0]);
		String SR8C2 = String.valueOf(playsudokuarray[7][1]);
		String SR8C3 = String.valueOf(playsudokuarray[7][2]);
		String SR8C4 = String.valueOf(playsudokuarray[7][3]);
		String SR8C5 = String.valueOf(playsudokuarray[7][4]);
		String SR8C6 = String.valueOf(playsudokuarray[7][5]);
		String SR8C7 = String.valueOf(playsudokuarray[7][6]);
		String SR8C8 = String.valueOf(playsudokuarray[7][7]);
		String SR8C9 = String.valueOf(playsudokuarray[7][8]);

		String SR9C1 = String.valueOf(playsudokuarray[8][0]);
		String SR9C2 = String.valueOf(playsudokuarray[8][1]);
		String SR9C3 = String.valueOf(playsudokuarray[8][2]);
		String SR9C4 = String.valueOf(playsudokuarray[8][3]);
		String SR9C5 = String.valueOf(playsudokuarray[8][4]);
		String SR9C6 = String.valueOf(playsudokuarray[8][5]);
		String SR9C7 = String.valueOf(playsudokuarray[8][6]);
		String SR9C8 = String.valueOf(playsudokuarray[8][7]);
		String SR9C9 = String.valueOf(playsudokuarray[8][8]);

		R1C1.setText(SR1C1);
		R1C2.setText(SR1C2);
		R1C3.setText(SR1C3);
		R1C4.setText(SR1C4);
		R1C5.setText(SR1C5);
		R1C6.setText(SR1C6);
		R1C7.setText(SR1C7);
		R1C8.setText(SR1C8);
		R1C9.setText(SR1C9);

		R2C1.setText(SR2C1);
		R2C2.setText(SR2C2);
		R2C3.setText(SR2C3);
		R2C4.setText(SR2C4);
		R2C5.setText(SR2C5);
		R2C6.setText(SR2C6);
		R2C7.setText(SR2C7);
		R2C8.setText(SR2C8);
		R2C9.setText(SR2C9);

		R3C1.setText(SR3C1);
		R3C2.setText(SR3C2);
		R3C3.setText(SR3C3);
		R3C4.setText(SR3C4);
		R3C5.setText(SR3C5);
		R3C6.setText(SR3C6);
		R3C7.setText(SR3C7);
		R3C8.setText(SR3C8);
		R3C9.setText(SR3C9);

		R4C1.setText(SR4C1);
		R4C2.setText(SR4C2);
		R4C3.setText(SR4C3);
		R4C4.setText(SR4C4);
		R4C5.setText(SR4C5);
		R4C6.setText(SR4C6);
		R4C7.setText(SR4C7);
		R4C8.setText(SR4C8);
		R4C9.setText(SR4C9);

		R5C1.setText(SR5C1);
		R5C2.setText(SR5C2);
		R5C3.setText(SR5C3);
		R5C4.setText(SR5C4);
		R5C5.setText(SR5C5);
		R5C6.setText(SR5C6);
		R5C7.setText(SR5C7);
		R5C8.setText(SR5C8);
		R5C9.setText(SR5C9);

		R6C1.setText(SR6C1);
		R6C2.setText(SR6C2);
		R6C3.setText(SR6C3);
		R6C4.setText(SR6C4);
		R6C5.setText(SR6C5);
		R6C6.setText(SR6C6);
		R6C7.setText(SR6C7);
		R6C8.setText(SR6C8);
		R6C9.setText(SR6C9);

		R7C1.setText(SR7C1);
		R7C2.setText(SR7C2);
		R7C3.setText(SR7C3);
		R7C4.setText(SR7C4);
		R7C5.setText(SR7C5);
		R7C6.setText(SR7C6);
		R7C7.setText(SR7C7);
		R7C8.setText(SR7C8);
		R7C9.setText(SR7C9);

		R8C1.setText(SR8C1);
		R8C2.setText(SR8C2);
		R8C3.setText(SR8C3);
		R8C4.setText(SR8C4);
		R8C5.setText(SR8C5);
		R8C6.setText(SR8C6);
		R8C7.setText(SR8C7);
		R8C8.setText(SR8C8);
		R8C9.setText(SR8C9);

		R9C1.setText(SR9C1);
		R9C2.setText(SR9C2);
		R9C3.setText(SR9C3);
		R9C4.setText(SR9C4);
		R9C5.setText(SR9C5);
		R9C6.setText(SR9C6);
		R9C7.setText(SR9C7);
		R9C8.setText(SR9C8);
		R9C9.setText(SR9C9);

	}

	public static void SoloutionDesignation() {

		//Assigns the 81 JLabels all values of array (puzzle solution).
		
		String SR1C1 = String.valueOf(sudokuarraysolution[0][0]);
		String SR1C2 = String.valueOf(sudokuarraysolution[0][1]);
		String SR1C3 = String.valueOf(sudokuarraysolution[0][2]);
		String SR1C4 = String.valueOf(sudokuarraysolution[0][3]);
		String SR1C5 = String.valueOf(sudokuarraysolution[0][4]);
		String SR1C6 = String.valueOf(sudokuarraysolution[0][5]);
		String SR1C7 = String.valueOf(sudokuarraysolution[0][6]);
		String SR1C8 = String.valueOf(sudokuarraysolution[0][7]);
		String SR1C9 = String.valueOf(sudokuarraysolution[0][8]);

		String SR2C1 = String.valueOf(sudokuarraysolution[1][0]);
		String SR2C2 = String.valueOf(sudokuarraysolution[1][1]);
		String SR2C3 = String.valueOf(sudokuarraysolution[1][2]);
		String SR2C4 = String.valueOf(sudokuarraysolution[1][3]);
		String SR2C5 = String.valueOf(sudokuarraysolution[1][4]);
		String SR2C6 = String.valueOf(sudokuarraysolution[1][5]);
		String SR2C7 = String.valueOf(sudokuarraysolution[1][6]);
		String SR2C8 = String.valueOf(sudokuarraysolution[1][7]);
		String SR2C9 = String.valueOf(sudokuarraysolution[1][8]);

		String SR3C1 = String.valueOf(sudokuarraysolution[2][0]);
		String SR3C2 = String.valueOf(sudokuarraysolution[2][1]);
		String SR3C3 = String.valueOf(sudokuarraysolution[2][2]);
		String SR3C4 = String.valueOf(sudokuarraysolution[2][3]);
		String SR3C5 = String.valueOf(sudokuarraysolution[2][4]);
		String SR3C6 = String.valueOf(sudokuarraysolution[2][5]);
		String SR3C7 = String.valueOf(sudokuarraysolution[2][6]);
		String SR3C8 = String.valueOf(sudokuarraysolution[2][7]);
		String SR3C9 = String.valueOf(sudokuarraysolution[2][8]);

		String SR4C1 = String.valueOf(sudokuarraysolution[3][0]);
		String SR4C2 = String.valueOf(sudokuarraysolution[3][1]);
		String SR4C3 = String.valueOf(sudokuarraysolution[3][2]);
		String SR4C4 = String.valueOf(sudokuarraysolution[3][3]);
		String SR4C5 = String.valueOf(sudokuarraysolution[3][4]);
		String SR4C6 = String.valueOf(sudokuarraysolution[3][5]);
		String SR4C7 = String.valueOf(sudokuarraysolution[3][6]);
		String SR4C8 = String.valueOf(sudokuarraysolution[3][7]);
		String SR4C9 = String.valueOf(sudokuarraysolution[3][8]);

		String SR5C1 = String.valueOf(sudokuarraysolution[4][0]);
		String SR5C2 = String.valueOf(sudokuarraysolution[4][1]);
		String SR5C3 = String.valueOf(sudokuarraysolution[4][2]);
		String SR5C4 = String.valueOf(sudokuarraysolution[4][3]);
		String SR5C5 = String.valueOf(sudokuarraysolution[4][4]);
		String SR5C6 = String.valueOf(sudokuarraysolution[4][5]);
		String SR5C7 = String.valueOf(sudokuarraysolution[4][6]);
		String SR5C8 = String.valueOf(sudokuarraysolution[4][7]);
		String SR5C9 = String.valueOf(sudokuarraysolution[4][8]);

		String SR6C1 = String.valueOf(sudokuarraysolution[5][0]);
		String SR6C2 = String.valueOf(sudokuarraysolution[5][1]);
		String SR6C3 = String.valueOf(sudokuarraysolution[5][2]);
		String SR6C4 = String.valueOf(sudokuarraysolution[5][3]);
		String SR6C5 = String.valueOf(sudokuarraysolution[5][4]);
		String SR6C6 = String.valueOf(sudokuarraysolution[5][5]);
		String SR6C7 = String.valueOf(sudokuarraysolution[5][6]);
		String SR6C8 = String.valueOf(sudokuarraysolution[5][7]);
		String SR6C9 = String.valueOf(sudokuarraysolution[5][8]);

		String SR7C1 = String.valueOf(sudokuarraysolution[6][0]);
		String SR7C2 = String.valueOf(sudokuarraysolution[6][1]);
		String SR7C3 = String.valueOf(sudokuarraysolution[6][2]);
		String SR7C4 = String.valueOf(sudokuarraysolution[6][3]);
		String SR7C5 = String.valueOf(sudokuarraysolution[6][4]);
		String SR7C6 = String.valueOf(sudokuarraysolution[6][5]);
		String SR7C7 = String.valueOf(sudokuarraysolution[6][6]);
		String SR7C8 = String.valueOf(sudokuarraysolution[6][7]);
		String SR7C9 = String.valueOf(sudokuarraysolution[6][8]);

		String SR8C1 = String.valueOf(sudokuarraysolution[7][0]);
		String SR8C2 = String.valueOf(sudokuarraysolution[7][1]);
		String SR8C3 = String.valueOf(sudokuarraysolution[7][2]);
		String SR8C4 = String.valueOf(sudokuarraysolution[7][3]);
		String SR8C5 = String.valueOf(sudokuarraysolution[7][4]);
		String SR8C6 = String.valueOf(sudokuarraysolution[7][5]);
		String SR8C7 = String.valueOf(sudokuarraysolution[7][6]);
		String SR8C8 = String.valueOf(sudokuarraysolution[7][7]);
		String SR8C9 = String.valueOf(sudokuarraysolution[7][8]);

		String SR9C1 = String.valueOf(sudokuarraysolution[8][0]);
		String SR9C2 = String.valueOf(sudokuarraysolution[8][1]);
		String SR9C3 = String.valueOf(sudokuarraysolution[8][2]);
		String SR9C4 = String.valueOf(sudokuarraysolution[8][3]);
		String SR9C5 = String.valueOf(sudokuarraysolution[8][4]);
		String SR9C6 = String.valueOf(sudokuarraysolution[8][5]);
		String SR9C7 = String.valueOf(sudokuarraysolution[8][6]);
		String SR9C8 = String.valueOf(sudokuarraysolution[8][7]);
		String SR9C9 = String.valueOf(sudokuarraysolution[8][8]);

		R1C1.setText(SR1C1);
		R1C2.setText(SR1C2);
		R1C3.setText(SR1C3);
		R1C4.setText(SR1C4);
		R1C5.setText(SR1C5);
		R1C6.setText(SR1C6);
		R1C7.setText(SR1C7);
		R1C8.setText(SR1C8);
		R1C9.setText(SR1C9);

		R2C1.setText(SR2C1);
		R2C2.setText(SR2C2);
		R2C3.setText(SR2C3);
		R2C4.setText(SR2C4);
		R2C5.setText(SR2C5);
		R2C6.setText(SR2C6);
		R2C7.setText(SR2C7);
		R2C8.setText(SR2C8);
		R2C9.setText(SR2C9);

		R3C1.setText(SR3C1);
		R3C2.setText(SR3C2);
		R3C3.setText(SR3C3);
		R3C4.setText(SR3C4);
		R3C5.setText(SR3C5);
		R3C6.setText(SR3C6);
		R3C7.setText(SR3C7);
		R3C8.setText(SR3C8);
		R3C9.setText(SR3C9);

		R4C1.setText(SR4C1);
		R4C2.setText(SR4C2);
		R4C3.setText(SR4C3);
		R4C4.setText(SR4C4);
		R4C5.setText(SR4C5);
		R4C6.setText(SR4C6);
		R4C7.setText(SR4C7);
		R4C8.setText(SR4C8);
		R4C9.setText(SR4C9);

		R5C1.setText(SR5C1);
		R5C2.setText(SR5C2);
		R5C3.setText(SR5C3);
		R5C4.setText(SR5C4);
		R5C5.setText(SR5C5);
		R5C6.setText(SR5C6);
		R5C7.setText(SR5C7);
		R5C8.setText(SR5C8);
		R5C9.setText(SR5C9);

		R6C1.setText(SR6C1);
		R6C2.setText(SR6C2);
		R6C3.setText(SR6C3);
		R6C4.setText(SR6C4);
		R6C5.setText(SR6C5);
		R6C6.setText(SR6C6);
		R6C7.setText(SR6C7);
		R6C8.setText(SR6C8);
		R6C9.setText(SR6C9);

		R7C1.setText(SR7C1);
		R7C2.setText(SR7C2);
		R7C3.setText(SR7C3);
		R7C4.setText(SR7C4);
		R7C5.setText(SR7C5);
		R7C6.setText(SR7C6);
		R7C7.setText(SR7C7);
		R7C8.setText(SR7C8);
		R7C9.setText(SR7C9);

		R8C1.setText(SR8C1);
		R8C2.setText(SR8C2);
		R8C3.setText(SR8C3);
		R8C4.setText(SR8C4);
		R8C5.setText(SR8C5);
		R8C6.setText(SR8C6);
		R8C7.setText(SR8C7);
		R8C8.setText(SR8C8);
		R8C9.setText(SR8C9);

		R9C1.setText(SR9C1);
		R9C2.setText(SR9C2);
		R9C3.setText(SR9C3);
		R9C4.setText(SR9C4);
		R9C5.setText(SR9C5);
		R9C6.setText(SR9C6);
		R9C7.setText(SR9C7);
		R9C8.setText(SR9C8);
		R9C9.setText(SR9C9);

	}

	public static void TitleScreen() {

		titlepan.setBounds(0, 0, 1280, 720);
		titlepan.setBackground(new Color(153, 136, 112));
		titlepan.setLayout(null);
		maincontainer.add(titlepan);
		titlepan.setVisible(false);

		JLabel tlabel = new JLabel("Infinite Sudoku", SwingConstants.CENTER);
		titlepan.add(tlabel);
		tlabel.setFont(titlefont);
		tlabel.setBounds(20, 200, 1240, 200);

		JLabel tlabel2 = new JLabel("Charles Henville        ICS4U1        January 2022", SwingConstants.CENTER);
		titlepan.add(tlabel2);
		tlabel2.setFont(minititlefont);
		tlabel2.setBounds(20, 260, 1240, 200);

		begin.setFont(minititlefont);
		titlepan.add(begin);
		begin.setBounds(600, 400, 80, 40);

	}

	public static void calculateScore() {

		score = 1000000 - m * 16667 - t * 278;

		if (score < 0) {
			score = 0;
		}

	}

	public static void TitleScreenVisible() {

		titlepan.setVisible(true);

	}

	public static boolean checkPlayerSolution() {

		// scans player solution for errors (rows only since original puzzle has already been verified)
		
		int placeholder1 = 0;
		String placeholder0;
		
		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				if (playsudokuarray[i][j] == ' ') {
					placeholder1 = 0;
				}

				else {
					placeholder0 = String.valueOf(playsudokuarray[i][j]);

					System.out.println(placeholder0);

					placeholder1 = Integer.parseInt(placeholder0) + placeholder1;
				}

			}

			System.out.println(placeholder1);
			if (placeholder1 == 45) {

				placeholder1 = 0;
				continue;
			} else {
				return false;
			}
		}
		return true;

	}
}
