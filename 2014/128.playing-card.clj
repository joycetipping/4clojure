(fn [x] (let [[s r] (seq x)
              suits {\D :diamond \H :heart \C :club \S :spade}
              ranks [\2 \3 \4 \5 \6 \7 \8 \9 \T \J \Q \K \A]]
          {:suit (suits s) :rank (.indexOf ranks r)}))
