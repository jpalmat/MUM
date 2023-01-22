/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5problem4;

/**
 *
 * @author Maged Samaan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // if creation needed outside the package
        Person p1 = Person.CreatePerson(BirthInfo.CreateBirthInfo());
        
        // coz the this file in the same package the constructors are accessable
        Person p2 =new Person(new BirthInfo());
    }
    
}
