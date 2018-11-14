package com.company;

import com.company.wars.Decryptor;

public class Main {

    //2952410b-0a94-446b-8bcb-448dc6e30b08 -> 22-10-42-edcb86430
    //6f9c15fa-ef51-4415-afab-36218d76c2d9 -> 73-15-46-dc9876321
    //2ab81c9b-1719-400c-a676-bdba976150eb -> 64-9-35-edba976510

    private static final String IN = "2ab81c9b-1719-400c-a676-bdba976150eb";

    public static void main(String[] args) {

        Decryptor decryptor = new Decryptor();
        System.out.println("-----> DECRYP COORDINATES <-----");
        System.out.println(decryptor.decryptCoordinates(IN));

    }
}
