; My solutions:

(fn [f s] (rest (reductions #(f %2) nil s))) ; The most elegant on the page, I may brag

(fn mymap [f [s1 & s]] (cons (f s1) (if (empty? s)
                                        []
                                        (lazy-seq (mymap f s)))))
