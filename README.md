CptS 422 - Program Design and Development
Homework 1: Week of September 3, 2018
Due: September 18, 2018 by midnight
I. Learner Objectives:
At the conclusion of this programming assignment, participants should be able to:
• Analyze a basic set of requirements for a problem and derive logical solutions to them
• Carry out a formal technical review on a simple specification and document the process and
the results.
• Design a program that implements the specification
• Write code to the specification which passes a small functional test suite
• Compare specification defects found in the inspection to those found in design and coding
II. Prerequisites:
Before starting this programming assignment, participants should be able to:
• Summarize topics from “SoftwareTesting book” Chapter 2 and 5 including:
o The Triangle Problem
o Normal boundary value testing
o Robust boundary value testing
o Worst-case boundary value testing
o Robust worst-case boundary value testing
o The general form of a high-level program
III. Overview & Requirements:
This page will be available at Blackboard as Homework01 in Homework s folder. Calling it up
in a browser will allow you to cut-and-paste the template below into your editor and save
editing time. Create a new directory for this lab and cd to it:
$ cd cpts422
$ mkdir cpts422_hw01_<lastname>_<firstname>
$ cd cpts422_hw01_<lastname>_<firstname>
The Triangle Problem
The triangle program accepts three integers, a, b, and c, as input. These are taken to be sides of a triangle.
The integers a, b, and c must satisfy the following conditions:
c1. 1 ≤ a ≤ 200
c2. 1 ≤ b ≤ 200
c3. 1 ≤ c ≤ 200
c4. a < b + c
c5. b < a + c
c6. c < a + b
The output of the program is the type of triangle determined by the three sides: Equilateral, Isosceles,
Scalene, or NotATriangle. If an input value fails any of conditions c1, c2, or c3, the program notes this
with an output message, for example, “Value of b is not in the range of permitted values.” If values of a,
b, and c satisfy conditions c4, c5, and c6, one of four mutually exclusive outputs is given:9/6/2018 Homework 1 – The Triangle Problem
1. If all three sides are equal, the program output is Equilateral.
2. If exactly one pair of sides is equal, the program output is Isosceles.
3. If no pair of sides is equal, the program output is Scalene.
4. If any of conditions c4, c5, and c6 is not met, the program output is NotATriangle
IV. Implementation
In this assignment, you will play the role of a developer at a company. Your team has been asked to
implement an OO solution for triangle problem. Your manager has identified a description of the
triangle definition (section III). Your first task is to perform a inspection, checking the rules for clarity
and completeness, and identifying clarifying questions to ask for the triangle definition.
After the implementation written a few basic test cases to perform a basic test, them is necessary a more
advance set of tests section VII. You should design a representation for the problem and algorithms for
the functions required by the test interface. After doing a design walkthrough, implement your design,
and test it using the test cases (boundary value testing). Your manager has told you not to write other
test cases or do any other testing.
Your manager likes to keep the testers on their toes, so she also asked you to produce a separate version
of your software with 5 seeded defects.
V. Inspection
Review the specification and turn in a document that lists all issues found. For each issue, you should
list the location of the issue in the specification, the summary of the issue, what kind of issue (e.g. for
specifications, this may be unclear, contradictory, or untestable). In the case of unclear or contradictory
specifications, give a question you would ask to the manager to resolve the issue. In the context of this
problem, many questions would benefit with a simple illustration of an input situation, so use this where
appropriate. You should also list the amount of time you spent on the review.
VI. Minimal Set of Test Cases
For the functionality specified in this problem, some people may argue that a total of four test cases like
the following are sufficient to test adequately. For example:
Test Case Input Values Expected Results
1. 3, 3, 3 Equilateral Triangle
2. 3, 3, 3 Equilateral Triangle
3. 3, 4, 5 Scalene Triangle
4. 3, 3, ? Invalid Input
There are possible defects that would not be detected by this set of four test cases, however, so
other people may advocate a more thorough test.
which one is the correct or more appropriate set of test cases?
There are possible defects that would not be detected by this set of four test cases?
Answer the previous question and include this in your final report.9/6/2018 Homework 1 – The Triangle Problem
VII. Functional testing
Develop a list of test cases for this triangle problem. The table format below is convenient for listing
your test cases, though you do not have to follow it.
Test Case # Condition Being Tested
(test requirement)
Input Data Values Expected Result
a b c
1. Three valid equal sides 7 7 7 Equilateral triangle
For each one of the following variations of boundary values testing, list a minimal set of test cases:
1. Normal boundary value testing
2. Robust boundary value testing
3. Worst-case boundary value testing
4. Robust worst-case boundary value testing
VIII. Functional testing for seeded defects
Develop a list of test cases for this seeded defect solution. However, you should write one
additional test case for each seeded defect that fails in the seeded code. Document in the test
case code a brief summary of the defect along with the location of the seeded defect. Turn in the
seeded source code and test cases separately from the original code.
IX. Testing
After implementing your solution, test it with only the test cases created before in section VII
and VIII. Record any defects found while coding and while testing.
