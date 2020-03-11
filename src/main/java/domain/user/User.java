package domain.user;

import java.util.ArrayList;
import java.util.List;

import domain.deck.Card;

public abstract class User {

    private static final String EMPTY = "";
    protected List<Card> cards;
    protected final String name;

    protected User(String name) {
        validate(name);
        cards = new ArrayList<>();
        this.name = name;
    }

    private void validate(String name) {
        if (EMPTY.equals(name)) {
            throw new IllegalArgumentException("빈 이름이 있습니다.");
        }
    }

    public String getName() {
        return name;
    }
}