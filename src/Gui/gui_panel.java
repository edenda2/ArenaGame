package Gui;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import game.GameEngine;
import game.arena.Arena;
import game.arena.ArenaFactory;
import game.arena.WinterArena;
import game.entities.ActivityStates.ActiveState;
import game.entities.ActivityStates.FailedState;
import game.entities.ActivityStates.InjuredState;
import game.entities.sportsman.Decorator.ColoredSportsman;
import game.entities.sportsman.Decorator.IWinterSportsman;
import game.entities.sportsman.Decorator.SpeedySportsman;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


import game.competition.*;
import utilities.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */


public class gui_panel extends JFrame implements ActionListener ,Observer{

    public static int Identif_number=0;
    private JPanel pane,pane1,pane2,pane4 ,pane5,pane6, panee;
    private JLabel first,second,third,ArenaTypee,competitionn,Maxcompetitor,discipline,league,gender,Name,Age,M_speed,Acceleration,picLabel1;
    private JTextField A_length,maxi,name,age,max_speed,acceleration;
    private JComboBox S_surface,W_condition,choiceArena,comp,disc,leag,gend;
    private JButton build,create_comp,Add_com,start_button,info;
    private JFrame frame;
    private Arena arena=null;
    private Class c,g;
    private ClassLoader cl,gl;
    private Constructor con,gon;
    private WinterSportsman Ws=null;
    private Competition create_competit=null;
    private int numraces=0;
    private ArrayList<JLabel>imageraces =new ArrayList<>();
    private ArrayList<Competitor> races=new ArrayList<>();
    private ArrayList<Competitor> copyracers=new ArrayList<>();
    private ArrayList<String> nameracers=new ArrayList<>();
    private JFrame information = null;
    private BufferedImage img;
    private int sizearena=1000;
    private ArenaFactory arenafactory=new ArenaFactory();
    private JComboBox color;
    private JLabel color_type;
    private JLabel title_races;
    private JComboBox copy_race;
    private JButton default_com;
    private BuilderCompetition compet;
    private ArrayList<Integer> injured_races=new ArrayList<>();
    private ArrayList<Integer> place_info=new ArrayList<>();
    private ArrayList<Competitor> injuredarr=new ArrayList<>();
    private JLabel titleacceleration;
    private JTextField enteracceleration;
    private JButton add_acceleration;
    private JButton add_color;
    private double len;
    private JComboBox color_change;
    private JLabel switch_color;
    private JLabel racer_list;
    private JComboBox choose_racer;
    private JTextField num_default;
    private JLabel defaultnum;
    private Timer t;
    private JDialog dialog;
    private JOptionPane panediag;
    private ActionListener closeJDialog;





