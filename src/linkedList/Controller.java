package linkedList;

public class Controller {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();

        list.addWithoutError(1);
        list.addWithoutError(2);
        list.addWithoutError(3);
        list.addWithoutError(4);
        list.addWithoutError(5);
        System.out.println(list);

        //list reversal
        list.reverse();
        System.out.println(list);

    }//end main
}//end class

//Notes:
//accessing data is linear, not random
//Singly LinkedList has one address--> address of following node
//Doubly LinkedList has two addresses--> address of node before and after
//A linkedList address also known as pointers
//Circular LinkedList: the last node contains address of first node


