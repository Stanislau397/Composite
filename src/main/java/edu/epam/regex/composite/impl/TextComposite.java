package edu.epam.regex.composite.impl;

import edu.epam.regex.composite.ComponentType;
import edu.epam.regex.composite.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private ComponentType type;
    private List<TextComponent> components;

    public TextComposite(ComponentType type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    public ComponentType getType() {
        return type;
    }

    public List<TextComponent> getComponents() {
        List<TextComponent> textType = new ArrayList<>(components);
        return textType;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent textComponent : components) {
            sb.append(textComponent);
        }
        return sb.toString();
    }
}
