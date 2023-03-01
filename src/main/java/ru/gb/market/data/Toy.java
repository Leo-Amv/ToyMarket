package ru.gb.market.data;

public abstract class Toy {
    private Long id;
    private String name;
    private Integer count;
    private Integer chance;

    public Toy(Long id, String name, Integer count, Integer chance) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.chance = chance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getChance() {
        return chance;
    }

    public void setChance(Integer chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + name + ", count=" + count + ", chance=" + chance + "]";
    }
}
