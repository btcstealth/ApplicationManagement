package com.company;

public class GUIEventHandler {

    public static class MainButtonClickedEvent {
        public MainButtonClickedEvent(){
            doSomething();
        }

        private void doSomething(){
            System.out.println("doing stuff");
        }

    }


}

