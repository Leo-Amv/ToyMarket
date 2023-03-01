package ru.gb.market.data;

import java.util.List;

public interface IService {
    void addToys(String name, Integer count, Integer chance);
    void raffleToys(String firstName, String lastName, String phone);
    void getPrize(Long id) throws Exception;
    List<Toy> getAllToys();
    List<Prize> getAllPrizes();
}
