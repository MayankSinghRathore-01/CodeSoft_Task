#include <iostream>
#include <vector>
using namespace std;
int main() {
vector<string> todoList;
string task;
cout<<"my second task"<<endl;
cout<<"Welcome to my to-do list program!" << endl;
  while (true) {
 cout<<"Enter a task to add to my to-do list (or 'quit' to exit): ";
   getline(cin, task);

        if (task == "quit") {
            break;
        }

 todoList.push_back(task);
 cout << "Task added to my to-do list!" << endl;
    }
 cout << endl << "my to-do list:" << endl;
   for (int i = 0; i < todoList.size(); i++) {
        cout << i + 1 << ". " << todoList[i] << endl;
    }
    cout << "Thank you for using the to-do list program!" << endl;
    return 0;
}