package learning

/**
  *
  * <p>Date:    15/11/18
  *
  * @author mengxin
  * @version 1.0
  */
object VariantStudy {

}


trait ApiResponse[T] {
  val error: Int
  val msg: String
  val t: T
}

trait ApiResponseCo[+T] {
  val error: Int
  val msg: String
  val t: T
}


trait ApiResponseContra[-T] {
  val error: Int
  val msg: String
//  val t: T
}


trait ApiResponseContra1[-T, E>:T] {
  val error: Int
  val msg: String
  val t: E
}

case class Entity()
case class Person() extends Entity

case class Admin() extends Person
case class Customer() extends  Person

object util {
  def test (api: ApiResponse[Person]) {

  }

  def testCo (api: ApiResponseCo[Person]) {

  }

  def testContraFirst (api: ApiResponseContra[Person]) {

  }

  def testContra (api: ApiResponseContra1[Person, Person]) {

  }
}

case class ApiResponseModel[E](error: Int, msg: String, t: E) extends ApiResponse[E]

case class ApiResponseCoModel[+E](error: Int, msg: String, t: E) extends ApiResponseCo[E]
case class ApiResponseContraModel[-E](error: Int, msg: String) extends ApiResponseContra[E]
case class ApiResponseContraModel1[-X, T>:X](error: Int, msg: String, t: T) extends ApiResponseContra1[X,T]

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")

    val entity1 = new Entity
    val entity2 = new Person
    val entity3 = new Customer
    val entity4 = new Admin

    val res1 = new  ApiResponseModel[Entity](0,"1",entity1)
    val res2 = new  ApiResponseModel[Person](0,"1",entity2)
    val res3 = new  ApiResponseModel[Customer](0,"1",entity3)
    val res4 = new  ApiResponseModel[Admin](0,"1",entity4)

//    util.test(res1)  // cannot compile
    util.test(res2)
//    util.test(res3)  // cannot compile
//    util.test(res4)  // cannot compile

    val resCo1 = new  ApiResponseCoModel[Entity](0,"1",entity1)
    val resCo2 = new  ApiResponseCoModel[Person](0,"1",entity2)
    val resCo3 = new  ApiResponseCoModel[Customer](0,"1",entity3)
    val resCo4 = new  ApiResponseCoModel[Admin](0,"1",entity4)

//    util.testCo(resCo1)  // cannot compile
    util.testCo(resCo2)
    util.testCo(resCo3)
    util.testCo(resCo4)

    val resContraFirst1 = new  ApiResponseContraModel[Entity](0,"1")
    val resContraFirst2 = new  ApiResponseContraModel[Person](0,"1")
    val resContraFirst3 = new  ApiResponseContraModel[Customer](0,"1")
    val resContraFirst4 = new  ApiResponseContraModel[Admin](0,"1")

    util.testContraFirst(resContraFirst1)
    util.testContraFirst(resContraFirst2)
//    util.testContraFirst(resContraFirst3)  // cannot compile
//    util.testContraFirst(resContraFirst4)  // cannot compile


    /////////////////////////////////

    val resContra1 = new  ApiResponseContraModel1[Entity, Entity](0,"1",entity1)
    val resContra2 = new  ApiResponseContraModel1[Person, Person](0,"1",entity2)
    val resContra3 = new  ApiResponseContraModel1[Customer, Customer](0,"1",entity3)
    val resContra4 = new  ApiResponseContraModel1[Admin, Admin](0,"1",entity4)

//    util.testContra(resContra1)
//    util.testContra(resContra2)
//    util.testContra(resContra3)
//    util.testContra(resContra4)
  }
}