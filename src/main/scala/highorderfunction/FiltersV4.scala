package highorderfunction

import highorderfunction.FiltersV3.complement

object FiltersV4 {
  def any[A](predicates: (A => Boolean)*): A => Boolean = {
    a => predicates.exists(_(a))
  }

  def none[A](predicates: (A => Boolean)*): A => Boolean = {
    complement(any(predicates: _*))
  }

  def all[A](predicates: (A => Boolean)*): A => Boolean = {
    a => predicates.forall(_(a))
  }
}
