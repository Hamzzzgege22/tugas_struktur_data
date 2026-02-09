import java.util.Scanner;

public class StudentArray {
    private static class Student {
        String nim;
        String nama;
        
        Student(String nim, String nama) {
            this.nim = nim;
            this.nama = nama;
        }
    }
    
    private Student[] array;
    private int size;
    private int capacity;
    
    public StudentArray(int capacity) {
        this.capacity = capacity;
        this.array = new Student[capacity];
        this.size = 0;
    }
    
    public StudentArray() {
        this(10);
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean insertAtBeginning(String nim, String nama) {
        if (isFull()) {
            System.out.println("❌ Array penuh!");
            return false;
        }
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = new Student(nim, nama);
        size++;
        System.out.println("✓ Data '" + nama + "' ditambahkan di awal.");
        return true;
    }
    
    public boolean insertAtPosition(String nim, String nama, int position) {
        if (isFull()) {
            System.out.println("❌ Array penuh!");
            return false;
        }
        if (position < 0 || position > size) {
            System.out.println("❌ Posisi tidak valid!");
            return false;
        }
        for (int i = size; i > position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = new Student(nim, nama);
        size++;
        System.out.println("✓ Data '" + nama + "' ditambahkan di posisi " + position + ".");
        return true;
    }
    
    public boolean insertAtEnd(String nim, String nama) {
        if (isFull()) {
            System.out.println("❌ Array penuh!");
            return false;
        }
        array[size] = new Student(nim, nama);
        size++;
        System.out.println("✓ Data '" + nama + "' ditambahkan di akhir.");
        return true;
    }
    
    public boolean deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("❌ Array kosong!");
            return false;
        }
        Student deleted = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        System.out.println("✓ Data '" + deleted.nama + "' dihapus dari awal.");
        return true;
    }
    
    public boolean deleteAtPosition(int position) {
        if (isEmpty()) {
            System.out.println("❌ Array kosong!");
            return false;
        }
        if (position < 0 || position >= size) {
            System.out.println("❌ Posisi tidak valid!");
            return false;
        }
        Student deleted = array[position];
        for (int i = position; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        System.out.println("✓ Data '" + deleted.nama + "' dihapus dari posisi " + position + ".");
        return true;
    }
    
    public boolean deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("❌ Array kosong!");
            return false;
        }
        Student deleted = array[size - 1];
        array[size - 1] = null;
        size--;
        System.out.println("✓ Data '" + deleted.nama + "' dihapus dari akhir.");
        return true;
    }
    
    public boolean deleteFirstOccurrence(String nama) {
        if (isEmpty()) {
            System.out.println("❌ Array kosong!");
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[i].nama.equals(nama)) {
                Student deleted = array[i];
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                System.out.println("✓ Data '" + deleted.nama + "' dihapus.");
                return true;
            }
        }
        System.out.println("❌ Data '" + nama + "' tidak ditemukan!");
        return false;
    }
    
    public void showAll() {
        if (isEmpty()) {
            System.out.println("❌ Array kosong!");
            return;
        }
        System.out.println("\n" + "=".repeat(60));
        System.out.printf("%-8s %-15s %-30s%n", "Posisi", "NIM", "Nama");
        System.out.println("=".repeat(60));
        for (int i = 0; i < size; i++) {
            System.out.printf("%-8d %-15s %-30s%n", i, array[i].nim, array[i].nama);
        }
        System.out.println("=".repeat(60));
        System.out.println("Total data: " + size + "/" + capacity + "\n");
    }
    
    public static void main(String[] args) {
        StudentArray studentArray = new StudentArray(10);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("PROGRAM MANAJEMEN DATA MAHASISWA");
            System.out.println("=".repeat(60));
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at given position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete at given position");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete first occurrence");
            System.out.println("8. Show all data");
            System.out.println("9. Exit");
            System.out.println("=".repeat(60));
            
            System.out.print("Pilih menu (1-9): ");
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    System.out.print("NIM: ");
                    String nim1 = scanner.nextLine().trim();
                    System.out.print("Nama: ");
                    String nama1 = scanner.nextLine().trim();
                    studentArray.insertAtBeginning(nim1, nama1);
                    break;
                case "2":
                    System.out.print("NIM: ");
                    String nim2 = scanner.nextLine().trim();
                    System.out.print("Nama: ");
                    String nama2 = scanner.nextLine().trim();
                    System.out.print("Posisi: ");
                    try {
                        int position = Integer.parseInt(scanner.nextLine().trim());
                        studentArray.insertAtPosition(nim2, nama2, position);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Input tidak valid!");
                    }
                    break;
                case "3":
                    System.out.print("NIM: ");
                    String nim3 = scanner.nextLine().trim();
                    System.out.print("Nama: ");
                    String nama3 = scanner.nextLine().trim();
                    studentArray.insertAtEnd(nim3, nama3);
                    break;
                case "4":
                    studentArray.deleteFromBeginning();
                    break;
                case "5":
                    System.out.print("Posisi: ");
                    try {
                        int position = Integer.parseInt(scanner.nextLine().trim());
                        studentArray.deleteAtPosition(position);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Input tidak valid!");
                    }
                    break;
                case "6":
                    studentArray.deleteFromEnd();
                    break;
                case "7":
                    System.out.print("Nama: ");
                    String namaDelete = scanner.nextLine().trim();
                    studentArray.deleteFirstOccurrence(namaDelete);
                    break;
                case "8":
                    studentArray.showAll();
                    break;
                case "9":
                    System.out.println("✓ Selesai!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Menu tidak valid!");
            }
        }
        scanner.close();
    }
}
