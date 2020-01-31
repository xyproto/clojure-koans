(ns koans.07-functions
  (:require [koan-engine.core :refer :all]))

(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(meditations
  "Calling a function is like giving it a hug with parentheses"
  (= (square 9) (square 9))

  "Functions are usually defined before they are used"
  (= (multiply-by-ten 2) (multiply-by-ten 2))

  "But they can also be defined inline"
  (= (multiply-by-ten 1) ((fn [n] (* 5 n)) 2))

  "Or using an even shorter syntax"
  (= ((fn [x] (* 15 x)) 4) (#(* 15 %) 4))

  "Even anonymous functions may take multiple arguments"
  (= 15 (#(+ %1 %2 %3) 4 5 6))

  "Arguments can also be skipped"
  (= (str 'AACC) (#(str "AA" %2) "bb" "CC"))

  "One function can beget another"
  (= 9 (((fn [] #(+ %1 %2))) 4 5))

  "Functions can also take other functions as input"
  (= 20 ((fn [f] (f 4 5))
           #(* %1 %2)))

  "Higher-order functions take function arguments"
  (= 25 ((fn [f] (f 5))
          (fn [n] (* n n))))

  "But they are often better written using the names of functions"
  (= 25 (
    #(%1 5)
    square)))
