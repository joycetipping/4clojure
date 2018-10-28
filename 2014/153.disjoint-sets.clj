; My solution
(fn [sets] (let [s (reduce #(into % %2) [] sets)] (= s (distinct s))))

; Spencer's solution:
#(apply distinct? (mapcat identity %))

; aceeca1's solution:
#(apply distinct? (apply concat %))
