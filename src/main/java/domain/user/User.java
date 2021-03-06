package domain.user;

import domain.card.Card;
import domain.card.Cards;
import java.util.Collections;
import java.util.List;

public abstract class User implements Comparable<User> {

    protected final Cards cards;
    protected final Name name;

    protected User(String name) {
        cards = new Cards();
        this.name = new Name(name);
    }

    public void draw(Card card) {
        cards.add(card);
    }

    public abstract boolean isAvailableToDraw();

    public boolean isBust() {
        return cards.areBust();
    }

    public boolean isBlackJack() {
        return cards.areBlackJack();
    }

    @Override
    public int compareTo(User user) {
        return calculatePoint() - user.calculatePoint();
    }

    public int calculatePoint() {
        return cards.calculatePoint();
    }

    public String getName() {
        return name.getName();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards.getCards());
    }
}
