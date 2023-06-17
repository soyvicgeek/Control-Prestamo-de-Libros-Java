package view.utils;

import view.components.InputIcon;

public class Validates {
    private InputIcon lblTag;
    private String txt;
    private Boolean isNumber;
    
    public Validates(InputIcon lblTag, String txt, Boolean isNumber) {
        this.lblTag = lblTag;
        this.txt = txt;
        this.isNumber = isNumber;
    }
    
    public String validateInput() {
        
        if(isNumber && !lblTag.getText().matches("[0-9]+")) {
            return "El campo '"+txt+"' sólo admite número";
        } else {
            if (lblTag.getText().equals("") || lblTag.getText().equals(txt)){
                return "El Campo '"+txt+"' no puede ir vacío";
            } else {
                return "OK";
            }
        }
    }
}
