package com.cetera.process.engine.client;

public class ArrayDeletion {

    private int deleteFromArray(int arr[], int sizeOfArray, int valueToBeDeleted) {
        if (arr[sizeOfArray - 1] == valueToBeDeleted) {
            return sizeOfArray - 1;
        }

        int lastElement = arr[sizeOfArray - 1];
        int i, currentPtr;
        for (i = sizeOfArray - 2; i > 0; i--) {
            if (arr[i] != valueToBeDeleted) {
                currentPtr = arr[i];
                arr[i] = lastElement;
                lastElement = currentPtr;
            } else {
                break;
            }
        }
        arr[i] = lastElement;
        return sizeOfArray - 1;
    }

    private int killPerson(int persons[], int numberOfPersons) {
        int personsToBeKilled[] = new int[numberOfPersons - 1];

        int counter = 0;
        int elementsAdded = 0;
        int personCounter = 0;
        while (elementsAdded < numberOfPersons - 1) {
            boolean exists = false;
            if (personCounter == numberOfPersons) {
                personCounter = 0;
            }
            for (int personToBeKilled : personsToBeKilled) {
                if (personToBeKilled == persons[personCounter]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                counter++;
            } else {
                personCounter++;
                continue;
            }
            if (counter == 3) {
                if (!exists) {
                    personsToBeKilled[elementsAdded] = persons[personCounter];
                    elementsAdded++;
                    counter = 0;
                }
            }
            personCounter++;
        }

        for (int personToBekilled : personsToBeKilled) {
            numberOfPersons = deleteFromArray(persons, numberOfPersons, personToBekilled);
        }
        return numberOfPersons;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 ,12,13};
        int sizeOfArray = arr.length;
        int numberOfPersons = new ArrayDeletion().killPerson(arr, sizeOfArray);

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
