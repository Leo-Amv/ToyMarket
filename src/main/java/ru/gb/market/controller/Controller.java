package ru.gb.market.controller;

import ru.gb.market.data.Prize;
import ru.gb.market.data.Toy;
import ru.gb.market.service.ToyService;
import ru.gb.market.view.FileView;
import ru.gb.market.view.ToyView;

import java.util.List;

public class Controller {
    private final ToyService ts = new ToyService();
    private final ToyView tv = new ToyView();
    private final FileView fv = new FileView();

    public void createToy(String name, Integer count, Integer chance) {
        ts.addToys(name, count, chance);
        fv.writeFileToy(getAllToysList());
    }

    public void updateToy(Long id, Integer chance) {
        try {
            ts.updateToy(id, chance);
        } catch (Exception e) {
            throw new IllegalStateException("Игрушка не найдена!");
        }
        fv.writeFileToy(getAllToysList());
    }

    public void getRuffle(String firstname, String lastname, String phone) {
        ts.raffleToys(firstname, lastname, phone);
        fv.writeFileToy(getAllToysList());
        fv.writeFilePrize(getPrizeList());
    }

    public void getPrize(Long id) {
        try {
            ts.getPrize(id);
        } catch (Exception e) {
            throw new IllegalStateException("Prize not found!");
        }
        fv.writeFilePrize(getPrizeList());
    }

    public List<Toy> getAllToysList() {
        return ts.getAllToys();
    }

    public void showToysList(List<Toy> toysList) {
        tv.showAllToys(toysList);
    }

    public List<Prize> getPrizeList() {
        return ts.getAllPrizes();
    }

    public void showPrizeList(List <Prize> prizeList) {
        tv.showAllPrizes(prizeList);
    }

    public void showPrize(Prize prize) {
        tv.showPrize(prize);
    }

    public Prize searchPrize(Long id) {
        return ts.searchPrize(id);
    }
}
