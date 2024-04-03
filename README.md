### DynamoDBSave

Expected time required: 20 min

In this coding activity, you will get practice saving and updating items using the DynamoDB table
`DynamoDbAnnotationsLoadSave-Books`. The table keeps track of a few different attributes (no doubt a
small subset of the true book catalog, but suitable for our needs here).

#### Creating the `DynamoDbAnnotationsLoadSave-Books` Table

First, open up AWS and search for the DynamoDB service. Make sure your region is set to "us-west-2".

Once at the DynamoDB page, find and click on the button that says "Create Table".

Fill in the form with the following:

- Table name: DynamoDbAnnotationsLoadSave-Books
- Partition Key: asin
- Sort key: _leave blank_

Leave the rest of the fields to their default values and click "Create table" at the bottom of the page.

#### Populating the Table

After you pull down this project, open the terminal and go into this project's root folder. Run the following command:

```aws dynamodb batch-write-item --request-items file://main/seeds/Books.json```

You should get a response that says:

```
"UnprocessedItems": {}
```

To further verify that your items are available in the table, go back to the DynamoDB webpage and click on `Items` on the far left of the page. You should see your table in the list of tables. Click on your table, and now you should see a book item.

#### Book POJO

A `Book` POJO based on the `DynamoDbAnnotationsLoadSave-Books` DynamoDB table has been provided for you. 

The Books table can be found in your AWS Console and is set-up
the following way:

| asin       | author  | title              | year_published |
|------------|---------|--------------------|----------------|
| B00EGMV00W | Baldwin | The Fire Next Time | 1963           |

#### BookDao

Code for `getBook()` has been provided for you.

Write code for the `saveBook()` method in the `BookDao` class. The `saveBook()`
method should accept an instance of `Book` and save it to the table.

#### Complete the test

Find the integration test under the `src/integrationTest/java` directory.
The full classname is `BookIntegrationTests`

Update the `BookIntegrationTests` class
to instantiate an actual `DynamoDBMapper` instance, including getting
a client via the `DynamoDbClientProvider` class.

Now, run the test class manually in IntelliJ and make sure you get everything passing.

This test actually saves/retrieves data from the DynamoDB table. This is why
we're calling it an integration test (if it were a unit test, we'd put it in
`src/test/java/...` and we'd be mocking the `DynamoDBMapper` we pass into the DAO).

You can see what happens if you delete/alter the book item in DynamoDB
that the test expects to be there. You can use the DynamoDB Console for this,
to change the items, just make sure you know what to put back in afterwards to restore the data.

#### Test away!

Once you've written `saveBook()` in `BookDao` and updated `BookIntegrationTests`,
you should be able to pass the tests set-up in the `BookIntegrationTests` class,
which is located in `src/integrationTest/`.

Reminder: You can run the full test class manually by right-clicking the file in the project view and
selecting "Run 'BookIntegrationTests'", or by clicking the double arrows to the left of the class declaration
when viewing `BookIntegrationTests`.

**You have completed this pre-work when:**
* You have implemented the `saveBook()` method in the `BookDao` class.
* You have updated `BookIntegrationTests` to instantiate a `DynamoDBMapper` instance.
* The `BookIntegrationTests` are passing.
* You have committed and pushed your code.
* You have answered the Canvas quiz with a link to your commit on code browser.
