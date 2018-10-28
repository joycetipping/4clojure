; My first answer, before I understood what the lcm of two ratios were.
(fn [& numbers]
  (let [numerators (map #(if (ratio? %) (numerator %) %) numbers)
        denominators (map #(if (ratio? %) (denominator %) 1) numbers)
        gcd (fn self [x y] (let [h (max x y)
                                 l (min x y)]
                             (if (= 0 (rem h l)) l (self l (rem h l)))))
        lcm (fn [x y] (/ (* x y) (gcd x y)))
        result (/ (reduce lcm numerators) (reduce gcd denominators))]
    (if (ratio? result) result (int result))))

; Simplified
(fn [& numbers]
  (let [gcd (fn self [x y] (let [h (max x y)
                                 l (min x y)]
                             (if (= 0 (rem h l)) l (self l (rem h l)))))
        lcm (fn [x y] (/ (* x y) (gcd x y)))]
    (reduce lcm numbers)))




; 4clojure1's solution:
(fn [n & nums]
    (first
      (filter
        (fn [m] (every? #(zero? (rem m %)) nums))
        (iterate #(+ % n) n))))
