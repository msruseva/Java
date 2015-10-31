package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        File module = new File("resources\\installed_modules\\lodash");
        module.mkdir();

        String dependency = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("resources\\dependencies.json")));
            String line = reader.readLine();
            Map<String, String> getDependency = new HashMap<>();

            while(line != null){
                if (line.equals("{") || line.equals("}")){
                    line = reader.readLine();
                }else{
                    String[] words = line.split(" ");
                    ArrayList<String> clearWords = new ArrayList<>();

                    for (int i = 0; i < words.length; i++){
                        words[i] = words[i].replace("\"", "" );
                        words[i] = words[i].replace(":", "" );
                        words[i] = words[i].replace("[", "" );
                        words[i] = words[i].replace(",", "" );
                        words[i] = words[i].replace("]", "" );

                        if(words[i].equals("")){
                            continue;
                        }else{
                            clearWords.add(words[i]);
                        }
                    }

                    getDependency.put(clearWords.get(0), clearWords.get(1));
                    line = reader.readLine();
                }
            }

            dependency = getDependency.get("dependencies");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("resources\\all_packages.json")));
            String line = reader.readLine();
            Map<String, List<String>> getModules = new HashMap<>();

            while(line != null){
                if(line.equals("{") || line.equals("}")){
                    line = reader.readLine();
                }else{
                    List<String> values = new ArrayList<>();
                    String[] words = line.split(" ");
                    ArrayList<String> clearWords = new ArrayList<>();

                    for(int i = 0; i < words.length; i++){
                        words[i] = words[i].replace("\"", "");
                        words[i] = words[i].replace(":", "");
                        words[i] = words[i].replace("[", "");
                        words[i] = words[i].replace(",", "");
                        words[i] = words[i].replace("]", "");

                        if(words[i].equals("")){
                            continue;
                        }else{
                            clearWords.add(words[i]);
                        }
                    }

                    if(clearWords.size() > 1){
                        for(int i = 1; i <clearWords.size(); i++){
                            values.add(clearWords.get(i));
                        }
                    }

                    getModules.put(clearWords.get(0), values);
                    line = reader.readLine();
                }
            }

            installModules(dependency, getModules);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void installModules(String module, Map<String, List<String>> getModules){
        File directory = new File("resources\\installed_modules\\" + module);

        if(!directory.exists()){
            System.out.println("Installing " + module);
            directory.mkdir();
            List<String> values = getModules.get(module);

            if(values.size() > 0 && values.size() < 2){
                System.out.print("In order to install " + module + " you need");
                for (String value : values) {
                    System.out.print(value);
                }
                System.out.println(".");
            }else if(values.size() > 0 && values.size() >= 2){
                System.out.print("In order to install " + module + " you need");
                for(int i = 1; i < values.size() - 1; i++){
                    System.out.print(values.get(i) + " and ");
                }
                System.out.println(values.get(values.size() - 1) + ".");
            }

            for (String value : values) {
                installModules(value, getModules);
            }
        }else{
            System.out.println(module + " is already installed. ");
        }
    }
}
