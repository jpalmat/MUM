/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5problem4;

// class if fianl
 final class BirthInfo {
    private Person person;
    
    // constructor is on package level
    BirthInfo(){
        
    }
    
    // getters on the package level
    Person getPerson(){
        return this.person;
    }
    
    // Factory method is public
    public CreatePerson BirthInfo CreateBirthInfo(){
        return new BirthInfo();
    }
    
    
    
}
