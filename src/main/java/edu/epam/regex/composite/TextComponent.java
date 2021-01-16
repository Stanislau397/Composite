package edu.epam.regex.composite;

import java.util.List;

public interface TextComponent {

    void add(TextComponent component);

    void remove(TextComponent component);

    List<TextComponent> getChildren();

    int size();
}
