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

    // Copy Constructor
    Point(const Point& other) : x(other.x), y(other.y) {
        std::cout << "Point COPIED from (" << other.x << ", " << other.y
                  << ")\n";
    }

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

    friend void print_point(Point point);
};

void print_point(Point point) {
    std::cout << point.x << " " << point.y << std::endl;
}

// Point::static_var=0; this is a static var and needs to be decalred outside
// the class // Point::method_name to access. static cant access non-static ones

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

    // print_point(p1);
    std::cout << "Back in main after inner block\n";

    // p1 will be destroyed when main() ends
    return 0;
}