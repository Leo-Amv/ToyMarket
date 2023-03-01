package ru.gb.market.data;

import java.util.List;

public interface IService {
    public void addToys(String name, Integer count, Integer chance);
    public void raffleToys(String firstName, String lastName, String phone);
    public void getPrize(Long id) throws Exception;
    public List<Toy> getAllToys();
    public List<Prize> getAllPrizes();
}
