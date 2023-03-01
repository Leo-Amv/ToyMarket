package ru.gb.market.service;

import ru.gb.market.data.IService;
import ru.gb.market.data.Prize;
import ru.gb.market.data.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyService implements IService {
    private final List<Toy> allToys;
    private final List<Prize> prizeList;
    private final Integer max_chance = 100;

    public ToyService() {
        this.allToys = new ArrayList<>();
        this.prizeList = new ArrayList<>();
    }

    @Override
    public void addToys(String name, Integer count, Integer chance) {
        Long id = 0L;
        for(Toy item: this.allToys) {
            if(id < item.getId()) {
                id = item.getId();
            }
        }
        Toy toy = new Toy(++id, name, count, chance) { };
        this.allToys.add(toy);
    }

    @Override
    public void raffleToys(String firstName, String lastName, String phone) {
        Random r = new Random();
        int randNum = r.nextInt(this.allToys.size());
        int randChance = r.nextInt(max_chance);
        if (randChance <= this.allToys.get(randNum).getChance()) {
            Long id = 0L;
            for(Prize item: this.prizeList) {
                if(id < item.getId()) {
                    id = item.getId();
                }
            }
            Prize prize = new Prize(++id, this.allToys.get(randNum).getName(), 1,
                    this.allToys.get(randNum).getChance(), firstName, lastName, phone);
            this.prizeList.add(prize);
            if (this.allToys.get(randNum).getCount() == 1) {
                this.allToys.remove(this.allToys.get(randNum));
            }
            else if (this.allToys.get(randNum).getCount() > 1) {
                this.allToys.get(randNum).setCount(this.allToys.get(randNum).getCount() - 1);
            }
            System.out.println("Congratulations! Your prize : " + prize.getName());
        }
        else {
            System.out.println("Good luck next time!");
        }
    }

    @Override
    public void getPrize(Long id) throws Exception {
        boolean flag = false;
        for (Prize toy: this.prizeList) {
            if (id.equals(toy.getId())) {
                this.prizeList.remove(toy);
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new Exception("Prize not found!");
        }
    }

    @Override
    public List<Toy> getAllToys() {
        return this.allToys;
    }

    @Override
    public List<Prize> getAllPrizes() {
        return this.prizeList;
    }
    public Prize searchPrize(Long id) {
        for (Prize toy: this.prizeList) {
            if (id.equals(toy.getId())) {
                return toy;
            }
        }
        throw new IllegalStateException("Toy not found!");
    }
    public void updateToy(Long id, Integer chance) throws Exception {
        String name;
        Integer count;
        boolean flag = false;
        for (Toy toy : this.allToys) {
            if (toy.getId().equals(id)) {
                name = toy.getName();
                count = toy.getCount();
                Toy updateToy = new Toy(id, name, count, chance);
                this.allToys.remove(toy);
                this.allToys.add(updateToy);
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new Exception("Toy not found!");
        }
    }
}
