package ru.gb.market.view;

import ru.gb.market.data.Prize;
import ru.gb.market.data.Toy;

import java.util.List;
import java.util.logging.Logger;

public class ToyView {
    Logger log = Logger.getAnonymousLogger();

    public void showAllToys(List<Toy> toyList) {
        log.info("List of all toys: ");
        for (Toy toy: toyList) {
            log.info(toy.toString());
        }
    }

    public void showAllPrizes(List<Prize> prizeList) {
        log.info("List of all prizes: ");
        for (Prize toy: prizeList) {
            log.info(toy.toString());
        }
    }

    public void showPrize(Prize prize) {
        log.info("New toy won: " + prize.toString());
    }
}
