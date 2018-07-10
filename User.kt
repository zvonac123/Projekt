package com.example.zvonimir.popquiz

class User {

    private var firstName:String ?=null
    private var email:String ?= null
    private var password:String ?= null
    private var lastName:String ?=null


    constructor(firstName:String,lastName:String,email:String ,password:String){
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.password = password
    }


    public fun getLastName():String{
        return this!!.lastName.toString()

    }



    public fun getFirstName():String{
        return this!!.firstName.toString()
    }


    public fun getEmail():String{
        return this.email.toString()
    }


    public fun getPassword():String{
        return this.password.toString()
    }


}