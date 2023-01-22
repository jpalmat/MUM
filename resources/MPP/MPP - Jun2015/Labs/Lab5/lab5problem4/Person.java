/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5problem4;

// class si final
 final class Person {
    private BirthInfo birthInfo;
    
    // getters on the package level
    BirthInfo getBirthInfo(){
        return this.birthInfo;
    }
    // constructor is on package level
    Person(BirthInfo birthInfo){
        this.birthInfo = birthInfo;
    }
    
    // Factory method is public
    public static Person CreatePerson(BirthInfo birthInfo){
        return new Person(birthInfo);
    }
}
