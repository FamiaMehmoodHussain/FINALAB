1. Modularity
The system is divided into separate classes: Appliance and HomeAutomationSystem, which encapsulate related functionalities. This makes the code more organized and easier to maintain.
2. Single Responsibility Principle (SRP)
Each class has a single responsibility:
The Appliance class manages individual appliances.
The HomeAutomationSystem class manages the collection of appliances and controls their states.
This division reduces the complexity of each class and makes it easier to modify or extend in the future.
3. Encapsulation
The attributes of the Appliance class (like name and isOn) are private, which means they cannot be accessed directly from outside the class. This is a fundamental principle of encapsulation that ensures the internal state of an object is protected from unintended interference and misuse.
4. Command Pattern
The way the program responds to user inputs through commands like "on" and "off" can be seen as a simple form of the Command Pattern. In a more advanced implementation, commands could be encapsulated as objects, allowing for extendable and flexible command handling.
5. Facade Pattern
The HomeAutomationSystem class acts as a facade, providing a simplified interface to the underlying functionalities of the Appliance objects. This hides the complexity of the appliance management from the user.
6. Open/Closed Principle
The system can be extended easily with new types of appliances (by adding new subclasses of Appliance if needed) without modifying the existing codebase, adhering to the Open/Closed Principle, which states that software entities should be open for extension but closed for modification.
7. List of Available Appliances
The method showAppliances in HomeAutomationSystem lists available appliances without exposing the internal data structure directly, adhering to the principle of abstraction.
8. User Interaction and Feedback
The command-line interface allows for user interaction, giving immediate feedback on actions taken, which is important for usability in any control system.
