package learning

/**
  *
  * <p>Date:    15/11/18
  *
  * @author mengxin
  * @version 1.0
  */
object GenericReflection {

}
class ScalaArrayDemo[T] {

  //Error: cannot find class tag for element type T
  def makeTArray(): Array[T] = new Array[T](10)

}

class ManifestDemo[T] {


  //Manifest是类型T的显示描述符
  def makeTArray[T: Manifest](): Array[T] = new Array[T](10)

  //等效上面的写法
  def makeTArray2()(implicit x: Manifest[T]): Array[T] = new Array[T](10)

  def makeStringArray(): Array[String] = new Array[String](10)

}

object ManifestType extends App {
  def print1[T](x: List[T])(implicit m: Manifest[T]) = {
    if (m <:< manifest[String])
      println("字符串类型的List")
    else
      println("非字符串类型的List")
  }
  print1(List("one", "two"))
  print1(List(1, 2))
  print1(List("one", 2))
}