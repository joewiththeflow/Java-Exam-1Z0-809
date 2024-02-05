create table if not exists Customer (CustomerID int primary key, FirstName varchar (255) not null, LastName varchar (255) not null,
    Email varchar (255) not null, Phone varchar (255) not null);
truncate table Customer;
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5000, 'John', 'Smith', 'john.smith@verizon.net', '555-340-1230');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5001, 'Mary', 'Johnson', 'mary.johnson@comcast.net', '555-123-4567');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5002, 'Bob', 'Collins', 'bob.collins@yahoo.com', '555-012-3456');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5003, 'Rebecca', 'Mayer', 'rebecca.mater@gmail.com', '555-205-8212');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5006, 'Anthony', 'Clark', 'anthony.clark@gmail.com', '555-256-1901');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5007, 'Judy', 'Souza', 'judy.souza@verizon.net', '555-751-1207');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5008, 'Christopher', 'Patriquin', 'patriquinc@yahoo.com', '555-316-1803');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5009, 'Deborah', 'Smith', 'debsmith@comcast.net', '555-256-3421');
insert into Customer (CustomerID, FirstName, LastName, Email, Phone) values (5010, 'Jennifer', 'McGinn', 'jmcginn@comcast.net', '555-250-0198');

create table if not exists Book (
    ISBN varchar(30) primary key,
    Title varchar (60) not null,
    PubDate date not null,
    Format varchar (30) not null,
    Price decimal(4, 2) not null);
truncate table Book;
insert into Book (ISBN, Title, PubDate, Format, Price) values ('142311339X', 'The Lost Hero (Heroes of Olympus, Book 1)', '2010-10-12', 'Hardcover', 10.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('0689852223', 'The House of the Scorpion', '2002-01-01', 'Hardcover', 16.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('0525423656', 'Crossed (Matched Trilogy, Book 2)', '2011-11-01', 'Hardcover', 12.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('1423153627', 'The Kane Chronicles Survival Guide', '2012-03-01', 'Hardcover', 13.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('0439371112', 'Howliday Inn', '2001-11-01', 'Paperback', 14.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('0439861306', 'The Lightning Thief', '2006-03-12', 'Paperback', 11.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('031673737X', 'How to Train Your Dragon', '2010-02-01', 'Hardcover', 10.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('0445079059', 'The White Giraffe', '2008-05-01', 'Paperback', 6.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('0803733428', 'The Last Leopard', '2009-03-05', 'Hardcover', 13.95);
insert into Book (ISBN, Title, PubDate, Format, Price) values ('9780545236', 'Freaky Monday', '2010-01-15', 'Paperback', 12.95);

create table if not exists Author (AuthorID int primary key, FirstName varchar(30), LastName varchar(30));
truncate table Author;
insert into Author (AuthorID, FirstName, LastName) values (1000, 'Rick', 'Riordan');
insert into Author (AuthorID, FirstName, LastName) values (1001, 'Nancy', 'Farmer');
insert into Author (AuthorID, FirstName, LastName) values (1002, 'Ally', 'Condie');
insert into Author (AuthorID, FirstName, LastName) values (1003, 'Cressida', 'Cowell');
insert into Author (AuthorID, FirstName, LastName) values (1004, 'Lauren', 'St. John');
insert into Author (AuthorID, FirstName, LastName) values (1005, 'Eoin', 'Colfer');
insert into Author (AuthorID, FirstName, LastName) values (1006, 'Esther', 'Freisner');
insert into Author (AuthorID, FirstName, LastName) values (1007, 'Chris', 'D''lacey');
insert into Author (AuthorID, FirstName, LastName) values (1008, 'Mary', 'Rodgers');
insert into Author (AuthorID, FirstName, LastName) values (1009, 'Heather', 'Hatch');

create table if not exists Books_by_Author (AuthorID int, ISBN varchar(30), foreign key (AuthorID) references Author(AuthorID),
foreign key (ISBN) references Book(ISBN));
truncate table Books_by_Author;
insert into Books_by_Author (AuthorID, ISBN) values (1000, '142311339X');
insert into Books_by_Author (AuthorID, ISBN) values (1001, '0689852223');
insert into Books_by_Author (AuthorID, ISBN) values (1002, '0525423656');
insert into Books_by_Author (AuthorID, ISBN) values (1000, '1423153627');
insert into Books_by_Author (AuthorID, ISBN) values (1003, '031673737X');
insert into Books_by_Author (AuthorID, ISBN) values (1004, '0445079059');
insert into Books_by_Author (AuthorID, ISBN) values (1004, '0803733428');
insert into Books_by_Author (AuthorID, ISBN) values (1008, '9780545236');
insert into Books_by_Author (AuthorID, ISBN) values (1009, '9780545236');