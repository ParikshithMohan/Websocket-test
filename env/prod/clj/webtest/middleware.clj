(ns webtest.middleware
  (:require
   [ring.middleware.defaults :refer [site-defaults wrap-defaults]]))

(def middleware ;;maintains site defaults
  [site-defaults])
