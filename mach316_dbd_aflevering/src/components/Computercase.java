/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author MadsNorby
 */
public class Computercase extends Component{
    
    private String formFactor;
    
    public Computercase(String name, String kind, String formFactor, int price, int stock, int minStock, int prefStock, int toBeOrdered) {
        super(name, kind, price, stock, minStock, prefStock, toBeOrdered);
        
        this.formFactor = formFactor;
    }

    public String getFormFactor() {
        return formFactor;
    }
    
}
