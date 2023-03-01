package ru.gb.market.view;

import ru.gb.market.data.Prize;
import ru.gb.market.data.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileView {
    public List<Toy> readFileToy() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/ru/gb/market/files/AllToys.csv"));
            List<Toy> toyList = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                List<String> promt = new ArrayList<>(Arrays.asList(str.split(";")));
                Toy toy = new Toy(Long.parseLong(promt.get(0)), promt.get(1),
                        Integer.parseInt(promt.get(2)), Integer.parseInt(promt.get(3))) { };
                toyList.add(toy);
            }
            br.close();
            return toyList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Prize> readFilePrize() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/ru/gb/market/files/AllPrizes.csv"));
            List<Prize> prizeList = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                List<String> promt = new ArrayList<>(Arrays.asList(str.split(";")));
                Prize toy = new Prize(Long.parseLong(promt.get(0)), promt.get(1),
                        Integer.parseInt(promt.get(2)), Integer.parseInt(promt.get(3)),
                        promt.get(4), promt.get(5), promt.get(6));
                prizeList.add(toy);
            }
            br.close();
            return prizeList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void writeFileToy(List<Toy> listToys) {
        try (FileWriter fw = new FileWriter("src/main/java/ru/gb/market/files/AllToys.csv", false)) {
            for (Toy toy: listToys) {
                fw.append(String.format("%s;", toy.getId()));
                fw.append(String.format("%s;", toy.getName()));
                fw.append(String.format("%s;", toy.getCount()));
                fw.append(String.format("%s;\n", toy.getChance()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeFilePrize(List<Prize> prizeList) {
        try (FileWriter fw = new FileWriter("src/main/java/ru/gb/market/files/AllPrizes.csv", false)) {
            for (Prize toy: prizeList) {
                fw.append(String.valueOf(toy.getId())).append(";");
                fw.append(toy.getName()).append(";");
                fw.append(String.valueOf(toy.getCount())).append(";");
                fw.append(String.valueOf(toy.getChance())).append(";");
                fw.append(toy.getFirstname()).append(";");
                fw.append(toy.getLastname()).append(";");
                fw.append(toy.getPhone()).append(";").append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
