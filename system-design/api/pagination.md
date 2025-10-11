# Pagination

Pagination is used for performance:
- Send list of data to clients in chunks/pages
- This makes sure that compute power of server is saved - process 100 rows instead
of a million.
- The client is not overwhelmed. It needs to display 100 images instead of 1 million
images at once.

## Pagination Strategies

Pagination can be of two types:
- **Page Based**: In this the client sends back a page/offset and size/limit.
Using this the server sends back a chunk/view of the data. There are two types:
    - **Page/Limit** - Page Number + Size 
    - **Offset Based** - Offset + Limit

Both options are same, end of the day the sql ends up looking like `limit x offset y`.

**Problems**:
    - `OFFSET 10000` means, the sql scanner needs to scan and skip over 10000 rows
    and then send back the data. This takes time and is not performant.
    - Lets say we always paginate according to ID. 
    `SELECT * FROM table LIMIT 10 OFFSET 10000`.
    Considering a primary key, even then with limit, the cost is a scan of the 
    table to skip rows, which degrades performance.

- **Cursor based**: In cursor based, consider a cursor over one/multiple columns
of the table. We can take one/multiple columns - encode it base64 and send it over
to the client. The client can then send back the cursor which makes queries
faster. This is mostly used in infinite scroll.
    - **Keyset Based** - This strategy is where one or more keys/columns are used for
    creating the cursor.
    - **Timestamp based** - in time series db, example tsdb, this can be used.

Cursor-based pagination can also support “next” and “previous” pages using reversed ordering logic.

Pagination performance depends heavily on indexes:

For OFFSET/LIMIT, indexes help partially, but the database still scans skipped rows.

For cursor-based pagination, an index on (sort_column) or (sort_columns) makes the query near O(log n) + O(limit).

## Use Cases
| Type                      | Pros                                   | Cons                                                      | Ideal Use                         |
| ------------------------- | -------------------------------------- | --------------------------------------------------------- | --------------------------------- |
| **Page-based (offset)**   | Simple to implement                    | Slow for large offsets, inconsistent on data mutation     | Admin dashboards, small data sets |
| **Cursor-based (keyset)** | Fast, stable, supports infinite scroll | More complex to implement, hard to jump to arbitrary page | Feeds, timelines, APIs            |
| **Timestamp-based**       | Natural for time-ordered data          | Requires monotonic timestamps                             | Logs, metrics, event streams      |



