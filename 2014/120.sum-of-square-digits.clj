(fn [s] (count (filter (fn [x] (< x (reduce + (map #(* % %) (->> x (str) (seq) (map #(Character/getNumericValue %))))))) s)))
