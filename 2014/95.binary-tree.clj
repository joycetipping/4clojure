(fn valid? [tree]
  (and (= (count tree) 3)
       (= 0 (select #(= (class %) java.lang.Boolean) tree))
       (if (sequential? (second tree)) (valid? (second tree)) true)
       (if (sequential? (last tree)) (valid? (last tree)) true)))


