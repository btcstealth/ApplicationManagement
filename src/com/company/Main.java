package com.company;

import BusinessLogic.BLLCompany;
import DBAccess.*;
import Labels.ButtonLabels;
import Labels.TitleLabels;
import Model.Company;
import Model.Employee;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class Main extends Application {

    GUIEventHandler eventHandler = new GUIEventHandler();
    Stage window;
    Scene scene, companiesScene, jobAdsScene;
    Button companyButton, jobAdButton;
    ObservableList<String> companyNames;
    ListView<String> companiesListView, jobAdsListView;

    Map<String, Company> companies, jobAds;



    public static void exampleQuery(DBConnect con){
        //query it
        DBEmployee employeeQuery = new DBEmployee();
        List<Employee> employees = employeeQuery.getAllEmployee();

        employees.stream().forEach(e -> System.out.println("Employee ID: " + e.getID() + "\n" +
                "Name: " + e.getName() + "\n" +
                "Salary: " + e.getSalary()
        ));


        Employee e3 = employeeQuery.getEmployee(3);
        System.out.println(e3.getID() + " " + e3.getName() + " " + e3.getSalary());
    }




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle(TitleLabels.MAIN_MENU);

        companyButton = new Button(ButtonLabels.COMPANIES);
        companyButton.setOnAction(e -> companyButtonClicked());

        jobAdButton = new Button(ButtonLabels.JOBADS);
        jobAdButton.setOnAction(e -> jobAdsButtonClicked());


        companiesScene = createCompaniesScene();
        jobAdsScene = createJobAdsScene();
        scene = createMainScene();

        window.setScene(scene);
        window.show();
    }


    /**
     * Scene creation functions
     */

    private Scene createMainScene(){
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(companyButton, jobAdButton);
        return new Scene(layout, 300, 250);
    }

    private Scene createJobAdsScene(){
        /*
        TreeTableView<String> treeTableView = new TreeTableView<>();

        final TreeItem<String> root = new TreeItem<>("JobAds");
        root.setExpanded(true);

        //Creating tree items
        final TreeItem<String> childNode1 = new TreeItem<>("Child Node 1");
        final TreeItem<String> childNode2 = new TreeItem<>("Child Node 2");
        final TreeItem<String> childNode3 = new TreeItem<>("Child Node 3");

        TreeTableColumn<String, String> column = new TreeTableColumn<>("Title");
        column.setPrefWidth(150);
        column.setCellFactory((TableColumn.CellDataFeatures<String, String> p) ->
                new ReadOnlyStringWrapper(p.getValue(), p.getValue()));

        root.getChildren().addAll(childNode1, childNode2, childNode3);
        treeTableView.setRoot(root);
        treeTableView.getColumns().add(column);
        treeTableView.setPrefWidth(152);
        treeTableView.setShowRoot(false);
        */

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("add1", "add2", "add3");
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Button mainMenuButton = new Button(ButtonLabels.TO_MAIN_MENU);
        mainMenuButton.setOnAction(e -> mainMenuButtonClicked());

        Button showDetailsSelectedButton = new Button(ButtonLabels.SHOW_SELECTED_JOBAD);
        showDetailsSelectedButton.setOnAction(e -> showDetailsSelectedButtonClicked());
        Button addButton = new Button(ButtonLabels.ADD_NEW_JOBAD);
        Button removeSelectedButton = new Button(ButtonLabels.REMOVE_SELECTED_JOBAD);


        VBox jobAdsLayout = new VBox(10);
        jobAdsLayout.setPadding(new Insets(20,20,20,20));
        jobAdsLayout.getChildren().addAll(listView, showDetailsSelectedButton, addButton, removeSelectedButton, mainMenuButton);
        return new Scene(jobAdsLayout, 300, 450);
    }

    private Scene createCompaniesScene(){
        companyNames = FXCollections.observableArrayList();
        companiesListView = new ListView<>();
        companiesListView.setItems(null);
        companiesListView.setItems(companyNames);
        companiesListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        Button mainMenuButton = new Button(ButtonLabels.TO_MAIN_MENU);
        mainMenuButton.setOnAction(e -> mainMenuButtonClicked());


        Button showSelectedButton = new Button(ButtonLabels.SHOW_SELECTED_COMPANY);
        Button addButton = new Button(ButtonLabels.ADD_NEW_COMPANY);
        Button removeSelectedButton = new Button(ButtonLabels.REMOVE_SELECTED_COMPANY);

        VBox companiesLayout = new VBox(10);
        companiesLayout.setPadding(new Insets(20,20,20,20));
        companiesLayout.getChildren().addAll(companiesListView, showSelectedButton, addButton, removeSelectedButton, mainMenuButton);
        return new Scene(companiesLayout, 300, 450);
    }


    private Scene createCompanyDetailsScene(){
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        //companiesLayout.getChildren().addAll();
        return new Scene(layout, 300, 450);
    }






    /**
     *
     * Button click logic
     *
     */

    /**
     * Main menu buttons logic
     */
    private void mainMenuButtonClicked(){
        new GUIEventHandler.MainButtonClickedEvent();
        window.setTitle(TitleLabels.MAIN_MENU);
        window.setScene(scene);
    }


    /**
     * JobAds buttons logic
     */
    private void jobAdsButtonClicked(){
        window.setTitle(ButtonLabels.ALL_JOBADS);
        window.setScene(jobAdsScene);
    }




    /**
     * Company buttons logic
     */
    private void companyButtonClicked(){
        if (companies == null)
            companies = BLLCompany.getCompaniesMap();

        if (companyNames != null && companyNames.isEmpty())
            companyNames.addAll(companies.keySet());

        window.setTitle(ButtonLabels.ALL_COMPANIES);
        window.setScene(companiesScene);
    }


    private void showDetailsSelectedButtonClicked(){
        window.setScene(createCompaniesScene());
    }
}
