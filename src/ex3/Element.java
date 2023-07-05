package ex3;

public class Element implements Comparable<Element>{
    private String word;
    private int count;

    public Element(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(word).append(" ").append(count);
        return new String(result);
    }

    @Override
    public int compareTo(Element el) {
        if (this.count == el.count) {return 0;}
        else if (this.count > el.count) { return -1;}
        else return 1;
    }
}
