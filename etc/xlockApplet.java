// Charles Vidal <cvidal AT ivsweb.com>
// Updated by David Bagley 

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class xlockApplet extends Applet implements ItemListener {
	private static final long serialVersionUID = 42L;
	Button launchButton;
	Button launchInWinButton;
	Button quitButton;
	Choice choice;
	TextField textField;
	List list;
	int currentOption = 0;
	ErrorFrame errorFrame;

	// Array of option name
	String[] descriptOptions = {
		"Display",
		"Geometry",
		"Message Password",
		"Message Valid",
		"Message Invalid",
		"Font",
		"Program for mode",
		"File for mode",
		"Misc. Option"
	};

	String[] valueOptions = {"","","","","","","","",""};
	String[] cmdlineOptions = {
		"-display",
		"-geometry",
		"-password",
		"-validate",
		"-invalid",
		"-font",
		"-program",
		"-messagefile",
		""
	};
	String[] booleanOptions = {
		"-mono ",
		"-nolock ",
		"-remote ",
		"-allowroot ",
		"-enablesaver ",
		"-allowaccess ",
		"-grabmouse ",
		"-echokeys ",
		"-usefirst ",
		"-debug ",
		"-verbose ",
		"-inroot ",
		"-timeelapsed ",
		"-install ",
		"-wireframe ",
		"-showfps ",
		"-use3d "
	};
	Checkbox checkbox[] = new Checkbox[booleanOptions.length];
	final Runtime r = Runtime.getRuntime();

	public void init() {
		Panel Panel1 = new Panel();
		Panel Panel2 = new Panel();
		Panel Panel3 = new Panel();

		setLayout(new BorderLayout(10, 10));
		list = new List();
		choice = new Choice();
		for (int i = 0; i < descriptOptions.length; i++)
			choice.add(descriptOptions[i]);
		Panel3.add(choice);
		textField = new TextField(20);
		Panel3.add(textField);
		add("North", Panel3);
		add("Center", list);
		lst.add("anemone");
		lst.add("ant");
		lst.add("ant3d");
		lst.add("apollonian");
		lst.add("atlantis");
		lst.add("atunnels");
		lst.add("ball");
		lst.add("bat");
		lst.add("blot");
		lst.add("bouboule");
		lst.add("bounce");
		lst.add("braid");
		lst.add("bubble");
		lst.add("bubble3d");
		lst.add("bug");
		lst.add("cage");
		lst.add("clock");
		lst.add("coral");
		lst.add("crystal");
		lst.add("daisy");
		lst.add("dclock");
		lst.add("decay");
		lst.add("deco");
		lst.add("demon");
		lst.add("dilemma");
		lst.add("discrete");
		lst.add("dragon");
		lst.add("drift");
		lst.add("euler2d");
		lst.add("eyes");
		lst.add("fadeplot");
		lst.add("fiberlamp");
		lst.add("fire");
		lst.add("flag");
		lst.add("flame");
		lst.add("flow");
		lst.add("forest");
		lst.add("fzort");
		lst.add("galaxy");
		lst.add("gears");
		lst.add("glplanet");
		lst.add("goop");
		lst.add("grav");
		lst.add("helix");
		lst.add("hop");
		lst.add("hyper");
		lst.add("ico");
		lst.add("ifs");
		lst.add("image");
		lst.add("invert");
		lst.add("juggle");
		lst.add("juggler3d");
		lst.add("julia");
		lst.add("kaleid");
		lst.add("kumppa");
		lst.add("lament");
		lst.add("laser");
		lst.add("life");
		lst.add("life1d");
		lst.add("life3d");
		lst.add("lightning");
		lst.add("lisa");
		lst.add("lissie");
		lst.add("loop");
		lst.add("lyapunov");
		lst.add("mandelbrot");
		lst.add("marquee");
		lst.add("matrix");
		lst.add("maze");
		lst.add("moebius");
		lst.add("molecule");
		lst.add("morph3d");
		lst.add("mountain");
		lst.add("munch");
		lst.add("noof");
		lst.add("nose");
		lst.add("pacman");
		lst.add("penrose");
		lst.add("petal");
		lst.add("petri");
		lst.add("pipes");
		lst.add("polyominoes");
		lst.add("puzzle");
		lst.add("pyro");
		lst.add("pyro2");
		lst.add("qix");
		lst.add("rain");
		lst.add("roll");
		lst.add("rotor");
		lst.add("rubik");
		lst.add("sballs");
		lst.add("scooter");
		lst.add("shape");
		lst.add("sierpinski");
		lst.add("sierpinski3d");
		lst.add("skewb");
		lst.add("slip");
		lst.add("solitaire");
		lst.add("space");
		lst.add("sphere");
		lst.add("spiral");
		lst.add("spline");
		lst.add("sproingies");
		lst.add("stairs");
		lst.add("star");
		lst.add("starfish");
		lst.add("strange");
		lst.add("superquadrics");
		lst.add("swarm");
		lst.add("swirl");
		lst.add("t3d");
		lst.add("tetris");
		lst.add("text3d");
		lst.add("text3d2");
		lst.add("thornbird");
		lst.add("tik_tak");
		lst.add("toneclock");
		lst.add("triangle");
		lst.add("tube");
		lst.add("turtle");
		lst.add("vines");
		lst.add("voters");
		lst.add("wator");
		lst.add("wire");
		lst.add("world");
		lst.add("worm");
		lst.add("xcl");
		lst.add("xjack");
		lst.add("blank");
		list.add("bomb");
		list.add("random");
		list.select(0);
		add("East", Panel1);
		Panel1.setLayout(new GridLayout(booleanOptions.length,  1));
		for (int i = 0; i < booleanOptions.length; i++) {
			checkbox[i] = new Checkbox(booleanOptions[i],
				null, false);
			Panel1.add(checkbox[i]);
		}
		add("South", Panel2);
		launchButton = new Button("Launch");
		launchInWinButton = new Button("Launch in Window");
		quitButton = new Button("Quit");
		Panel2.add(launchButton);
		Panel2.add(launchInWinButton);
		Panel2.add(quitButton);
		errorFrame = new ErrorFrame("An error occured, can not launch xlock");
 		errorFrame.setSize(350, 150);
		choice.addItemListener(this);

		launchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				launch("xlock ");
			}
		});

		launchInWinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				launch("xlock -inwindow ");
			}
		});

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				valueOptions[currentOption] =
					textField.getText();
				System.out.println(valueOptions[currentOption]);
			}
		});

		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}

	public void itemStateChanged(ItemEvent event) {
		String label = (String) choice.getSelectedItem();

		valueOptions[currentOption] = textField.getText();
		for (int i = 0; i < descriptOptions.length; i++) {
			if (descriptOptions[i].equals(label)) {
				textField.setText(valueOptions[i]);
				currentOption = i;
			}
		}
	}

	public String getBooleanOption() {
		String result = "";
		for (int i = 0; i < booleanOptions.length; i++) {
			if (checkbox[i].getState())
				result = result.concat(booleanOptions[i]);
		}
		return (result);
	}

	private void launch(String cmd) {
		String cmdline = cmd;

		for (int i = 0; i < descriptOptions.length; i++) {
			if (!valueOptions[i].equals("")) {
				cmdline =
					cmdline.concat(cmdlineOptions[i] + " " +
					valueOptions[i] + " ");
			}
		}
		cmdline = cmdline.concat(getBooleanOption());
		cmdline = cmdline.concat("-mode ");
		cmdline = cmdline.concat(list.getSelectedItem());
		try {
			System.out.println(cmdline);
			r.getRuntime().exec(cmdline);
		} catch (Exception e) {
			errorFrame.setVisible(true);
		}
	}

	public xlockApplet() {
	}

	public static void main(String args[]) {
		Frame frame = new Frame("xlock");
		xlockApplet applet = new xlockApplet();
		WindowListener listener = new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		};
		frame.addWindowListener(listener);
		applet.init();
		frame.add("Center", applet);
		frame.setSize(350, 400);
		frame.setVisible(true);
	}
}

class ErrorFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 42L;
	Label label;
	Button button;
	ErrorFrame(String error) {
		setLayout(new BorderLayout());
		label = new Label(error, Label.CENTER);
		add("Center", label);
		button = new Button("OK");
		add("South", button);
		setTitle(error);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				setVisible(false);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
	}
	public void actionPerformed(ActionEvent event) {
			setVisible(false);
	}
}
