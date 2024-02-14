import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Program for print data in JSON format.
public class ReadJson implements ActionListener {
    private JFrame mainFrame;
    private JPanel upperPanel, lowerPanel, alliesPanel, namePanel;
    private JTextArea nameDisplayer, allyDisplayer;
    private JLabel characterLabel, alliesLabel;
    private int WIDTH = 800;
    int counter = 0;
    private int HEIGHT = 700;

    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON object
        // which is a subclass of java.util.HashMap.
        ReadJson gavin = new ReadJson();
        gavin.showEventDemo();


        JSONObject file = new JSONObject();
        file.put("Full Name", "Ritu Sharma");
        file.put("Roll No.", new Integer(1704310046));
        file.put("Tution Fees", new Double(65400));


        // To print in JSON format.
        System.out.print(file.get("Tution Fees"));
        pull();

    }

    public ReadJson() {
        prepareGUI();

    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(2, 1));

        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayout(1, 2));
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 2));
        mainFrame.add(upperPanel);
        mainFrame.add(lowerPanel);

        namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        upperPanel.add(namePanel);
        alliesPanel = new JPanel();
        alliesPanel.setLayout(new BorderLayout());
        upperPanel.add(alliesPanel);
        allyDisplayer = new JTextArea();
        nameDisplayer = new JTextArea();
        alliesPanel.add(allyDisplayer, BorderLayout.CENTER);
        namePanel.add(nameDisplayer, BorderLayout.CENTER);


//
        alliesLabel = new JLabel("Allies");
        characterLabel = new JLabel("Character");
        namePanel.add(characterLabel, BorderLayout.NORTH);
        alliesPanel.add(alliesLabel, BorderLayout.NORTH);


//        ta = new JTextField();
//        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
//        tb = new JTextField();
//        urlPanel.add(ta,BorderLayout.CENTER);
//        keywordPanel.add(tb,BorderLayout.CENTER);
//        tb.setBounds(50,5,WIDTH-200, HEIGHT-50);
//        resultsPanel = new JTextArea();


        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
//

        //   JButton okButton = new JButton("Search");
        JButton next = new JButton("Next");
        JButton previous = new JButton("Previous");


        next.addActionListener(new ButtonClickListener());
        previous.addActionListener(new ButtonClickListener());



//        mainFrame.add(okButton);
        lowerPanel.add(next);
        lowerPanel.add(previous);
//        mainFrame.add(controlPanel);
//        controlPanel.add(ta,BorderLayout.WEST);
//        controlPanel.add(tb,BorderLayout.EAST);
        // mainFrame.add(statusLabel);
        // mainFrame.add(resultsPanel);
//        JScrollPane pane = new JScrollPane(resultsPanel);
//        lowerPanel.add(pane);
        mainFrame.setVisible(true);

    }

    private void showEventDemo() {

        mainFrame.setVisible(true);
    }


    public static void pull() throws ParseException {
        String output = "abc";
        String totlaJson = "";
        try {

            URL url = new URL("https://last-airbender-api.fly.dev/api/v1/characters");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                totlaJson += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONArray jsonObjectArray = (org.json.simple.JSONArray) parser.parse(totlaJson);
        //System.out.println(jsonObjectArray);

        try {


//            org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("abilities");
//            int n =   msg.size(); //(msg).length();
//            for (int i = 0; i < n; ++i) {
//                String test =(String) msg.get(i);
//                System.out.println(test);
//                // System.out.println(person.getInt("key"));
//            }
            //String name= (String)jsonObject.get("height");
//            System.out.println(jsonObjectArray.get(0));
//            JSONObject secretTunnelGuy = (JSONObject) jsonObjectArray.get(0);
//            System.out.println(secretTunnelGuy.get("name"));
//            System.out.println(secretTunnelGuy.get("allies"));
//            JSONArray chongAllies =  (JSONArray) secretTunnelGuy.get("allies");
//            System.out.println(chongAllies.get(0));
//            System.out.println(jsonObjectArray.get(1));
//            JSONObject chief = (JSONObject) jsonObjectArray.get(1);
//            System.out.println(chief.get("name"));
//            JSONArray chiefAllies =  (JSONArray) chief.get("enemies");
//            System.out.println(chiefAllies.get(0));
            for (int x = 0; x < jsonObjectArray.size(); x++) {
                JSONObject temp = (JSONObject) jsonObjectArray.get(x);
                System.out.println(temp.get("name"));
                JSONArray tempAllies = (JSONArray) temp.get("allies");
                for (int y = 0; y < tempAllies.size(); y++) {

                    System.out.println(tempAllies.get(y));
                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    private class ButtonClickListener implements ActionListener {




        @Override
        public void actionPerformed(ActionEvent d) {

            String output = "abc";
            String totlaJson = "";
            String command = d.getActionCommand();
            System.out.println(counter);

            if (command.equals("Previous")) {
                counter=counter-1;
                allyDisplayer.selectAll();
                allyDisplayer.replaceSelection("");
                nameDisplayer.selectAll();
                nameDisplayer.replaceSelection("");
                System.out.println("ITS HAPPENING");
            }
            if (command.equals("Next")) {
                counter=counter+1;
                allyDisplayer.selectAll();
                allyDisplayer.replaceSelection("");
                nameDisplayer.selectAll();
                nameDisplayer.replaceSelection("");
            }



                    try {

                        URL url = new URL("https://last-airbender-api.fly.dev/api/v1/characters");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "application/json");

                        if (conn.getResponseCode() != 200) {

                            throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                (conn.getInputStream())));


                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                            //System.out.println(output);
                            totlaJson += output;
                        }

                        conn.disconnect();

                    } catch (MalformedURLException e) {
                        e.printStackTrace();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    JSONParser parser = new JSONParser();
                    //System.out.println(str);
                    JSONArray jsonObjectArray = null;
                    try {
                        jsonObjectArray = (JSONArray) parser.parse(totlaJson);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    //System.out.println(jsonObjectArray);

                    try {


//            org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("abilities");
//            int n =   msg.size(); //(msg).length();
//            for (int i = 0; i < n; ++i) {
//                String test =(String) msg.get(i);
//                System.out.println(test);
//                // System.out.println(person.getInt("key"));
//            }
                        //String name= (String)jsonObject.get("height");
//            System.out.println(jsonObjectArray.get(0));
//            JSONObject secretTunnelGuy = (JSONObject) jsonObjectArray.get(0);
//            System.out.println(secretTunnelGuy.get("name"));
//            System.out.println(secretTunnelGuy.get("allies"));
//            JSONArray chongAllies =  (JSONArray) secretTunnelGuy.get("allies");
//            System.out.println(chongAllies.get(0));
//            System.out.println(jsonObjectArray.get(1));
//            JSONObject chief = (JSONObject) jsonObjectArray.get(1);
//            System.out.println(chief.get("name"));
//            JSONArray chiefAllies =  (JSONArray) chief.get("enemies");
//            System.out.println(chiefAllies.get(0));
                        if (counter == -1){
                            counter= jsonObjectArray.size();

                        }
                        if (counter > jsonObjectArray.size()){
                            counter= 0;

                        }
                        if (counter < jsonObjectArray.size()) {
                            JSONObject temp = (JSONObject) jsonObjectArray.get(counter);
                            nameDisplayer.append((String) (temp.get("name")));

                            JSONArray tempAllies = (JSONArray) temp.get("allies");
                            for (int y = 0; y < tempAllies.size(); y++) {

                                allyDisplayer.append((String) ((tempAllies.get(y))));
                            }


                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }


            }

        }




