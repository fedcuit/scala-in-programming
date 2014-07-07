package sort

object CollectionUtils {
  def sort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        sort(xs filter (pivot > _)),
        xs filter (pivot ==),
        sort(xs filter (pivot < _)))
    }
  }
}
