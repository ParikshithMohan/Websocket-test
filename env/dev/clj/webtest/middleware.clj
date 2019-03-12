(ns webtest.middleware
  (:require
   [ring.middleware.content-type :refer [wrap-content-type]]
   [ring.middleware.params :refer [wrap-params]]
   [prone.middleware :refer [wrap-exceptions]]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.middleware.defaults :refer [site-defaults wrap-defaults]]))

(def middleware   ;;dont know...maybe maintains all the default settings
  [#(wrap-defaults % site-defaults)
   wrap-exceptions
   wrap-reload])
