#include <bits/stdc++.h>

class Point {
   private:
    int x;
    int y;

   public:
    // Constructor
    Point(int xCoord, int yCoord) : x(xCoord), y(yCoord) {
        std::cout << "Point created at (" << x << ", " << y << ")\n";
    }

    // Destructor
    ~Point() { std::cout << "Point destroyed at (" << x << ", " << y << ")\n"; }

    // Method to display coordinates
    void display() const {
        std::cout << "Current position: (" << x << ", " << y << ")\n";
    }

    // Method to move the point
    void move(int dx, int dy) {
        x += dx;
        y += dy;
        std::cout << "Moved by (" << dx << ", " << dy << ")\n";
    }
};

int main() {
    // Create a point
    Point p1(10, 20);
    p1.display();

    // Move the point
    p1.move(5, -3);
    p1.display();

    // Create another point in a block
    {
        Point p2(0, 0);
        p2.display();
        p2.move(2, 2);
        p2.display();
        // p2 will be destroyed here when the block ends
    }

    std::cout << "Back in main after inner block\n";

    // p1 will be destroyed when main() ends
    return 0;
}