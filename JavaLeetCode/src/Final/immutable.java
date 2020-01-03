package Final;


public class immutable {
    public static void main(String[] args) {

        String name = "baeldung";
        String newName = name.replace("dung", "----");

        System.out.println("baeldung"==name);
        System.out.println("bael----"  ==newName);

    }

}
