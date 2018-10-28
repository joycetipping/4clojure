; My working solution
(fn [v] (iterate #(map +' (concat % [0]) (concat [0] %)) v))

; Spencer's fix to my first solution
(fn [v] (iterate #(mapv +' (conj % 0) (cons 0 %)) v))
