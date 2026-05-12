package _11_generics.lecture._6_notification;

interface Notification<T> {
    void send(T message);
} 

class Email {}
class SMS {}

// The interface Notification cannot be implemented more than once with different arguments: Notification<SMS> and Notification<Email>Java
// class Messenger implements Notification<Email>, Notification<SMS>
// {

// }