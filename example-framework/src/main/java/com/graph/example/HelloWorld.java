package com.graph.example;


import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.*;

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

  public static void main(String[] args) {
    f2();
  }

  private static void f2() {
    final GraphQLCodeRegistry registry = GraphQLCodeRegistry.newCodeRegistry()
      .dataFetcher(FieldCoordinates.coordinates("Query", "getuser"), new DataFetcher<Object>() {
        @Override
        public Object get(DataFetchingEnvironment environment) throws Exception {
          Map<String, Object> output = new HashMap<>(environment.getArguments().size() + 1);
          output.put("result-type", "Map<String,Object>");
          environment.getArguments().forEach(output::put);
          return output;
        }
      })
      .dataFetcher(FieldCoordinates.coordinates("Query", "getprofile"), new DataFetcher<Object>() {
        @Override
        public Object get(DataFetchingEnvironment environment) throws Exception {
          return "Profile: " + environment.getArgument("ownerId");
        }
      }).build();


    final GraphQLObjectType root = GraphQLObjectType.newObject()
      .name("Query")
      .description("Root query")
      .field(GraphQLFieldDefinition.newFieldDefinition()
        .name("getuser")
        .argument(GraphQLArgument.newArgument()
          .name("uid")
          .description("arg: uid")
          .type(Scalars.GraphQLString)
          .build())
        .type(HelloWorld.GraphQLObject)
        .build())
      .field(GraphQLFieldDefinition.newFieldDefinition()
        .name("getprofile")
        .argument(GraphQLArgument.newArgument()
          .name("ownerId")
          .description("arg: ownerId")
          .type(Scalars.GraphQLString)
          .build())
        .type(HelloWorld.GraphQLObject)
        .build())
      .build();


    final GraphQLSchema schema = GraphQLSchema.newSchema()
      .codeRegistry(registry)
      .query(root)
      .build();
    System.out.println(schema);
    GraphQL gql = GraphQL.newGraphQL(schema).build();

    String query = "query TestQ($userId: String){ getuser(uid: $userId) getprofile(ownerId: $userId) }";
    ExecutionResult er = gql.execute(ExecutionInput.newExecutionInput()
      .query(query)
      .variables(new HashMap<String, Object>() {{
        put("userId", 119);
      }})
      .build());
    Object data = er.getData();
    System.out.println(data);
  }

  public static final GraphQLScalarType GraphQLObject = GraphQLScalarType.newScalar()
    .name("Object")
    .description("An object scalar")
    .coercing(new Coercing<Object, Object>() {
      @Override
      public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
        return dataFetcherResult;
      }

      @Override
      public Object parseValue(Object input) throws CoercingParseValueException {
        return input;
      }

      @Override
      public Object parseLiteral(Object input) throws CoercingParseLiteralException {
        return input;
      }
    })
    .build();
}
