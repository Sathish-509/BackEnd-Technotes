###Camunda - BPMN 2.0
(Business Process Model and Notation)

Tripple crown of process improvement standard:
BPMN + CMMN + DMN
OMG - Object Management Group- 1989 - Specification freely available @ http://www.omg.org . Path to adoption by ISO

Business Modeling & Integration
OMG Task Force: 
	Issues "Requests for proposals" for new or updated standards.
	Reviews proposed specifications and recommends them for adoption to the OMG technical committee.

7 Specification:
Business Motivation Model(BMM-1.3)
Semantics of Business Vocabulary and Business Rules(SVBR-1.3)
Business Process Model and Notation(BPMN 2.0.2) - is about Processing
Case Management Model and Notation(CMMN 1.1) - is about Management
Decision Modeling Notation(DMN 1.2) - is about deciding
Value Delivery Modeling Language(VDML 1.0)
Date and Time Vocabulary(DTV 1.2)

Facors to use modeling:
Variable -> Every work effort instance looks slightly different (BPMN or DMN)
Unpredictable -> The exact course of action is unknown and highly situation specific. (BPMN or CMMN or DMN)
Emergent -> The exact course of action only emerges during process execution when more information becomes available. (CMMN or DMN).

#BPMN: 
Universal graphical notation for drawing business processes
Readily understandable by business stakeholders.
1, A collection of interrelated activities performed by a person or machine. (Rectangle Box)
2, Performed in response to an independent trigger or start event Ex. complaint from customer (Circle)
3, To deliver a specific result. (Circle with thick border)

Ex; Email from a friend (Start Event)
    Read Letter - Manual Task
    Send Reply - Task
    Letter is read and reply sent - Specific result is delivered.
   
BPMN 2.0 -> Offers the building blocks needed to think about your business processes graphically.
Building blocks:
Events, Activvity(Tasks), GateWays, Flow, Data Objects, Connectors, Subprocesses, Pools & lanes.

BPMN Advantages:
Standards: Owned by an institution(OMG - Object Management Group- 1989), which is already established through other world-wide standards, e.g., UML. The standard is supported by many software products.
Simplicity: Principle behind BPMN is rather simple, which is why you can start working with this notation very quickly.
Power of expression: Can describe precisely how a process functions with BPMN.

#CMMN:
A common meta model and notation for modelling and graphically expressing a case.
Aim to model activities that depends on evolving circumstances and adhoc decisions by knowledge workers.
Provides flexibility via planning at run time.
Basic Elements: 
Stage roundedcorner rectagle 
Task or Discretionary rectangle
Event Listener double rounded circle
Case File item Note symbol
Milestone Rectagle oval.

#DMN: 
A common meta model and notation for describing and modeling repeatable business decisions.
Enables various groups effectively collaborate in defining a decision model.
Provides standard notations for decision tables.
Basic Elements:
Decison : Rectangle
Input: Oval
Business knowledge model: Chopped corner rectangle
Knowledge source: comment box
Arrows:
Information Requirement: Arrow
Knowledge Requirement: dotted arrow
Authority Requirement: dotted with point at the end

---------------------------------------------------------------------------------
BPMN					|	CMMN					|	DMN
---------------------------------------------------------------------------------
processes  				|	Cases					| 	Decision
activities 				|	Events					|	Rules
Transitional 			|	Contextual 				|	Applied
Data 					|	information 			|  	Knowledge
Procedural				| 	Declarative				| 	Funtional
Token					|   Event Condition action 	| 	First Order Logic

Caunda BPM components

Modeler -> used by business analyst or Developer, stores in a file communicates to engine
Tasklist -> used by end user  communicates to engine via rest
CustomApplication
Cockpit -> Used by Operator(technical/business), communicates via rest to the engine
Admin -> Used by administator communicatesto the engine via rest
Engine(BPMN, CMMN, DMN) -> Processes inputs and stores in its own database.

https://docs.camunda.org/enterprise/download/
Modeler, is used to draw the digram.
online modeler: https://cawemo.com/#

Camunda Can be integrated as a standalone or embedded into applications.

Architecture:

Process Engine Public Api:
BPMN 2.0 Core Api:
Job Executor:
The Persistence Layer:

https://docs.camunda.org/get-started/quick-start/install/

http://localhost:8080/camunda-welcome/index.html
demo/demo

Exceptons faced:
Could not parse bpmn process -> 
Reason can be instance name wrong.

http://localhost:8080/engine-rest/process-definition/key/payment-retrieval/start


