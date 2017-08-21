package com.company;

import javafx.stage.Stage;

public class GUIEventHandler {

    public static class MainButtonClickedEvent {
        public MainButtonClickedEvent(){
            doSomething();
        }

        private void doSomething(){
            System.out.println("doing stuff");
        }

    }


    public static class ShowDetailsSelectedCompanyButtonClickedEvent {
        Stage window;
        public ShowDetailsSelectedCompanyButtonClickedEvent(Stage primaryStage){
            window = primaryStage;
            doSomething();
        }

        private void doSomething(){
            window.setTitle("Selected company");
        }

    }




}

