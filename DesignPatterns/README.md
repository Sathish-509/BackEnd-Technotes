# Creational (5):
Factory Pattern
When to use:
Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class. 
Adv: 
1, Factory design pattern provides approach to code for interface rather than implementation.
2, Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. 
3, Factory pattern provides abstraction between implementation and client classes through inheritance

DisAdvantes:
A potential disadvantage of Factory methods is that clients might have to sub-class the creator class just to create a particular concrete product object.
In Factory Method pattern, the factory used for creating the objects is bound with the client code, i.e., it is difficult to use a different factory for creating objects.
 Ref: https://stackoverflow.com/questions/929021/what-are-static-factory-methods

 There are two version of factory.
 1, static factory method: To control the number of objects to create.
 2, factory method: A method which separates the instantiation of class from client program.

Implementation: https://github.com/Sathish-509/DesignPatterns-Examples/tree/master/src/factorypattern

Builder
# Structural (7):
# Behavioral (11):
Strategy:
Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.

Strategy pattern is also known as Policy Pattern.
Ex: Collections.sort() method that takes the Comparator parameter
Adv:
Families of related algorithms. Hierarchies of Strategy classes define a family of algorithms or behaviors for contexts to reuse. Inheritance can help factor out common functionality of the algorithms.

Inheritance offers another way to support a variety of algorithms or behaviors. You can subclass a Context class directly to give it different behaviors.

A choice of implementations. Strategies can provide different implementations of the same behavior.

Disadv:
Clients must be aware of different Strategies. The pattern has a potential drawback in that a client must understand how Strategies differ before it can select the appropriate one.
Communication overhead between Strategy and Context. The Strategy interface is shared by all ConcreteStrategy classes whether the algorithms they implement are trivial or complex.
Increased number of objects. Strategies increase the number of objects in an application. Sometimes you can reduce this overhead by implementing strategies as stateless objects that contexts can share.
Command:
ChainofResponsibility