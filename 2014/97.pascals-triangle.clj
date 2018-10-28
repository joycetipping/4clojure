; My solution
(fn [n]
  (let [fac (fn [x & [y]] (apply * (range x (if y (- x y) 0) -1)))
        choose #(int (/ (fac % %2) (fac %2)))]
    (map #(choose (dec n) %) (range n))))


; adereth's solution
(fn [n]
  (nth
    (iterate #(map +' (concat [0] %) (concat % [0])) [1]) (dec n)))
