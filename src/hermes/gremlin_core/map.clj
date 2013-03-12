(ns hermes.gremlin-core.map
  (:refer-clojure :exclude [count memoize])
  (:use hermes.gremlin-core.util))

;; <T> GremlinPipeline<S,T>
;; transform(com.tinkerpop.pipes.PipeFunction<E,T> function) 
;; Add a TransformFunctionPipe to the end of the Pipeline.

(defn transform [p f]
  (.transfrom p (f-to-pipe f)))

;; GremlinPipeline<S,E>	_() 
;; Add an IdentityPipe to the end of the Pipeline.

(defn _ [p]
  (._ p))

;; GremlinPipeline<S,Object>	id() 
;; Add an IdPipe to the end of the Pipeline.

(defn id [p] (.id p))


;; GremlinPipeline<S,Object>	property(String key) 
;; Add a PropertyPipe to the end of the Pipeline.

(defn property [p prop]
  (.property p (name prop)))

;; GremlinPipeline<S,String>	label() 
;; Add an LabelPipe to the end of the Pipeline.

(defn label [p]
  (.label p))

;; GremlinPipeline<S,com.tinkerpop.pipes.util.structures.Row>	select() 
;; Add a SelectPipe to the end of the Pipeline.
;; GremlinPipeline<S,com.tinkerpop.pipes.util.structures.Row>	select(Collection<String> stepNames, com.tinkerpop.pipes.PipeFunction... columnFunctions) 
;; Add a SelectPipe to the end of the Pipeline.
;; GremlinPipeline<S,com.tinkerpop.pipes.util.structures.Row>	select(com.tinkerpop.pipes.PipeFunction... columnFunctions) 
;; Add a SelectPipe to the end of the Pipeline.

(defn select [p f]
  (.select p (pipef-array [(f-to-pipe f)])))

;; GremlinPipeline<S,E>	memoize(int numberedStep) 
;; Add a MemoizePipe to the end of the Pipeline.
;; GremlinPipeline<S,E>	memoize(int numberedStep, Map map) 
;; Add a MemoizePipe to the end of the Pipeline.
;; GremlinPipeline<S,E>	memoize(String namedStep) 
;; Add a MemoizePipe to the end of the Pipeline.
;; GremlinPipeline<S,E>	memoize(String namedStep, Map map) 
;; Add a MemoizePipe to the end of the Pipeline.

(defn memoize
  ([is] (.memoize is))
  ([is m] (.memoize is m)))

;; GremlinPipeline<S,?>	scatter() 
;; Add a ScatterPipe to the end of the Pipeline.

(defn scatter [p]
  (.scatter p))

;; GremlinPipeline<S,List>	path(com.tinkerpop.pipes.PipeFunction... pathFunctions) 
;; Add a PathPipe or PathPipe to the end of the Pipeline.

(defn path [p & args]
  (.path p (pipef-array map f-to-pipe args)))