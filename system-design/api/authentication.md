# Authentication

Modern applications require secure API authentication to protect resources and 
identify users. The choice between API keys, sessions, and JWTs depends on 
your scalability, security, and user context requirements.


## API Keys:

API keys are for application identity and not users. A unique token is assigned
to each client, which can help in authentication of the calling service, rate limit,
track usage etc for this client.

## Sessions: Server-Side State

Sessions maintain server-side state for user interactions. 
When users authenticate, the server creates a session record containing user 
information and permissions. The client receives only a session identifier, 
typically as an HTTP cookie.

Scaling challenges - we can keep things in memory for fast access, but scale is
an issue. With scaling, we need a common store - Redis - for fast access. Even
with fast access, we added a network hop and potential point of failure.

## JWT - Client side tokens

JWTs (JSON Web Tokens) contain encoded user information and permissions 
directly within the token itself. Unlike sessions, the server validates tokens 
cryptographically without database lookups, enabling stateless authentication 
that scales horizontally across distributed systems.


