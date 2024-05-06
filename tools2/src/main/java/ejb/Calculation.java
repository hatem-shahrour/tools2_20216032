
package ejb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private int number1;

    @Column
    private int number2;

    @Column
    private String operation;
    
    @Column 
    private int result;

    public int CalculateResult() {
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        return result;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
    	this.operation = operation;
    }

}
