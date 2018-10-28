; My solution
(fn [t]
  (let [sym? (fn self [n1 n2] (if (or (not-any? coll? [n1 n2])
                                      (not-any? coll? (concat n1 n2)))
                                  (= n1 n2)
                                  (and (= (first n1) (first n2))
                                       (self (second n1) (last n2))
                                       (self (last n1) (second n2)))))]
    (apply sym? (rest t))))



; Spencer's solution
(fn [[_ l r]]
  (= l
     ((fn mirror [[h l r :as t]]
        (and t [h (mirror r) (mirror l)])) r)))



(fn [[_ l r]] (= l ((fn mirror [[h l r :as t]] (and t [h (mirror r) (mirror l)])) r)))

; adereth's solution
#(let [t (fn t [[v l r]] [v (if r (t r)) (if l (t l))])
       [_ l r] %]
   (= l (t r)))
