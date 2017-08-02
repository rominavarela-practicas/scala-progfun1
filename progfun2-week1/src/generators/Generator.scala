package generators

import scala.util.Random

trait Generator[+T] { 
  private def iterLimit = 10
  
  def generate: T
  
  def foreach[CallBack](apply: T => CallBack) {
    for {
      i <- (0 to Random.nextInt(iterLimit))
    } yield apply(this.generate)
  }
  
  def map[CallBack](apply: T => CallBack) {
    for {
      i <- (0 to Random.nextInt(iterLimit))
    } yield apply(this.generate)
  }
}