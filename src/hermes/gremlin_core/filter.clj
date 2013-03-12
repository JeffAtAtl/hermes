(ns hermes.gremlin-core.filter
  (:refer-clojure :exclude [filter and or range])
  (:use hermes.gremlin-core.util))

;; GremlinPipeline<S,E>	filter(com.tinkerpop.pipes.PipeFunction<E,Boolean> filterFunction) 
;; Add an FilterFunctionPipe to the end of the Pipeline.

(defn filter [p f]
  (.filter p (f-to-pipe f)))

;; GremlinPipeline<S,E>	and(com.tinkerpop.pipes.Pipe<E,?>... pipes) 
;; Add an AndFilterPipe to the end the Pipeline.

;;(and (blank-pipe (q/-->) (q/count))
;;     (blank-pipe (q/-->) (q/count)))

(defn and [p & es]
  (.and p (pipe-array es)))

;; GremlinPipeline<S,E>	dedup() 
;; Add a DuplicateFilterPipe to the end of the Pipeline.
;; GremlinPipeline<S,E>	dedup(com.tinkerpop.pipes.PipeFunction<E,?> dedupFunction) 
;; Add a DuplicateFilterPipe to the end of the Pipeline.

(defn dedup
  ([p] (.dedup p))
  ([p f] (.dedup p (f-to-pipe f))))

;; GremlinPipeline<S,E>	except(Collection<E> collection) 
;; Add an ExceptFilterPipe to the end of the Pipeline.

(defn except [p xs]
  (.except p xs))

;; GremlinPipeline<S,? extends com.tinkerpop.blueprints.Element>	has(String key, Object value) 
;; Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
;; GremlinPipeline<S,? extends com.tinkerpop.blueprints.Element>	has(String key, Tokens.T comparison, Object value) 
;; Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.

(defmacro has
  ([p k v] `(.has ~p ~(name k) ~v))
  ([p k c v] `(.has ~p ~(name k) (convert-symbol-to-token '~c) ~v)))


;; GremlinPipeline<S,? extends com.tinkerpop.blueprints.Element>	hasNot(String key, Object value) 
;; Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
;; GremlinPipeline<S,? extends com.tinkerpop.blueprints.Element>
;; hasNot(String key, Tokens.T comparison, Object value) 
;; Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the
;; end of the Pipeline.

(defmacro has-not
  ([p k v] `(.has-not ~p ~(name k) ~v))
  ([p k c v] `(.has-not ~p ~(name k) (convert-symbol-to-token '~c) ~v)))

;; GremlinPipeline<S,? extends com.tinkerpop.blueprints.Element>	interval(String key, Object startValue, Object endValue) 
;; Add an IntervalFilterPipe to the end of the Pipeline.

(defn interval [p key start end]
  (.intreval p (name key) start end))

;; GremlinPipeline<S,E>	or(com.tinkerpop.pipes.Pipe<E,?>... pipes) 
;; Add an OrFilterPipe to the end the Pipeline.

(defn or [p & es]
  (.or p (pipe-array es)))

;; GremlinPipeline<S,E>	random(Double bias) 
;; Add a RandomFilterPipe to the end of the Pipeline.

(defn random [p bias]
  (.random p bias))

;; GremlinPipeline<S,E>	range(int low, int high) 
;; Add a RageFilterPipe to the end of the Pipeline.

(defn range [p low high]
  (.range p low high))

;; GremlinPipeline<S,E>	retain(Collection<E> collection) 
;; Add a RetainFilterPipe to the end of the Pipeline.

(defn retain [p coll]
  (.retain p coll))

;; GremlinPipeline<S,E>	simplePath() 
;; Add a CyclicPathFilterPipe to the end of the Pipeline.

(defn simplePath [p]
  (.simplePath p))
