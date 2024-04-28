package main.java;

public class Main<T> {
    public static void main(String[] args) {
        while (true) {
            boolean isExit = false;
            MyUtils.printStructureChoser();
            int structChoice = MyUtils.getStructureChoice();

            MyList struct = getStruct(structChoice);

            while (!isExit) {
                MyUtils.printMyListActions();
                int action = MyUtils.getMyListActionChoice();
                if (action == 19) {
                    isExit = true;
                } else if (action == 1) {
                    MyUtils.printAddChoices();
                    int addChoice = MyUtils.getAddChoice();

                    if (addChoice == 1) {
                        MyUtils.printEnterElement();
                        Object item = MyUtils.getItemInput();
                        struct.add(item);
                    } else {
                        System.out.println("How much elements?: ");
                        int elemNum = MyUtils.getIndexInput();
                        for (int i = 0; i < elemNum; i++) {
                            MyUtils.printEnterElement();
                            Object item = MyUtils.getItemInput();
                            struct.add(item);
                        }
                    }
                } else if (action == 2) {
                    MyUtils.printEnterIndex();
                    int index = MyUtils.getIndexInput();
                    MyUtils.printEnterElement();
                    Object item = MyUtils.getItemInput();
                    struct.set(index,item);

                } else if (action == 3) {
                    MyUtils.printEnterIndex();
                    int index = MyUtils.getIndexInput();
                    MyUtils.printEnterElement();
                    Object item = MyUtils.getItemInput();
                    struct.add(index,item);
                } else if (action == 4) {
                    MyUtils.printEnterElement();
                    Object item = MyUtils.getItemInput();
                    struct.addFirst(item);
                } else if (action == 5) {
                    MyUtils.printEnterElement();
                    Object item = MyUtils.getItemInput();
                    struct.addLast(item);
                } else if (action == 6) {
                    MyUtils.printEnterIndex();
                    int index = MyUtils.getIndexInput();
                    Object item = struct.get(index);
                    System.out.println("\nHere is your item at "+index+": "+item);
                } else if (action == 7) {
                    Object item = struct.getFirst();
                    System.out.println("\nHere is your first item: "+item);
                } else if (action == 8) {
                    Object item = struct.getLast();
                    System.out.println("\nHere is your last item: "+item);
                } else if (action == 9) {
                    MyUtils.printEnterIndex();
                    int index = MyUtils.getIndexInput();
                    struct.remove(index);
                    System.out.println("\nHere is your struct after change:");
                    printStruct(struct);
                } else if (action == 10) {
                    struct.removeFirst();
                    System.out.println("\nHere is your struct after change:");
                    printStruct(struct);
                } else if (action == 11) {
                    struct.removeLast();
                    System.out.println("\nHere is your struct after change:");
                    printStruct(struct);
                } else if (action == 12) {
                    System.out.println("\nHere is your struct before sort: ");
                    printStruct(struct);
                    struct.sort();
                    System.out.println("\nHere is your sorted struct: ");
                    printStruct(struct);
                } else if (action == 13) {
                    MyUtils.printEnterElement();
                    Object elem = MyUtils.getItemInput();
                    int index = struct.indexOf(elem);
                    System.out.println("\nYour element is at "+index);
                } else if (action == 14) {
                    MyUtils.printEnterElement();
                    Object elem = MyUtils.getItemInput();
                    int index = struct.lastIndexOf(elem);
                    System.out.println("\nYour last index of element is at "+index);
                } else if (action == 15) {
                    MyUtils.printEnterElement();
                    Object elem = MyUtils.getItemInput();
                    boolean isExists = struct.exists(elem);
                    if(isExists){
                        System.out.println("\nYour element exists");
                    }else{
                        System.out.println("\nYour element does not exist");
                    }

                } else if (action == 16) {
                    Object[] arr = struct.toArray();
                    System.out.println("\nHere is your array of a struct: ");
                    System.out.print("[");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]+",");
                    }
                    System.out.println("]");
                }
                else if(action == 17){
                    struct.clear();
                }
                else if (action == 18) {
                    System.out.println("\nThe size of your struct is: "+struct.size());
                }
            }
        }
    }

    private static void printStruct(MyList t){
        System.out.print("\n{");
        for (int i = 0; i <t.size(); i++) {
            System.out.print(t.get(i)+",");
        }
        System.out.print("}");
    }


     private static MyList getStruct(int num) {
     MyList struct;
     if (num == 1) {
     struct = new MyArrayList<>();
     } else if (num == 2) {
     struct = new MyLinkedList<>();
     } else if (num == 3) {
     struct = new MyArrayList<>();
     } else if (num == 4) {
     struct = new MyArrayList<>();
     } else {
     struct = new MyArrayList<>();
     }
     return struct;
     }
}
