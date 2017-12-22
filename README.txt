This application is an Asynchronous RMI dictionary service.

It allows the user to search a word in a custom dictionary file found online.

When the user searches for a word there is a HTTP request being made to the Apache Tomcat Server which searches the dictionary file and puts
it in a queue that is read by the RMI client that will later display the definition of the word to the user.

How to run : 
- When the project is imported to your Editor you need to have Apache Tomcat  v8.5 installed into your workspace.
- When that is installed and being used run the Server in order to start up the server.
- Once the server is running, start the lookup.jsp file in order to start searching for a word in the dictionary file.