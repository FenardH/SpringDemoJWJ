package be.bstorm.akimts.mvc.services;

import be.bstorm.akimts.mvc.models.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CalculatorService {
    private String input = "";
    private StringBuilder result = new StringBuilder("");

    public void click(String input){
        this.input = input;
        this.result.append(input);
    }

    public String getInput() {
        return input;
    }
    public String calculate(){
        String[] operators = Pattern.compile("[0-9]").split(this.result);
        String[] operands = Pattern.compile("[*+-/%]").split(this.result);
        int agregate = Integer.parseInt(operands[0]);
        int o = 1;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals("+")) {
                agregate += Integer.parseInt(operands[o++]);
            } else if (operators[i].equals("-")) {
                agregate -= Integer.parseInt(operands[o++]);
            } else if (operators[i].equals("*")) {
                agregate *= Integer.parseInt(operands[o++]);
            } else if(operators[i].equals("/")) {
                agregate /= Integer.parseInt(operands[o++]);
            } else {
                agregate %= Integer.parseInt(operands[o++]);
            }
        }
        return String.valueOf(agregate);
    }
}
