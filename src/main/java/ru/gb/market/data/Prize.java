package ru.gb.market.data;

public class Prize extends Toy{
    protected String firstname;
    protected String lastname;
    protected String phone;

    public Prize(Long id, String name, Integer count, Integer chance, String firstname, String lastname, String phone) {
        super(id, name, count, chance);
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Prize [id=" + super.getId() + ", toy-name=" + super.getName() + ", count=" + super.getCount() +
                ", chance=" + super.getChance() + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + "]";
    }
}
