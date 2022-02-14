package com.example.calcolatrice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class ControllerCalcolatrice {
    @FXML
    private TextArea textArea;
    private String op1;
    private String operator;
    private String resultStr;
    public ControllerCalcolatrice(){
        op1=null;
        operator=null;
    }
    @FXML
    public void inputButton(ActionEvent event) {
        Button button=(Button) event.getTarget();
        textArea.setText(textArea.getText()+button.getText());
    }

    @FXML
    protected void equal(){
        double result=0;

        switch(operator){
            case "+":{
                result=Double.valueOf(op1)+Double.valueOf(check(textArea.getText()));
                break;
            }
            case "-":{
                result=Double.valueOf(op1)-Double.valueOf(check(textArea.getText()));
                break;
            }
            case "*":{
                result=Double.valueOf(op1)*Double.valueOf(check(textArea.getText()));
                break;
            }
            case "/":{
                result=Double.valueOf(op1)/Double.valueOf(check(textArea.getText()));
                break;
            }
        }
        resultStr=""+result;
        textArea.setText(resultStr);
        textArea.setScrollLeft(textArea.getText().length());
        op1=null;
        operator=null;
    }
    @FXML
    protected void delete(){
        String inner=textArea.getText();
        String newStr=inner.substring(0,inner.length()-1);
        textArea.setText(newStr);
    }
    @FXML
    protected void ans(){
        textArea.setText(resultStr);
    }
    @FXML
    protected void deleteAll(){
        textArea.setText(resultStr);
    }
    private String check(String input){
        String charInput="0123456789.";
        boolean bool;
        char [] charCalculator=charInput.toCharArray();
        char [] out=new char[input.length()];
        int counter=0;
        for(char compare:input.toCharArray()){
            bool=false;
            for(char elem:charCalculator){
               if(compare==elem){
                   bool=true;
               }
            }
            if(bool){
                out[counter++]=compare;
            }
        }
        return String.valueOf(out);
    }
    @FXML
    public void operator(ActionEvent event){
        Button button=(Button)event.getTarget();
        if(operator==null){
            operator=button.getText();
            op1=textArea.getText();
            textArea.setText(button.getText()+"");
        }
        else{
            equal();
        }
    }
    public void printKey(KeyEvent keyEvent) {
        String elem=keyEvent.getText();
        if(elem.equals("+")||elem.equals("-")||elem.equals("/")||elem.equals("*")){
            if(operator==null){
                op1=check(textArea.getText());
                System.err.println(op1);
                operator=elem;
                textArea.setText("");
            }
            else{
                equal();
            }
        }
        if((int)elem.toCharArray()[0]==13){
            equal();
        }
    }
}