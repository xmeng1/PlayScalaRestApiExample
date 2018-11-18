package learning
import sun.java2d.opengl.GLXSurfaceData.GLXOffScreenSurfaceData

/**
  * This class is used to study the contravariant and covariant in Function[]
  * <p>Date:    17/11/18
  *
  * @author mengxin
  * @version 1.0
  */
class FuncVariantStudy {

  val yellBird: Function1[Bird, String]= {
    println("Bird yell")
    x => x.name
  }
  val yellMammal: Function1[Mammal, String]= {
    println("Mammal yell")
    x => x.name
  }
  val yellAnimal: Function1[Animal, String]= {
    println("Animal yell")
    x => x.name
  }

  val yellDog: Function1[Dog, String]= {
    println("Dog yell")
    x => x.name
  }

  val yellCat: Function1[Cat, String]= {
    println("Cat yell")
    x => x.name
  }

  // Mammal is child class of Animal
  // so the yellAnimal is the child class of yellMammal

  // everywhere use the Animal can change to Mammal or Bird
  // everywhere use the yellMammal, can change to yellAnimal

  def doAction(a: Animal, x: Bird=>String) = {
//    x.apply(a)
    println("xx")
  }

  def doActionMammal(a: Animal, x: Mammal=>String) = {
//    x.apply(a)
    println("Mammal")
  }

  def doActionAnimal(a: Animal, x: Animal=>String) = {
//    x.apply(a)
    println("Animal")
  }

  def doActionBird(a: Animal, x: Bird=>String) = {
//    x.apply(a)
    println("Bird")
  }

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    val a = Animal("Animal")
    val bird = Bird("Bird")
    val mammal = Mammal("Mammal")
    val cat = Mammal("Cat")
    val dog = Mammal("Dog")
    val mockingGay = MockingGay()
    val gold = Gold()

    doAction(a, yellBird)
    doAction(bird, yellBird)
    doAction(mammal, yellBird)
    doAction(cat, yellBird)
    doAction(dog, yellBird)
    doAction(mockingGay, yellBird)
    doAction(gold, yellBird)

    yellMammal.apply(mammal)
    yellMammal.apply(dog)
    yellMammal.apply(cat)
    yellAnimal.apply(cat)


    val b = Box("box")
    doActionMammal(a, yellMammal)
    doActionMammal(a, yellAnimal)
    // cannot compile because of the yellDog is the parent class of yellMammal,but yellAnimal is
    //  child class of yellMammal.
    // doActionMammal(a, yellDog)
//    doAction(b, yell)
  }
}

case class Animal(name: String)

case class Bird(override val name: String) extends Animal("Bird")

case class Mammal(override val name: String) extends Animal("Mammal")

case class Cat() extends Mammal("Cat")

case class Dog() extends Mammal("Dog")

case class MockingGay() extends Bird("MockingGay")

case class Gold() extends Bird("Gold")


case class Box(name: String)