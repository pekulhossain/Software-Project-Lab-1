package VisualRepresentation;
import BookDataBaseFX.DemandsOfBookFX;
import BookDataBaseFX.GenericsOfBookFX;
import BookDataBaseFX.TypesOfBookFX;
import MainPackage.BookNumber;
import MainPackage.Processing;
import ObjectOriented.PriorityData;
import Regression.newVersion.TypeCountRegression;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.IOException;

public class StackedAreaFX extends Application {

    PriorityData[] priorityData;

    int numberOfBooks;
    Processing processing = new Processing();
    BookNumber bookNumber = new BookNumber();


    @Override
    public void start(Stage primaryStage) {

    }

    public void startTyping(Stage primaryStage) throws IOException {
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            TypesOfBookFX typesOfBookFX = new TypesOfBookFX();
            try {
                typesOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });

        setStyle(exit);
        setStyle(back);


        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);




        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();


        String uponnashType,kobitaType,rochonaBoliType,
                religionType,bigganType,sciFicType,shisuSahittoType,kisoreUponnashType,onubadType,othersType;


        int uponnashTypeNO,kobitaTypeNO,rochonaBoliTypeNO,
                religionTypeNO,bigganTypeNO,sciFicTypeNO,shisuSahittoTypeNO,kisoreUponnashTypeNO,onubadTypeNO,othersTypeNO;

        uponnashTypeNO=0;kobitaTypeNO=0;rochonaBoliTypeNO=0;
        religionTypeNO=0;bigganTypeNO=0;sciFicTypeNO=0;
        shisuSahittoTypeNO=0; kisoreUponnashTypeNO=0;
        onubadTypeNO=0;othersTypeNO=0;

        uponnashType="Uponnash";
        kobitaType = "Kobita";
        rochonaBoliType = "Rochhona Boli";
        religionType= "Religion";
        bigganType = "Biggan";
        sciFicType = "Science Fiction";
        shisuSahittoType = "SHishu Sahitto";
        kisoreUponnashType = "Kisore";
        onubadType = "Onubad";
        othersType= "Others";


        int [] typeCounter = new int[6];

        for (iterator = 0; iterator < numberOfBooks; iterator++) {
            if (priorityData[iterator].bookData.bookId.substring(0,2).equals("01")) {
                uponnashTypeNO++;

            } else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("05")) {
                rochonaBoliTypeNO++;

            } else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("02")) {
                kobitaTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("13")) {
                bigganTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("14")) {
                bigganTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("06")) {
                sciFicTypeNO++;

            } else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("10")) {
                kisoreUponnashTypeNO++;

            }  else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("11")) {
                shisuSahittoTypeNO++;

            }else if (priorityData[iterator].bookData.bookId.substring(0,2).equals("04")) {
                religionTypeNO++;

            }  else {
                othersTypeNO++;

            }
        }



        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Types");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");

        BarChart barChart = new BarChart(categoryAxis,numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName(uponnashType);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(kobitaType);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(rochonaBoliType);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(religionType);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(bigganType);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(sciFicType);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(shisuSahittoType);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(kisoreUponnashType);
        XYChart.Series series9 = new XYChart.Series();
        series9.setName(onubadType);
        XYChart.Series series10 = new XYChart.Series();
        series10.setName(othersType);



        series1.getData().add(new XYChart.Data(uponnashType,uponnashTypeNO));
        series2.getData().add(new XYChart.Data(kobitaType,kobitaTypeNO));
        series3.getData().add(new XYChart.Data(rochonaBoliType,rochonaBoliTypeNO));
        series4.getData().add(new XYChart.Data(religionType,religionTypeNO));
        series5.getData().add(new XYChart.Data(bigganType,bigganTypeNO));
        series6.getData().add(new XYChart.Data(sciFicType,sciFicTypeNO));
        series7.getData().add(new XYChart.Data(shisuSahittoType,shisuSahittoTypeNO));
        series8.getData().add(new XYChart.Data(kisoreUponnashType,kisoreUponnashTypeNO));
        series9.getData().add(new XYChart.Data(onubadType,onubadTypeNO));
        series10.getData().add(new XYChart.Data(othersType,othersTypeNO));

        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        barChart.getData().add(series4);
        barChart.getData().add(series5);
        barChart.getData().add(series6);
        barChart.getData().add(series7);
        barChart.getData().add(series8);
        barChart.getData().add(series9);
        barChart.getData().add(series10);



        barChart.setTranslateX(65);
        barChart.setTranslateY(55);
        barChart.setPrefSize(1000,700);




        HBox hBox1 = new HBox(barChart,exit,back);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();




    }

    public void startTiming(Stage primaryStage) throws IOException {


        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            GenericsOfBookFX genericsOfBookFX = new GenericsOfBookFX();
            try {
                genericsOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });

        setStyle(exit);
        setStyle(back);


        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);


        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Generics of Book Bar Chart");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Generics of Book");

        BarChart barChart = new BarChart(categoryAxis,numberAxis);


        String year2008,year2009,year2010,year2011,year2012,year2013,year2014,year2015,year2016,year2017;
        int  year2008Books,year2009Books,year2010Books,year2011Books,year2012Books,
                year2013Books,year2014Books,year2015Books,year2016Books,year2017Books;
        year2008Books=0;year2009Books=0;year2010Books=0;year2011Books=0;
        year2012Books=0;year2013Books=0;year2014Books=0;year2015Books=0;
        year2016Books=0;year2017Books=0;

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

        for(iterator=0;iterator<numberOfBooks;iterator++){



            if(priorityData[iterator].bookData.bookId.contains("17")){
                year2017Books++;
            }
            else if(priorityData[iterator].bookData.bookId.contains("16")){
                year2016Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("15")){
                year2015Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("14")){
                year2014Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("13")){
                year2013Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0812")){
                year2012Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0212")){
                year2012Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1211")){
                year2011Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0311")){
                year2011Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1210")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0810")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0410")){
                year2010Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1009")){
                year2009Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0409")){
                year2009Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("1208")){
                year2008Books++;
            }else if(priorityData[iterator].bookData.bookId.contains("0608")){
                year2008Books++;
            }


        }

        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;



        XYChart.Series series1 = new XYChart.Series();
        series1.setName(year2008);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(year2009);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(year2010);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(year2011);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(year2012);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(year2013);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(year2014);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(year2015);
        XYChart.Series series9 = new XYChart.Series();
        series9.setName(year2016);
        XYChart.Series series10 = new XYChart.Series();
        series9.setName(year2017);




        series1.getData().add(new XYChart.Data(year2008,year2008Books));
        series2.getData().add(new XYChart.Data(year2009,year2009Books));
        series3.getData().add(new XYChart.Data(year2010,year2010Books));
        series4.getData().add(new XYChart.Data(year2011,year2011Books));
        series5.getData().add(new XYChart.Data(year2012,year2012Books));
        series6.getData().add(new XYChart.Data(year2013,year2013Books));
        series7.getData().add(new XYChart.Data(year2014,year2014Books));
        series8.getData().add(new XYChart.Data(year2015,year2015Books));
        series9.getData().add(new XYChart.Data(year2016,year2016Books));
        series10.getData().add(new XYChart.Data(year2017,year2017Books));


        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        barChart.getData().add(series4);
        barChart.getData().add(series5);
        barChart.getData().add(series6);
        barChart.getData().add(series7);
        barChart.getData().add(series8);
        barChart.getData().add(series9);
        barChart.getData().add(series10);



        barChart.setTranslateX(65);
        barChart.setTranslateY(55);
        barChart.setPrefSize(1000,700);




        year2008 =  "year2008" ;
        year2009 =  "year2009" ; year2010 =  "year2010" ; year2011 =  "year2011" ;
        year2012=   "year2012" ;year2013 =  "year2013" ; year2014 =  "year2014" ;
        year2015 =  "year2015" ;year2016 =  "year2016" ; year2017 =  "year2017" ;




        series1.getData().add(new XYChart.Data(year2008,year2008Books));
        series1.getData().add(new XYChart.Data(year2009,year2009Books));
        series1.getData().add(new XYChart.Data(year2010,year2010Books));
        series1.getData().add(new XYChart.Data(year2011,year2011Books));
        series1.getData().add(new XYChart.Data(year2012,year2012Books));
        series1.getData().add(new XYChart.Data(year2013,year2013Books));
        series1.getData().add(new XYChart.Data(year2014,year2014Books));
        series1.getData().add(new XYChart.Data(year2015,year2015Books));
        series1.getData().add(new XYChart.Data(year2016,year2016Books));
        series1.getData().add(new XYChart.Data(year2017,year2017Books));

        barChart.getData().add(series1);



        barChart.setTranslateX(65);
        barChart.setTranslateY(55);
        barChart.setPrefSize(500,500);


        barChart.getData().add(series1);



        barChart.setTranslateX(65);
        barChart.setTranslateY(55);
        barChart.setPrefSize(500,500);

        HBox hBox1 = new HBox(barChart,exit,back);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);


        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();



    }


    public void startBorrowing(Stage primaryStage) throws IOException {
        Button back = new Button("Back");
        Button exit = new Button("Exit");
        back.setTranslateX(0);
        back.setTranslateY(650);
        exit.setTranslateX(1100);
        exit.setTranslateY(650);
        back.setOnAction(actionEvent -> {
            DemandsOfBookFX demandsOfBookFX = new DemandsOfBookFX();
            try {
                demandsOfBookFX.start(primaryStage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
        exit.setOnAction(actionEvent -> {
            System.exit(0);


        });

        setStyle(exit);
        setStyle(back);


        back.setPrefSize(200, 80);
        exit.setPrefSize(200, 80);


        String below4,over4,over7,over10,over15,over20,over25,over30;
        int  below4Count,over4Count,over7Count,over10Count,over15Count,
                over20Count,over25Count,over30Count;


        below4Count=0;over4Count=0;over7Count=0;over10Count=0;
        over15Count=0;over20Count=0;over25Count=0;over30Count=0;

        int iterator;
        priorityData = processing.fileReaderMethods();
        numberOfBooks = bookNumber.bookNumberFindingMethods();

        for(iterator=0;iterator<numberOfBooks;iterator++){



            if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=30.0){
                over30Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=25.0){
                over25Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=20.0){
                over20Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=15.0){
                over15Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=10.0){
                over10Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=7.0){
                over7Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>=4.0){
                over4Count++;
            }else if(Double.parseDouble(String.valueOf(priorityData[iterator].borrowPriority))>4.0){
                below4Count++;
            }


        }



        below4 =  "0-3" ;
        over4 =  "4-6" ; over7 =  "7-9" ; over10 =  "10-14" ;
        over15=   "15-19" ;over20 =  "20-24" ; over25 =  "25-29" ;
        over30 =  "30+" ;



        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Book Class Category");

        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setLabel("Numbers of Book");

        BarChart barChart = new BarChart(categoryAxis,numberAxis);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName(below4);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(over4);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(over7);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(over10);
        XYChart.Series series5 = new XYChart.Series();
        series5.setName(over15);
        XYChart.Series series6 = new XYChart.Series();
        series6.setName(over20);
        XYChart.Series series7 = new XYChart.Series();
        series7.setName(over25);
        XYChart.Series series8 = new XYChart.Series();
        series8.setName(over30);
        XYChart.Series series9 = new XYChart.Series();




        series1.getData().add(new XYChart.Data(below4,below4Count));
        series2.getData().add(new XYChart.Data(over4,over4Count));
        series3.getData().add(new XYChart.Data(over7,over7Count));
        series4.getData().add(new XYChart.Data(over10,over10Count));
        series5.getData().add(new XYChart.Data(over15,over15Count));
        series6.getData().add(new XYChart.Data(over20,over20Count));
        series7.getData().add(new XYChart.Data(over25,over25Count));
        series8.getData().add(new XYChart.Data(over30,over30Count));


        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        barChart.getData().add(series4);
        barChart.getData().add(series5);
        barChart.getData().add(series6);
        barChart.getData().add(series7);
        barChart.getData().add(series8);
        barChart.getData().add(series9);



        barChart.setTranslateX(65);
        barChart.setTranslateY(55);
        barChart.setPrefSize(1000,700);



        HBox hBox1 = new HBox(barChart,exit,back);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox1);

        vbox.setMaxSize(850, 650);
        // vBox3.setSpacing(5);


        Image background = new Image("libraryBackground4.jpg");

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        vbox.setBackground(bg);

        vbox.setPrefSize(1400,750);
        Group group = new Group(vbox,exit,back);

        Scene scene = new Scene(group ,1400, 770);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Books Statistics");
        primaryStage.setFullScreen(true);
        primaryStage.show();


    }

    public void startPricing(Stage primaryStage) {

    }
    public Button setStyle(Button button)
    {
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return  button;
    }


}
