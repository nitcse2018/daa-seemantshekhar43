package com.seemantshekhar;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Controller {

    //Personal Info
    @FXML
    public Label errorPersonalLabel;
    @FXML
    public JFXTextField firstNameText;
    @FXML
    public JFXTextField lastNameText;
    @FXML
    public JFXTextField emailText;
    @FXML
    public JFXTextField contactText;
    @FXML
    public JFXTextField nationalityText;
    @FXML
    public JFXTextField addressText;
    @FXML
    public JFXButton btnNextPersonalInfo;
    @FXML
    public Label resetAllPersonalInfo;


    // Qualification
    @FXML
    public JFXTextField twelfthText;
    @FXML
    public JFXTextField tenthText;
    @FXML
    public JFXTextField degreeText;
    @FXML
    public JFXTextField branchText;
    @FXML
    public JFXTextField cgpaText;
    @FXML
    public JFXTextField collegeText;
    @FXML
    public JFXTextField gradYearText;
    @FXML
    public JFXButton btnNextQualification;
    @FXML
    public Label resetAllQualification;


    //Skills and Experience
    @FXML
    public JFXTextField skillsText;
    @FXML
    public JFXButton btnGenerate;
    @FXML
    public Label resetAllSkills;
    @FXML
    public JFXTextField linkedinText;
    @FXML
    public JFXTextField githubText;
    @FXML
    public JFXTextField experienceText;
    @FXML
    public JFXTextField achievementsText;



    //Side Pane Buttons
    @FXML
    public JFXButton btnPersonalInfo;
    @FXML
    public JFXButton btnQualification;
    @FXML
    public JFXButton btnSkills;



    //Panes
    @FXML
    private AnchorPane personalPane;
    @FXML
    private AnchorPane qualificationPane;
    @FXML
    private AnchorPane skillsPane;

    public void initialize(){

        personalPane.setVisible(true);
        qualificationPane.setVisible(false);
        skillsPane.setVisible(false);

    }




    @FXML
    private void exit(MouseEvent e){
        System.exit(0);
    }


    public void nextToQualification(ActionEvent actionEvent) {
        personalPane.setVisible(false);
        skillsPane.setVisible(false);
        qualificationPane.setVisible(true);
    }

    public void nextToSkills(ActionEvent actionEvent) {
        personalPane.setVisible(false);
        qualificationPane.setVisible(false);
        skillsPane.setVisible(true);
    }

    public void nextToPersonal(ActionEvent actionEvent) {
        personalPane.setVisible(true);
        qualificationPane.setVisible(false);
        skillsPane.setVisible(false);
    }

    public void generateResume(ActionEvent actionEvent) throws IOException, DocumentException {
        if(firstNameText.getText().trim().isEmpty()){
            errorPersonalLabel.setVisible(true);
            errorPersonalLabel.setText("Please enter a valid First Name.");
            personalPane.setVisible(true);
            qualificationPane.setVisible(false);
            skillsPane.setVisible(false);
            return;
        }
        UserData userData = new UserData();

        //Personal Info
        userData.setfName(firstNameText.getText().trim());
        userData.setlName(lastNameText.getText().trim());
        userData.setEmail(emailText.getText().trim());
        userData.setNationality(nationalityText.getText().trim());
        userData.setContact(contactText.getText().trim());
        userData.setAddress(addressText.getText().trim());

        //Qualification
        userData.setCollege(collegeText.getText().trim());
        userData.setBranch(branchText.getText().trim());
        userData.setDegree(degreeText.getText().trim());
        userData.setCgpa(cgpaText.getText().trim());
        userData.setgYear(gradYearText.getText().trim());
        userData.setTenth(tenthText.getText().trim());
        userData.setTwelfth(twelfthText.getText().trim());

        //Skills and Experience
        userData.setGithub(githubText.getText().trim());
        userData.setLinkedin(linkedinText.getText().trim());
        List<String> skills = new ArrayList<>();
        List<String> experience = new ArrayList<>();
        List<String> achievements = new ArrayList<>();

        System.out.println("Using Constructor 1 - ");
        StringTokenizer st1 =
                new StringTokenizer(skillsText.getText().trim(), ",");
        while (st1.hasMoreTokens())
            skills.add(st1.nextToken().trim());
        StringTokenizer st2 =
                new StringTokenizer(experienceText.getText().trim(), ",");
        while (st2.hasMoreTokens())
            experience.add(st2.nextToken().trim());
        StringTokenizer st3 =
                new StringTokenizer(achievementsText.getText().trim(), ",");
        while (st3.hasMoreTokens())
            achievements.add(st3.nextToken().trim());

        userData.setSkills(skills);
        userData.setExperience(experience);
        userData.setAchievements(achievements);

        convertToPdf(userData);
        System.out.println(userData);
    }

    private void convertToPdf(UserData userData) throws DocumentException, IOException {

        FileChooser filechooser = new FileChooser();
        filechooser.setInitialDirectory(new File(userData.getfName()+" "+userData.getlName()+".pdf"));
        String filePath = filechooser.getInitialDirectory().getPath();
        Document  myDocument = new Document();
        try {
            PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        myDocument.open();

        myDocument.add(new Paragraph(userData.getfName()+"  "+userData.getlName(), FontFactory.getFont(FontFactory.TIMES_BOLD,28, BaseColor.BLACK )));
        myDocument.add(new Paragraph("",FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY)));
        myDocument.add(new Paragraph("",FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY)));

        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        myDocument.add(new Paragraph("Personal Information",FontFactory.getFont(FontFactory.TIMES_BOLD,18,BaseColor.BLACK )));
        myDocument.add(new Paragraph("Email: "+userData.getEmail(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("Phone: "+userData.getContact(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY )));
        myDocument.add(new Paragraph("Address: "+userData.getAddress()+", ",FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("Nationality: "+userData.getNationality(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));

        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        myDocument.add(new Paragraph("QUALIFICATIONS",FontFactory.getFont(FontFactory.TIMES_BOLD,18,BaseColor.BLACK  )));
        myDocument.add(new Paragraph("College/University: "+userData.getCollege(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("Degree: "+userData.getDegree(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("Branch: "+userData.getBranch(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("CGPA: "+userData.getCgpa(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("Graduation Year: "+userData.getgYear(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("10th Percentage: "+userData.getTenth(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("12th Percentage: "+userData.getTwelfth(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));


        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        myDocument.add(new Paragraph("SKILLS",FontFactory.getFont(FontFactory.TIMES_BOLD,18,BaseColor.BLACK )));
        com.itextpdf.text.List skills = new com.itextpdf.text.List();
        for(String s: userData.getSkills()){
            skills.add(s);
        }
        myDocument.add(skills);


        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        myDocument.add(new Paragraph("Experience",FontFactory.getFont(FontFactory.TIMES_BOLD,18,BaseColor.BLACK )));
        com.itextpdf.text.List experience = new com.itextpdf.text.List();
        for(String s: userData.getExperience()){
            experience.add(s);
        }
        myDocument.add(experience);
        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));

        myDocument.add(new Paragraph("Achievements",FontFactory.getFont(FontFactory.TIMES_BOLD,18,BaseColor.BLACK )));
        com.itextpdf.text.List achievements = new com.itextpdf.text.List();
        for(String s: userData.getAchievements()){
            achievements.add(s);
        }
        myDocument.add(achievements);
        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        myDocument.add(new Paragraph("Technical Profile",FontFactory.getFont(FontFactory.TIMES_BOLD,18,BaseColor.BLACK  )));
        myDocument.add(new Paragraph("Github profile: "+userData.getGithub(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));
        myDocument.add(new Paragraph("LinkedIn Profile: "+userData.getLinkedin(),FontFactory.getFont(FontFactory.TIMES,12,BaseColor.DARK_GRAY  )));

        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        myDocument.add(new Paragraph("Reference",FontFactory.getFont(FontFactory.TIMES_BOLD,18,BaseColor.BLACK  )));
        myDocument.add(new Paragraph("Available upon request",FontFactory.getFont(FontFactory.TIMES,14,BaseColor.DARK_GRAY  )));

        myDocument.close();
        Stage primaryStage = (Stage)(resetAllPersonalInfo.getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/userInterface.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        resumeGenerated();
        System.out.println("Resume Generated Successfully!");
    }
    public static void resumeGenerated(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resume Generated!");
        alert.setHeaderText(null);
        alert.setContentText("Your Resume Generated Successfully.");
        alert.show();

    }
    public void resetAll(MouseEvent e) throws IOException {

        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/userInterface.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

