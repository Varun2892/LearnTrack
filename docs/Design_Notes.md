# Design Notes

## Why ArrayList?
ArrayList is used because it supports dynamic resizing unlike arrays.

## Encapsulation
All entity fields are private and accessed using getters and setters.

## Inheritance
Student extends Person to reuse common attributes.

## Polymorphism
Method overriding is used to show runtime polymorphism.

## Exception Handling
A custom EntityNotFoundException is used to handle invalid IDs gracefully.

## Separation of Concerns
Entity handles data, Service handles logic, UI handles user interaction.

