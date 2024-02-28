package io.loopcamp.utilities;

public class CurrentDocuportUser {
    private static String username;
    private static String password;
    private static CurrentDocuportUser instance;

    private CurrentDocuportUser(){}

    public static CurrentDocuportUser getCurrentUser(){
        if(instance == null){
            instance = new CurrentDocuportUser();
        }
        return instance;
    }

    public static String getUsername(){
        return username;
    }

}
