# Data-Transfer-Object (Protocol / Standard for REST APIs)

How I would like to format my JSON Responses to take account for errors and predictable schema.


## Features

Predictable response schema to allow for:
- Better Typing on client-side
- Parseable and handleable errors
  
## Acknowledgements

This protocol / standard is basically the same as [GraphQL's Response Protocol](https://spec.graphql.org/June2018/#sec-Response-Format).

The basics of this are that JSON Responses should be shaped as
|Field|Type|Description|
|-|-|-|
|data|`Successful object` **or** `null`|The expected return object or null for failure to get any result|
|errors|`Arrays of error object` **or** `null`|Error(s) occurred during the process described as usually string or custom object|

This way, it's easier to guess what's going on, parsing a proper JSON Response wouldn't throw an error with bad explanations and instead can directly get the error responses.