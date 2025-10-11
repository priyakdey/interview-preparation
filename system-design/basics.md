# The Challenges

1. Huge number of active user:
With huge number of active concurrent users, with the traditional monolith - a
single server and a single DB very quikcly reaches its throughput limit - RPS/QPS.
This is where **replication** comes into picture. Having same copies of the service
running, having replicate DBs, for catering to multiple requests.
When happens on the service level, we need **load balancing** and on the db side
we need **replicas**

2. Huge data:
With millions of users, the storage for huge amount of data on a single machine
becomes impossible. This is where sharding comes into account - depending on a
index, the data is distributed across servers/stores.

3. Performance:
Even though we took care of scale with replication and sharding, the processing
time also matter. An API response in 500ms is acceptable, but if the API starts
responding in > 1 second, users might start leaving our website. This is where
asycn io, cache hits are important since it will help us speed up processing of 
the request. Reads are still okay, but writes are hard. Writes needs to make sure
all the deletes/updates/creates are working fine, the replicas are updated etc.
So with aysnc processing, this can be fixed.

4. Eventual Consistency:
With all above, the problem comes - if a write happens async - behind the scene, 
the next reads might not see latest data and might see inconsistent data.
One example is - in a social media with me commenting on a photo, for some users
the comment might appear immediately, for others it might get delayed by few seconds.
Inconsistency is not random, it just means the user is still reading old/deleted data.

This needs to be handled at application level. Some UI might make sure to render the
entire page, except one comment. In above example, the entire social media works fine,
I can still comment, like share, see the image, do something else on the website,
but the comment made by user2 is still not visible.
This is eventual consistency, where eventually the entire system agrees and sees 
one data view, but not immediately.

# How to Scale a System

1. Decomposition:
This technique is breaking down the system into multiple services according
to business requirements. Example one service can handle user login, account
creation etc.
While another system can handle all posts from the users.

2. Vertical Scaling:
Vertically scale the machine - give more comopute power - bigger machines - more
core, more memory increases the throughput, and scale

3. Horizontal Scaling:
This is where multiple instances or replicas of same service is created, considering
services are stateless.
The load is then distributed using load balancer.

4. Partition:
Parition involves sharding data into multiple machines. Using consistent hashing
the requests can be distributed uniformly across different machines for data fetches.

5. Caching:
Caching improves the performance of the requests. Data once read, can be cached in
memory backed fast caches like Redis/Memcached which can then help DB disk io
read bottlenecks.

6. Buffer with Message Queues:
Systems which are write heavy, to achieve good latency, we can use queues to 
queue up the requests and write behind in an async way.

7. Separate Read/Write:
In this process, we will try and separate the read/write data flow to make
sure both processes are relatively fast compared to one system doing
all read and writes
- Leader-Follower architecture: In this architecture, all writes go to a leader,
while the followers does a replica to make sure that all reads go to the follower.

- CQRS - Command Query Responsibility Segregation - In this the read and write
models are optimized for their own commands. For example, a system might use 
MySQL as the source-of-truth database while employing Elasticsearch for 
full-text search or analytical queries, and asynchronously sync changes from 
MySQL to Elasticsearch using MySQL binlog Change Data Capture (CDC).


