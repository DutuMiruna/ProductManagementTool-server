# ProductManagementTool-server
This is the server side of the Product Management Tool API.

I created a database having only one table-product with columns id, name, price.
Based on this table I created the Entity class. 
In order to interface the interaction with DB, I created ProductDao, where all operations with DB are performed. 
On top of this, I created the ProductService class, which presents all the use cases. 
Finally, the controller exposes the services. 
I also created an utility class, GenericMessage, to be able to send a response if the use case was performed correctly or not. 
I secured the add/change/delete services using basic auth.