    /**
     * Constructor that initialize frame and add the menu of the game by menu() method.
     */
    public gui_panel() {
        this.frame = new JFrame("Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 700));
        this.setContentPane(menu());
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * pane is panel that his size is the size of the frame.
     * pane1 is the panel that inside him there are 4 panels to each mini menu.
     * pane2 is the panel that inside him there are details of the BUILD ARENA.
     * pane4 is the panel that inside him there are details of the CREATE COMPETITION.
     * pane5 is the panel that inside him there are details of the ADD COMPETITOR.
     * pane6 isthe panel that inside him there are two button, first "Start competition" and the second is "Show info".
     * we adding the pane5 pane2 pane4 and pane6 to pane1 and pane1 add to pane.
     * @return the big panel of the frame.
     */
    public JPanel menu() {

        this.pane = new JPanel(new BorderLayout());
        pane.setPreferredSize(new Dimension(1000, 700));


        this.pane1 = new JPanel();
        pane1.setPreferredSize(new Dimension(250, 700));
        pane.setLayout(new BorderLayout());


        this.pane2 = new JPanel();

        JLabel label1 = new JLabel();
        label1.setText("<html><body><u>BUILD ARENA</u></body></html>");
        label1.setLocation(100,100);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setPreferredSize(new Dimension(190,18));
        label1.setForeground(Color.blue);
        Border lineborder = BorderFactory.createLineBorder(Color.BLACK, 1);
        pane2.add(label1);
        pane2.setBorder(lineborder);
        pane2.setPreferredSize(new Dimension(250, 145));
        //sets button in the first panel
        this.first = new JLabel("Arena length");
        this.A_length = new JTextField("700");
        A_length.addActionListener(null);
        A_length.setPreferredSize(new Dimension(90,18));
        this.second = new JLabel("Snow surface");
        this.S_surface = new JComboBox(SnowSurface.values());
        S_surface.setPreferredSize(new Dimension(90, 18));
        this.third = new JLabel("Weather condition");
        this.W_condition = new JComboBox(WeatherCondition.values());
        W_condition.setPreferredSize(new Dimension(90,18));
        this.build = new JButton("Build arena");
        build.setPreferredSize(new Dimension(120,18));
        this.build.addActionListener(this);
        this.ArenaTypee = new JLabel("Arena Type");
        String[] ArenaType = {"Winter", "Summer"};
        this.choiceArena = new JComboBox(ArenaType);
        choiceArena.setPreferredSize(new Dimension(90,18));


        this.pane4 = new JPanel();

        JLabel label2 = new JLabel();
        label2.setText("<html><body><u>CREATE COMPETITION</u></body></html>");
        label2.setForeground(Color.blue);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setPreferredSize(new Dimension(190,18));
        pane4.add(label2);
        pane4.setBorder(lineborder);
        pane4.setPreferredSize(new Dimension(250, 210));
        this.competitionn = new JLabel("Choose competition");
        this.comp = new JComboBox<String>(new String[]{"Ski", "Snowboard"});
        comp.setPreferredSize(new Dimension(90,18));
        this.Maxcompetitor = new JLabel("Max competitors number");
        this.maxi = new JTextField("10");
        maxi.setPreferredSize(new Dimension(90,18));
        this.discipline = new JLabel("Discipline");
        this.disc = new JComboBox(Discipline.values());
        disc.setPreferredSize(new Dimension(140,18));
        this.league = new JLabel("League");
        this.leag = new JComboBox(League.values());
        leag.setPreferredSize(new Dimension(155,18));
        this.gender = new JLabel("Gender");
        this.gend = new JComboBox(Gender.values());
        gend.setPreferredSize(new Dimension(120,18));
        this.default_com=new JButton("Default Competition");
        default_com.setLocation(100,100);
        default_com.setHorizontalAlignment(SwingConstants.CENTER);
        default_com.setPreferredSize(new Dimension(190,18));

        this.default_com.addActionListener(this);
        this.create_comp = new JButton("Create competition");
        create_comp.setLocation(100,100);
        create_comp.setHorizontalAlignment(SwingConstants.CENTER);
        create_comp.setPreferredSize(new Dimension(190,18));

        this.create_comp.addActionListener(this);
        num_default=new JTextField();
        defaultnum=new JLabel("racer's number");
        num_default.setPreferredSize(new Dimension(90,18));


        this.pane5 = new JPanel();
        JLabel label3 = new JLabel();
        label3.setText("<html><body><u>ADD COMPETITOR</u></body></html>");
        label3.setForeground(Color.blue);
        label3.setLocation(100,100);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setPreferredSize(new Dimension(220,18));
        pane5.add(label3);
        pane5.setBorder(lineborder);
        pane5.setPreferredSize(new Dimension(250, 280));
        this.Name = new JLabel("Name");
        this.name = new JTextField();
        name.setPreferredSize(new Dimension(180,16));
        this.Age = new JLabel("Age");
        this.age = new JTextField();
        age.setPreferredSize(new Dimension(160,16));
        this.M_speed = new JLabel("Max speed");
        this.max_speed = new JTextField();
        max_speed.setPreferredSize(new Dimension(140,16));
        this.Acceleration = new JLabel("Acceleration");
        this.acceleration = new JTextField();
        acceleration.setPreferredSize(new Dimension(140,16));
        this.color_type = new JLabel("color");
        color_type.setHorizontalAlignment(SwingConstants.CENTER);
        String[] ColorType = {"Black", "Yellow","Green","Blue","Pink"};
        this.color= new JComboBox(ColorType);
        color.setPreferredSize(new Dimension(170,16));
        this.title_races=new JLabel("racers");
        nameracers.add("");
        this.copy_race=new JComboBox(nameracers.toArray());
        copy_race.setPreferredSize(new Dimension(90,16));
        this.titleacceleration=new JLabel("acceleration");
        this.enteracceleration=new JTextField();
        enteracceleration.setPreferredSize(new Dimension(140,16));
        this.add_acceleration=new JButton("change acceleration");
        add_acceleration.setLocation(100,100);
        add_acceleration.setHorizontalAlignment(SwingConstants.CENTER);
        add_acceleration.setPreferredSize(new Dimension(170,16));
        add_acceleration.addActionListener(this);
        this.add_color=new JButton("change color");
        add_color.setLocation(100,100);
        add_color.setHorizontalAlignment(SwingConstants.CENTER);
        add_color.setPreferredSize(new Dimension(140,16));
        add_color.addActionListener(this);
        this.Add_com = new JButton("Add competitor");
        Add_com.setLocation(100,100);
        Add_com.setHorizontalAlignment(SwingConstants.CENTER);
        Add_com.setPreferredSize(new Dimension(140,16));
        Add_com.addActionListener(this);
        switch_color=new JLabel("new color");
        color_change=new JComboBox(ColorType);
        color_change.setPreferredSize(new Dimension(150,16));
        racer_list=new JLabel("racers in competition");
        choose_racer=new JComboBox(nameracers.toArray());
        choose_racer.setPreferredSize(new Dimension(90,16));


        this.pane6 = new JPanel();
        pane6.setBorder(lineborder);

        pane6.setPreferredSize(new Dimension(250, 50));
        this.start_button = new JButton("Start competition");
        this.start_button.addActionListener(this);

        this.info = new JButton("Show info");
        this.info.addActionListener(this);

        this.pane6.add(start_button);
        this.pane6.add(info);

        this.pane2.add(first);
        this.pane2.add(A_length);
        this.pane2.add(second);
        this.pane2.add(S_surface);
        this.pane2.add(third);
        this.pane2.add(W_condition);
        this.pane2.add(ArenaTypee);
        this.pane2.add(choiceArena);
        this.pane2.add(build);


        this.pane4.add(competitionn);
        this.pane4.add(comp);
        this.pane4.add(Maxcompetitor);
        this.pane4.add(maxi);
        this.pane4.add(discipline);
        this.pane4.add(disc);
        this.pane4.add(league);
        this.pane4.add(leag);
        this.pane4.add(gender);
        this.pane4.add(gend);
        this.pane4.add(create_comp);
        this.pane4.add(defaultnum);
        this.pane4.add(num_default);
        this.pane4.add(default_com);

        this.pane5.add(Name);
        this.pane5.add(name);
        this.pane5.add(Age);
        this.pane5.add(age);
        this.pane5.add(M_speed);
        this.pane5.add(max_speed);
        this.pane5.add(Acceleration);
        this.pane5.add(acceleration);
        this.pane5.add(color_type);
        this.pane5.add(color);
        this.pane5.add(title_races);
        this.pane5.add(copy_race);
        this.pane5.add(Add_com);
        this.pane5.add(racer_list);
        this.pane5.add(choose_racer);
        this.pane5.add(switch_color);
        this.pane5.add(color_change);
        this.pane5.add(titleacceleration);
        this.pane5.add(enteracceleration);
        this.pane5.add(add_acceleration);
        this.pane5.add(add_color);

        this.pane1.add(pane2);
        this.pane1.add(pane4);
        this.pane1.add(pane5);
        this.pane1.add(pane6);

        
        this.pane.add(pane1, BorderLayout.EAST);
        return pane;
    }

    /**
     * getter's
     * @return the len of the arena
     */
    public double getLen(){
        return this.len;
    }

    /**
     * random the place the injured competitor will stop
     * @return place
     */
    public double destiny_place(){
        double min=350;
        double max=getLen();
        Random random=new Random();
        double num= random.nextDouble()*((max-min)+1)+min;
        return num;
    }

    /**
     * checking if we are in competition
     * @return true if we are already in competition, else false
     */
    public boolean iaActiveCompetitor(){
        for (int i=0; i<numraces;i++){
            if (!((WinterSportsman)races.get(i)).finished()&& races.get(i).getLocation().getY()!=0){
                return true;
            }
        }
        return false;
    }

    /**
     * random 1-active, 2-injured
     * @return random num between 1-2
     */
    public int destiny(){
        int min=1;
        int max=2;
        Random random=new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * set the state according the num that return in the function destiny()
     * @param racer
     * @param state
     */
    public void change_state(WinterSportsman racer, int state){

        switch (state){
            case 1:
                racer.setActivityState(new ActiveState(racer));
                break;
            case 2:
                    racer.setActivityState(new InjuredState(racer));

                break;
            default:
                break;
        }

    }

    /**
     * choose the image of racer by his type and his color
     * @param color1
     * @param type_competition
     */
    public void update_imageracer(String color1, String type_competition){

        String image_racer;

        switch (color1){
            case "Black":
                image_racer="icons\\"+type_competition+"black.png";
                break;

            case "Yellow":
                image_racer="icons\\"+type_competition+"yellow.png";

                break;

            case "Green":
                image_racer="icons\\"+type_competition+"green.png";

                break;

            case "Blue":
                image_racer="icons\\"+type_competition+"blue.png";

                break;

            case "Pink":
                image_racer="icons\\"+type_competition+"pink.png";

                break;
                default:
                    image_racer=null;
        }
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(image_racer).getImage()
                .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        this.picLabel1 = new JLabel(imageIcon1);
        this.imageraces.add(picLabel1);
        this.panee.add(picLabel1);



    }

    /**
     * check which place the competitor need to be in the info table
     * @param place
     * @return place(in the table)
     */
    public int help_info(double place, ArrayList<Double> f){

        int count=0;
        for (int i=0;i<f.size();i++){
            if (f.get(i)>=place){
                count++;
            }
        }
        return count;
    }

    /**
     * paint the JPanel with picture and add it to pane.
     */
    public void update_backgrount(){
        this.panee = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0)) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        panee.setSize(sizearena,(int) getLen());
        pane.add(panee);
    }


    /**
     * e is the message the function get, and its help us to know to which case we need to choose.
     * this function wait for the user partition.
     * "Build arena":
     * first Checking if we in the middle of the competition.
     * take the details that the user enter and we send it to WinterArena constructor.(we also check if the length of the arena is valid, between 700-900)
     * Depending on the weather, we're putting the picture
     * we using here with the Factory DP
     * "Create competition":
     * first Checking if we in the middle of the competition.
     * second we check if we build arena before
     * next we remove the panel with the image and put new panel with image in the main panel(pane).(its help us to put new image when we want to start a new competition)
     * Taking the details introduced by the user and building using the Dynamic class object.
     * we also increasing the size of the frame and the panel according the max number of competitors.
     * "Add competitor"
     * first Checking if we in the middle of the competition.
     * second we check if we build competition.
     * next we check if the user want to copy racer or to create new competitor.
     * if we create new competitor so we taking the details introduced by the user and building using the Dynamic class object.
     * we check if the user want female or male competitor and we adding the image of the competitor to ArrayList of image and the object we add to Array List from type Wintersportsman.
     * and we increase the value of the num races.
     * if we want to copy we get the id racer and search him in the array copy.
     * we check if the type of racer natch to the type of the competition
     * then we took the racer we want to copy and do to him Prototype and adding to array copy and array racer
     * and we increase the value of the num races.
     * "Start competition":
     * first we check if we add competitor and we create competition and arena.
     * then We make a lottery on the competitors (who will be injured and who is active)
     * putting the injured in array.(its help us in the "show info" to show who is injured competitor)
     * and we playing the game.
     * "Show info":
     * we create new frame to present the info about all the competitor that playing in the competition.
     * "Default Competition":
     * when the user push on this button the program make a default competition by using Builder PD
     * first Checking if we in the middle of the competition.
     * take the details that the user enter and we send it to the Builder constructor.
     * then we adding image racers to the screen according to the racers array.
     * "change acceleration":
     * first Checking if we in the middle of the competition.
     * we getting the racer we want to change hin acceleration by search in the array recers
     * then build new SpeedySportsman object and called to function makeiWintersportsman to change the acceleration
     * "change color":
     * first Checking if we in the middle of the competition.
     * we getting the racer we want to change hin color by search in the array recers
     * then build new ColoredSportsman object and called to function makeiWintersportsman to change the color
     * next we repaint the screen and adding the images racers.
     * @param e (send to)
     */
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Build arena":
                if (iaActiveCompetitor()){
                    JOptionPane.showMessageDialog(this, "Competition has already begun");
                    return;
                }
                String text = A_length.getText();
                len = Double.parseDouble(text);

                try {
                    if (getLen() < 700 || getLen() > 900) {
                        throw new IllegalArgumentException();
                    }
                    String text1 = (String) W_condition.getSelectedItem().toString();
                    switch (text1) {
                        case "SUNNY":
                            img = ImageIO.read(new File("icons\\Sunny.jpg"));
                            break;
                        case "CLOUDY":
                            img = ImageIO.read(new File("icons\\Cloudy.jpg"));
                            break;
                        case "STORMY":
                            img = ImageIO.read(new File("icons\\Stormy.jpg"));
                            break;
                        default:
                            img = null;

                    }
                    if (create_competit!=null){
                        pane.remove(panee);
                        pane.repaint();
                    }
                    frame.setSize(sizearena,(int) getLen()+30);
                    update_backgrount();

                    SnowSurface surface = (SnowSurface) S_surface.getSelectedItem();
                    WeatherCondition condition = (WeatherCondition) W_condition.getSelectedItem();
                    String typearena=choiceArena.getSelectedItem().toString();
                    this.arena = arenafactory.getArena(typearena, getLen(),surface,condition);
                } catch (IllegalArgumentException | IOException| ClassNotFoundException o) {
                    JOptionPane.showMessageDialog(null, "Invalid input values! Please try again", "Message"
                            , JOptionPane.ERROR_MESSAGE);
                }
                frame.setVisible(true);
                break;
            case "Create competition":
                if (iaActiveCompetitor()){
                    JOptionPane.showMessageDialog(this, "Competition has already begun");
                    return;
                }
                if (this.arena==null){
                    JOptionPane.showMessageDialog(this, "Please build arena before you create competition!.");
                    return;
                }
                    choose_racer.removeAllItems();
                    pane.remove(panee);
                    pane.repaint();
                    update_backgrount();
                    panee.setPreferredSize(new Dimension(sizearena,(int) arena.getLength()));
                    pane.setPreferredSize(new Dimension(sizearena,(int)arena.getLength()));
                    pane.add(panee);
                    //  pane.setVisible(true);
                    frame.setVisible(true);

                    create_competit=null;
                    Ws=null;

                    this.numraces=0;
                    this.races.clear();
                    this.imageraces.clear();
                    this.races=new ArrayList<>();
                    this.imageraces =new ArrayList<>();

                String text1 = maxi.getText();
                int value1 = Integer.parseInt(text1);

                try {
                    if (value1 < 1 || value1 > 20) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException o) {
                    JOptionPane.showMessageDialog(null, "Error! max competitor is 20", "Message"
                            , JOptionPane.ERROR_MESSAGE);
                }

                String competitionn = (String) comp.getSelectedItem();
                Discipline dis = (Discipline) disc.getSelectedItem();
                League leagu = (League) leag.getSelectedItem();
                Gender gen = (Gender) gend.getSelectedItem();

                try {
                    this.cl = ClassLoader.getSystemClassLoader();
                    String name_comp = "game.competition." + competitionn + "Competition";
                    c = cl.loadClass(name_comp);
                    this.con = c.getConstructor(Arena.class, int.class, Discipline.class, League.class, Gender.class);
                    this.create_competit = (Competition) con.newInstance(arena, value1, dis, leagu, gen);

                } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
                if (value1>10){
                    this.sizearena=1400;
                    pane.setSize(sizearena,(int)arena.getLength()+30);
                    frame.setSize(sizearena,(int)arena.getLength()+30);
                    frame.setVisible(true);
                }
                else {
                    this.sizearena=1000;
                    pane.setSize(sizearena,(int)arena.getLength()+30);
                    frame.setSize(sizearena, (int)arena.getLength()+30);
                    frame.setVisible(true);
                }

                frame.setVisible(true);
                break;

            case "Add competitor":
                if (iaActiveCompetitor()){
                    JOptionPane.showMessageDialog(this, "Competition has already begun");
                    return;
                }

                if (this.create_competit==null){
                    JOptionPane.showMessageDialog(this, "Please create competition before you adding competitor!.");
                    return;
                }
                if(numraces==create_competit.getMaxComp()) {
                    JOptionPane.showMessageDialog(this, "The competition is full!");
                    return;
                }
                String name_num;
                String names = (String) this.name.getText();
                String ages = (String) this.age.getText();
                String max_speed_str = (String) this.max_speed.getText();
                String acceleration_str = (String) this.acceleration.getText();
                String colorr=(String) this.color.getSelectedItem();
               
                /*
                ֳ—ג€˜ֳ—ג€¢ֳ—ג€�ֳ—ֲ§ ֳ—ן¿½ֳ—ן¿½ ֳ—ֲ¦ֳ—ֲ¨ֳ—ג„¢ֳ—ג€÷ֳ—ג„¢ֳ—ן¿½ ֳ—ֵ“ֳ—ֲ¢ֳ—ֲ©ֳ—ג€¢ֳ—ֲ× ֳ—ג€�ֳ—ֲ¢ֳ—ֲ×ֳ—ֲ§ ֳ—ֲ©ֳ—ֵ“ ֳ—ג€�ֳ—ֵ¾ֳ—ֲ×ֳ—ג€”ֳ—ֲ¨ֳ—ג€� ֳ—ן¿½ֳ—ג€¢ ֳ—ֵ“ֳ—ן¿½.
                 */
                
                
                String copy=copy_race.getSelectedItem().toString();
                if ((names.equals("") || ages.equals("") || max_speed_str.equals("") || acceleration_str.equals("")) && copy.equals("") ){
                    JOptionPane.showMessageDialog(this, "Please fill all the fields!");
                    return;
                }
                if (!copy.equals("")){
                    char [] str=new char[copy.length()];
                    for (int i=0;i<copy.length();i++){
                        if (copy.charAt(i)==' '){
                            break;
                        }
                        str[i]=copy.charAt(i);
                    }
                    String string=new String(str);
                    double num1 = Double.parseDouble(string);
                    int num=(int)num1;
                    ArrayList<Competitor> tmp = new ArrayList<>(this.copyracers);
                    for (Competitor comp: tmp){
                        if (comp instanceof WinterSportsman){
                            WinterSportsman competitor=(WinterSportsman)comp;
                            if (competitor.getNumberCount()==num){
                                if (competitor instanceof Skier){
                                    if (!create_competit.nameClass().equals("SkiCompetition")){
                                        JOptionPane.showMessageDialog(this, "The type of competitor is not good!");
                                        return;
                                    }
         

                                    try {
                                    	if(create_competit.isValidCompetitor(competitor)!=true)
                                    	{
                                    		JOptionPane.showMessageDialog(this, "Invalid competitor! Please choose another one");
                                            return;
                                    	}
                                    	
                                        Skier skier=(Skier) competitor.clone(colorr);
                                        update_imageracer(skier.getColor(),"Ski");
                                        
                                        this.races.add(skier);
                                        this.copyracers.add(skier);
                                        name_num=skier.getNumberCount()+" "+skier.getName();
                                        choose_racer.addItem(name_num);
                                        nameracers.add(name_num);
                                        this.copy_race.addItem(name_num);
                                        this.create_competit.addCompetitor(skier);
                                        
                                        skier.addObserver(this);
                                        if (numraces != 0) {
                                            skier.setLocation(new Point(numraces * 60, skier.getLocation().getY()));
                                        }
                                        this.numraces++;
                                        
                                    } catch (IllegalArgumentException|CloneNotSupportedException  o) {
                                        JOptionPane.showMessageDialog(null, "Invalid competitor! Please choose another one", "Message"
                                                , JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                }
                                if(competitor instanceof Snowboarder){
                                   
                                    if (!create_competit.nameClass().equals("SnowboardCompetition")){
                                        JOptionPane.showMessageDialog(this, "The type of competitor is not suitable for competition");
                                        return;
                                    }

                                    try {
                                    	if(create_competit.isValidCompetitor(competitor)!=true)
                                    	{
                                    		JOptionPane.showMessageDialog(this, "Invalid competitor! Please choose another one");
                                            return;
                                    	}
                                    
                                        Snowboarder snowboarder=(Snowboarder) competitor.clone(colorr);
                                        update_imageracer(snowboarder.getColor(),"Snowboard");
                                        this.races.add(snowboarder);
                                        this.copyracers.add(snowboarder);
                                        name_num=snowboarder.getNumberCount()+" "+snowboarder.getName();
                                        choose_racer.addItem(name_num);
                                        nameracers.add(name_num);
                                        this.copy_race.addItem(name_num);
                                        this.create_competit.addCompetitor(snowboarder);
                                        
                                        snowboarder.addObserver(this);
                                        if (numraces != 0) {
                                            snowboarder.setLocation(new Point(numraces * 60, snowboarder.getLocation().getY()));
                                        }
                                        this.numraces++;
                                    } catch (IllegalArgumentException|CloneNotSupportedException  o) {
                                        JOptionPane.showMessageDialog(null, "Invalid competitor! Please choose another one", "Message"
                                                , JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                else {
                	try {
                    double ages_double = Double.parseDouble(ages);
                    double max_speed_double = Double.parseDouble(max_speed_str);
                    double acceleration_double = Double.parseDouble(acceleration_str);
                    String competitionn1 = (String) comp.getSelectedItem();
                    dis = (Discipline) disc.getSelectedItem();
                   // leagu = (League) leag.getSelectedItem();
                    gen = (Gender) gend.getSelectedItem();

                    
                        this.gl = ClassLoader.getSystemClassLoader();
                        String add_competitors = null;
                        if (competitionn1.equals("Ski")) {
                            add_competitors = "game.entities.sportsman.Skier";
                        } else {
                            add_competitors = "game.entities.sportsman.Snowboarder";

                        }
                        g = gl.loadClass(add_competitors);
                        this.gon = g.getConstructor(String.class, double.class, Gender.class, double.class, double.class, Discipline.class, Arena.class, String.class);

                        this.Ws = (WinterSportsman) gon.newInstance(names, ages_double, gen, acceleration_double, max_speed_double, dis, arena, colorr);


                        if (Ws instanceof Skier) {

                                update_imageracer(colorr,"Ski");
                                this.races.add(Ws);
                                this.copyracers.add(Ws);
                                name_num = Ws.getNumberCount() + " " + Ws.getName();
                                choose_racer.addItem(name_num);
                                nameracers.add(name_num);
                                this.copy_race.addItem(name_num);
                                this.create_competit.addCompetitor(Ws);
                                Ws.addObserver(this);

                            if (numraces != 0) {
                                this.Ws.setLocation(new Point(numraces * 60, Ws.getLocation().getY()));
                            }
                            this.numraces++;

                        }
                        if (Ws instanceof Snowboarder) {
                            update_imageracer(colorr,"Snowboard");

                            this.races.add(Ws);
                                this.copyracers.add(Ws);
                                name_num = Ws.getNumberCount() + " " + Ws.getName();
                                choose_racer.addItem(name_num);
                                nameracers.add(name_num);
                                this.copy_race.addItem(name_num);
                                this.create_competit.addCompetitor(Ws);
                                Ws.addObserver(this);
                            if (numraces != 0) {
                                this.Ws.setLocation(new Point(numraces * 60, Ws.getLocation().getY()));
                            }
                            this.numraces++;

                        }

                    }catch(NumberFormatException e1) {
                    	   JOptionPane.showMessageDialog(null, "Invalid input! Enter another", "Message"
                                   , JOptionPane.ERROR_MESSAGE);
                }catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException | IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, "Competitor does not fit to competition! Choose another competitor.", "Message"
                                , JOptionPane.ERROR_MESSAGE);

                    } catch (IllegalStateException ex) {
                        JOptionPane.showMessageDialog(null, "can't add another competitor!", "Message"
                                , JOptionPane.ERROR_MESSAGE);
                    }
                }

                frame.setVisible(true);
                break;

            case "Start competition":


                if (numraces==0 || arena==null|| (create_competit==null && compet==null))
                {
                    JOptionPane.showMessageDialog(this, "Please build arena, create competition and add competitors");
                    return;
                }
                if (iaActiveCompetitor()){
                    JOptionPane.showMessageDialog(this, "Competition has already begun");
                    return;
                }
                for (int i=0;i<numraces;i++){
                    WinterSportsman sportman=(WinterSportsman)races.get(i);
                    change_state(sportman,destiny());
                    if(sportman.getActivityState().equals("InjuredState")){
                    	System.out.println("racerrrrrrrr====="+sportman.getNumberCount());
                        injured_races.add((sportman.getNumberCount()));
                        double dest=destiny_place();
                        sportman.setStop_place(new Point(sportman.getLocation().getX(),dest));
                        this.injuredarr.add(sportman);
                    }
                }

                GameEngine.getInstance().startRace(create_competit);
                break;

            case "Show info":
                if (arena == null || numraces == 0) {
                    JOptionPane.showMessageDialog(this, "Please build arena first and add racers!");
                    return;
                }
                String[] parameters = { "Place","ID","Name", "Speed", "Max speed", "Location", "Status" };
                String[][] info = new String[numraces+1][7];
                int i = 0;
                int place=1;
                place_info.clear();
                for (int k=0;k<numraces;k++){
                    info[k][0]= ""+place;
                    place++;
                }
                int numplace;
                ArrayList<Double> listt=new ArrayList<>();
                for(int s=0;s<numraces;s++) {
                	WinterSportsman p=(WinterSportsman)races.get(s);
                	listt.add(p.getLocation().getY());
                }
                Collections.sort(listt);
                System.out.println(listt);
                for (int k=0;k<numraces;k++){
                    numplace=help_info(races.get(k).getLocation().getY(),listt);
                    while(place_info.contains(numplace)&& numplace<numraces){
                        numplace++;
                    }
                    if (!place_info.contains(numplace-1)){
                        place_info.add(numplace-1);
                        WinterSportsman competitor=(WinterSportsman) races.get(k);
                        info[numplace-1][1] = competitor.getName();
                        info[numplace-1][2]= ""+ competitor.getNumberCount();
                        info[numplace-1][3] = "" + competitor.getSpeed();
                        info[numplace-1][4] = "" + competitor.getMaxSpeed();
                        info[numplace-1][5] = "" + competitor.getLocation().getY();
                        if (injured_races.contains(competitor.getNumberCount())) {
                            info[numplace-1][6] = "" + "Injured";
                        } else {
                            info[numplace-1][6] = "" + competitor.getActivityState();
                        }
                    }
                    else {
                        while (place_info.contains(numplace-1) && 0 < numplace) {
                            numplace--;
                        }
                        if (!place_info.contains(numplace-1)) {
                            place_info.add(numplace-1);
                            WinterSportsman competitor = (WinterSportsman) races.get(k);
                            info[numplace-1][1] = competitor.getName();
                            info[numplace-1][2]= ""+ competitor.getNumberCount();
                            info[numplace-1][3] = "" + competitor.getSpeed();
                            info[numplace-1][4] = "" + competitor.getMaxSpeed();
                            info[numplace-1][5] = "" + competitor.getLocation().getY();
                            if (injured_races.contains(competitor.getNumberCount())) {
                                info[numplace-1][6] = "" + "Injured";
                            } else {
                                info[numplace-1][6] = "" + competitor.getActivityState();
                            }
                        }
                    }
                }
                JTable table = new JTable(info, parameters);
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                JScrollPane scrollPane = new JScrollPane(table);

                JPanel tabPan = new JPanel();
                tabPan.add(scrollPane);

                if (information != null)
                    information.dispose();
                information = new JFrame("Racers information");
                information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                information.setContentPane(tabPan);
                information.pack();
                information.setVisible(true);

                break;

            case "Default Competition":
                if (iaActiveCompetitor()){
                    JOptionPane.showMessageDialog(this, "Competition has already begun");
                    return;
                }

                choose_racer.removeAllItems();
                choose_racer.addItem("");
                imageraces.clear();
                races.clear();
                numraces=0;
                if (create_competit!=null){
                    pane.remove(panee);
                    pane.repaint();
                }
                if(arena!=null) {
                    pane.remove(panee);
                    pane.repaint();	
                }
                if (num_default.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Please fill all the fields!");
                    return;
                }
                double numb=Double.parseDouble(num_default.getText());
                int num=(int)numb;
                compet=new BuilderCompetition(num);
                create_competit=(Competition)compet.getCompetition();
                this.arena=compet.getArena();
                try {
                    img = ImageIO.read(new File("icons\\Cloudy.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                update_backgrount();
                if (num>10){
                    this.sizearena=1400;
                    pane.setSize(sizearena,(int)arena.getLength()+30);
                    frame.setSize(sizearena,(int)arena.getLength()+30);
                    frame.setVisible(true);
                }
                else {
                    this.sizearena=1000;
                    pane.setSize(sizearena,(int)arena.getLength()+30);
                    frame.setSize(sizearena, (int)arena.getLength()+30);
                    frame.setVisible(true);
                }
                races=new ArrayList<>(compet.getCompetitors_races());
                ArrayList<Competitor> arrcopy=new ArrayList<>(compet.getCompetitors_races());
                for (int u=0;u<arrcopy.size();u++){
                    copyracers.add(arrcopy.get(u));
                }
                for (Competitor competitor: this.races){
                    compet.getCompetition().addCompetitor(competitor);
                    WinterSportsman w=(WinterSportsman) competitor;
                   // nameracers.add(w.getNumberCount()+" "+w.getName());
                    copy_race.addItem(w.getNumberCount()+" "+w.getName());
                    choose_racer.addItem(w.getNumberCount()+" "+w.getName());
                    w.setLocation(new Point(numraces * 60, w.getLocation().getY()));
                    update_imageracer(w.getColor(),"Ski");
                    numraces++;
                    frame.setVisible(true);

                }
                for (int j=0;j<numraces;j++){
                    WinterSportsman competitor=(WinterSportsman) races.get(j);
                    competitor.addObserver(this);

                }
                break;

            case "change acceleration":
                if (iaActiveCompetitor()){
                    JOptionPane.showMessageDialog(this, "Competition has already begun");
                    return;
                }
                if (numraces==0 || arena==null|| (create_competit==null && compet==null))
                {
                    JOptionPane.showMessageDialog(this, "Please build arena, create competition and add competitors");
                    return;
                }
                copy=choose_racer.getSelectedItem().toString();

                if (!copy.equals("")){
                    char [] str=new char[copy.length()];
                    for (int r=0;r<copy.length();r++){
                        if (copy.charAt(r)==' '){
                            break;
                        }
                        str[r]=copy.charAt(r);
                    }
                    String string=new String(str);
                    double num1 = Double.parseDouble(string);
                    text1 = enteracceleration.getText();
                    if (text1.equals("")){
                        JOptionPane.showMessageDialog(this, "Please fill all the fields!");
                        return;
                    }
                    double value = Double.parseDouble(text1);
                    int num2=(int)num1;
                    int buffer=0;

                    for (i=0;i<numraces;i++){
                        WinterSportsman sportsman=(WinterSportsman)races.get(i);
                        if (sportsman.getNumberCount()==num2){
                            IWinterSportsman sport=(IWinterSportsman)sportsman;
                            sport=new SpeedySportsman(sportsman,value);
                            sport.makeIWinterSportsman(sportsman);
                            races.set(buffer,sportsman);
                        }
                        buffer++;
                    }
                    }


                    break;
            case "change color":
                if (iaActiveCompetitor()){
                    JOptionPane.showMessageDialog(this, "Competition has already begun");
                    return;
                }
                if (numraces==0 || arena==null|| (create_competit==null && compet==null))
                {
                    JOptionPane.showMessageDialog(this, "Please build arena, create competition and add competitors");
                    return;
                }
                if (arena!=null){
                    pane.remove(panee);
                    update_backgrount();
                }
                copy=choose_racer.getSelectedItem().toString();
                if (!copy.equals("")){
                    char [] str=new char[copy.length()];
                    for (int r=0;r<copy.length();r++){
                        if (copy.charAt(r)==' '){
                            break;
                        }
                        str[r]=copy.charAt(r);
                    }
                    String string=new String(str);
                    double num1 = Double.parseDouble(string);
                    int num2=(int)num1;
                    int buffer=0;
                    colorr=(String) this.color_change.getSelectedItem();

                    for (i=0;i<numraces;i++){
                        WinterSportsman sportsman=(WinterSportsman)races.get(i);
                        if (sportsman.getNumberCount()==num2){
                            IWinterSportsman sport=new ColoredSportsman(sportsman,colorr);
                            sport.makeIWinterSportsman(sportsman);
                            races.set(buffer,sportsman);
                        }
                        buffer++;
                    }
                }
                imageraces.clear();
                String type_racer;
                if (races.get(0) instanceof Skier){
                    type_racer="Ski";
                }
                else{
                    type_racer="Snowboard";
                }
                for (int j=0;j<numraces;j++){
                    WinterSportsman winterman=(WinterSportsman)races.get(j);
                    update_imageracer(winterman.getColor(),type_racer);
                }
                frame.setVisible(true);
                break;
        }

        }

    /**
     * this function get notify from the competitor and change the place of the image and remove from activecompetitors to finish
     * We check if the competitor is not injured, if yes, we print a message
     * @param o competitor
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Competitor){
            synchronized (imageraces){
                WinterSportsman competitor=(WinterSportsman) o;
                int index = races.indexOf(competitor);
                // update image location
                if(competitor.getLocation().getY()>=650)
                {
                    imageraces.get(index).setLocation((int) competitor.getLocation().getX(),650);
                    panee.add(imageraces.get(index));
                    repaint();
                    panee.setVisible(true);
                }
                else {
                    imageraces.get(index).setLocation((int) competitor.getLocation().getX(),(int) competitor.getLocation().getY());
                    panee.add(imageraces.get(index));
                    repaint();
                    panee.setVisible(true);

                }

                if(competitor.getStop_place()!=null)
                {
                	if(competitor.getStop_place().getY()<=competitor.getLocation().getY())
                	{
                		
                        EventQueue.invokeLater(new Runnable() {

                            public void run() {
                                new messagee(competitor);
                            }
                        });
                	}
                }

                // update competition
                if(arena.isFinished(competitor)){
                    create_competit.getFinishedCompetitors().add(competitor);
                    create_competit.getActiveCompetitors().remove(competitor);

                }


            }

        }

    }


}
