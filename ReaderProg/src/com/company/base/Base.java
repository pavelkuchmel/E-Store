package com.company.base;

import com.company.user.User;

import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;

public class Base {

    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User name){
        users.add(name);

    }

    public void addUser(String login, String password){
        User name = new User(login, password);
        users.add(name);
    }

    public void writeInFileUsers(){
        try(FileWriter writer = new FileWriter("E:\\JavaFXCode\\ReaderProg\\src\\com\\company\\base\\users.txt", false))
        {
            for (int i = 0; i < users.size(); i++){
                writer.write(users.get(i).toString());
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public void writeOutFileUsers(){
        ArrayList<Character> buffer = new ArrayList<>();
        String login = "";
        String password = "";
        try(FileReader reader = new FileReader("E:\\JavaFXCode\\ReaderProg\\src\\com\\company\\base\\users.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                //System.out.print((char)c);
                buffer.add((char)c);

            }
            //System.out.println(buffer);

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        char sw = ' ';
        for(Character ch : buffer){
            if (ch == '$') {
                sw = ch;
                continue;
            }
            if (ch == '@') {
                sw = ch;
                continue;
            }
            if (ch == '>'){
                addUser(login, password);
                login = "";
                password = "";
                continue;
            }
            switch (sw){
                case '$':
                    login += ch;
                    break;
                case '@':
                    password += ch;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String text = users.get(4).getLogin();
        String text2 = users.get(4).getPassword();
        return "login="+text+"\npassword="+text2;
    }
}
