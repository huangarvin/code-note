package com.graph.example;

import graphql.schema.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import static graphql.Scalars.GraphQLString;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class GraphQLDynamicSchema {

  public static void main(String[] args) {
    f1();

  }


  private static void f1() {

    DataFetcher<Foo> fooDataFetcher = new DataFetcher<Foo>() {
      @Override
      public Foo get(DataFetchingEnvironment environment) {
        return perhapsFromDatabase();
      }

      private Foo perhapsFromDatabase() {
        Foo f = new Foo();
        f.age = 10;
        f.name = "hsp";
        return f;
      }

    };

    GraphQLObjectType objectType = GraphQLObjectType.newObject()
      .name("ObjectType")
      .field(GraphQLFieldDefinition.newFieldDefinition()
        .name("foo")
        .type(GraphQLString)
      )
      .build();

    GraphQLCodeRegistry codeRegistry = GraphQLCodeRegistry.newCodeRegistry()
      .dataFetcher(
        FieldCoordinates.coordinates("ObjectType", "foo"),
        fooDataFetcher)
      .build();



  }
}

class Foo {

  public int age;
  public String name;
}
