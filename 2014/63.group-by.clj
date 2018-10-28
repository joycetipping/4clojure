(fn [f items]
  (reduce (fn [result v] (let [k (f v)
                               other-vs (result k)]
                           (if (nil? v)
                             (assoc result k [v])
                             (assoc result k (sort (conj other-vs v)))))) {} items))


Spencer:
(fn [f xs] (merge-with into {} (map (juxt f vector) xs)))
(fn [f xs] (apply merge-with into {} (map #(hash-map (f %) [%]) xs)))

Solutions:
(fn [f vs] (reduce #(merge-with into % {(f %2) [%2]}) {} vs))
(fn [f s]
  (apply merge-with concat (map #(hash-map (f %1) [%1]) s)))
