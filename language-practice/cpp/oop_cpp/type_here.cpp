// this is to learn OOP in CPP

#include <iostream>
using namespace std;

class AbstractStudent {
    virtual void askForGrades() = 0;  // pure virtual. must be implemented
};  // abstraction

class Student : AbstractStudent {
   protected:
    string name;

   private:
    int age;  // members are private by default

   public:  // encapsulation
    // private inside class only
    // public accessible outside the class
    // protected available in child classes

    // constructor
    Student(string name, int age) {
        this->name = name;
        this->age = age;
    }

    void set_name(string name) {
        if (name != "anish") {
            this->name = name;
        }
    }

    string get_name() { return name; }

    void introduce() {
        cout << endl;
        cout << "hello, i am " << name << " aged " << age;
    }

    void askForGrades() {
        if (age > 10) {
            cout << endl << name << " got his grades.";
        } else {
            cout << endl << "grade not given.";
        }
    }

    virtual void study() { cout << endl << name << " studies like a student."; }
};

class Monitor
    : public Student {  // inheritance is private by default. so you cant use
                        // methods in main thru child classes. make it public
   public:
    string fav_lang;

    Monitor(string name, int age, string lang)
        : Student(  // this is the super equivalent of java
              name,
              age) {  // need to provide constructors if we inherit a class that
        // doesnt have a default constructor

        fav_lang = lang;
    }

    void write_names() {
        cout << endl
             << name << " wrote names using "
             << fav_lang;  // if name is insid eprivate: then use get_name()
    }

    void study() { cout << endl << name << " studies like a monitor."; }
};

class BackBencher : public Student {
   public:
    string bad_habit;

    BackBencher(string name, int age, string bad_habit) : Student(name, age) {
        this->bad_habit = bad_habit;
    }

    void play_in_class() {
        cout << endl << name << "'s bad habit: " << bad_habit << ".";
    }

    void study() { cout << endl << name << " doesn't like to study."; }
};

int main() {
    int num;
    Student s1 = Student("anish", 21);
    // s1.age = 21;
    // s1.name = "Anish";

    s1.introduce();
    s1.set_name("coolGuy123");
    s1.set_name("anish");
    cout << endl << s1.get_name();
    s1.introduce();
    s1.askForGrades();

    Monitor m1 = Monitor("broccoli", 400, "C++");
    m1.write_names();
    m1.askForGrades();  // inheritance is private by default

    BackBencher b1 =
        BackBencher("pineapplePizza", 20, "puts pinapple on pizza");
    b1.play_in_class();
    b1.askForGrades();

    s1.study();
    m1.study();
    b1.study();  // this is polymorphism

    Student* sp1 = &m1;  // pointer
    Student* sp2 = &b1;  // pointer

    sp1->study();  // when you use a pointer you use -> and not .
    sp2->study();  // these do not work // make the study() method virtual in
                   // parent class and then it works

    // for a virtual method. if an definition/own implementation exist in
    // derived class, tehn execute that instead
}

// OOP concepts:
// encapsulation ✓
// abstraction ✓
// inheritance ✓
// polymorphism ✓