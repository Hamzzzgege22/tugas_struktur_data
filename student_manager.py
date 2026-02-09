class StudentArray:
    def __init__(self, capacity=10):
        self.capacity = capacity
        self.array = [None] * capacity
        self.size = 0
    
    def is_full(self):
        return self.size == self.capacity
    
    def is_empty(self):
        return self.size == 0
    
    def insert_at_beginning(self, nim, nama):
        if self.is_full():
            print("❌ Array penuh!")
            return False
        for i in range(self.size, 0, -1):
            self.array[i] = self.array[i - 1]
        self.array[0] = (nim, nama)
        self.size += 1
        print(f"✓ Data '{nama}' ditambahkan di awal.")
        return True
    
    def insert_at_position(self, nim, nama, position):
        if self.is_full():
            print("❌ Array penuh!")
            return False
        if position < 0 or position > self.size:
            print("❌ Posisi tidak valid!")
            return False
        for i in range(self.size, position, -1):
            self.array[i] = self.array[i - 1]
        self.array[position] = (nim, nama)
        self.size += 1
        print(f"✓ Data '{nama}' ditambahkan di posisi {position}.")
        return True
    
    def insert_at_end(self, nim, nama):
        if self.is_full():
            print("❌ Array penuh!")
            return False
        self.array[self.size] = (nim, nama)
        self.size += 1
        print(f"✓ Data '{nama}' ditambahkan di akhir.")
        return True
    
    def delete_from_beginning(self):
        if self.is_empty():
            print("❌ Array kosong!")
            return False
        deleted = self.array[0]
        for i in range(self.size - 1):
            self.array[i] = self.array[i + 1]
        self.array[self.size - 1] = None
        self.size -= 1
        print(f"✓ Data '{deleted[1]}' dihapus dari awal.")
        return True
    
    def delete_at_position(self, position):
        if self.is_empty():
            print("❌ Array kosong!")
            return False
        if position < 0 or position >= self.size:
            print("❌ Posisi tidak valid!")
            return False
        deleted = self.array[position]
        for i in range(position, self.size - 1):
            self.array[i] = self.array[i + 1]
        self.array[self.size - 1] = None
        self.size -= 1
        print(f"✓ Data '{deleted[1]}' dihapus dari posisi {position}.")
        return True
    
    def delete_from_end(self):
        if self.is_empty():
            print("❌ Array kosong!")
            return False
        deleted = self.array[self.size - 1]
        self.array[self.size - 1] = None
        self.size -= 1
        print(f"✓ Data '{deleted[1]}' dihapus dari akhir.")
        return True
    
    def delete_first_occurrence(self, nama):
        if self.is_empty():
            print("❌ Array kosong!")
            return False
        for i in range(self.size):
            if self.array[i][1] == nama:
                deleted = self.array[i]
                for j in range(i, self.size - 1):
                    self.array[j] = self.array[j + 1]
                self.array[self.size - 1] = None
                self.size -= 1
                print(f"✓ Data '{deleted[1]}' dihapus.")
                return True
        print(f"❌ Data '{nama}' tidak ditemukan!")
        return False
    
    def show_all(self):
        if self.is_empty():
            print("❌ Array kosong!")
            return
        print("\n" + "="*60)
        print(f"{'Posisi':<8} {'NIM':<15} {'Nama':<30}")
        print("="*60)
        for i in range(self.size):
            nim, nama = self.array[i]
            print(f"{i:<8} {nim:<15} {nama:<30}")
        print("="*60)
        print(f"Total data: {self.size}/{self.capacity}\n")


def main():
    student_array = StudentArray(capacity=10)
    while True:
        print("\n" + "="*60)
        print("PROGRAM MANAJEMEN DATA MAHASISWA")
        print("="*60)
        print("1. Insert at beginning")
        print("2. Insert at given position")
        print("3. Insert at end")
        print("4. Delete from beginning")
        print("5. Delete at given position")
        print("6. Delete from end")
        print("7. Delete first occurrence")
        print("8. Show all data")
        print("9. Exit")
        print("="*60)
        
        choice = input("Pilih menu (1-9): ").strip()
        
        if choice == '1':
            nim = input("NIM: ").strip()
            nama = input("Nama: ").strip()
            student_array.insert_at_beginning(nim, nama)
        elif choice == '2':
            nim = input("NIM: ").strip()
            nama = input("Nama: ").strip()
            try:
                pos = int(input("Posisi: ").strip())
                student_array.insert_at_position(nim, nama, pos)
            except ValueError:
                print("❌ Input tidak valid!")
        elif choice == '3':
            nim = input("NIM: ").strip()
            nama = input("Nama: ").strip()
            student_array.insert_at_end(nim, nama)
        elif choice == '4':
            student_array.delete_from_beginning()
        elif choice == '5':
            try:
                pos = int(input("Posisi: ").strip())
                student_array.delete_at_position(pos)
            except ValueError:
                print("❌ Input tidak valid!")
        elif choice == '6':
            student_array.delete_from_end()
        elif choice == '7':
            nama = input("Nama: ").strip()
            student_array.delete_first_occurrence(nama)
        elif choice == '8':
            student_array.show_all()
        elif choice == '9':
            print("✓ Selesai!")
            break
        else:
            print("❌ Menu tidak valid!")


if __name__ == "__main__":
    main()
