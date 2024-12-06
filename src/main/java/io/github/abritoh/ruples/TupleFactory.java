package org.clusterbr.ruples;

import io.github.abritoh.ruples.immutable.*;
import io.github.abritoh.ruples.mutable.*;

/**
 * 
 * Factory convenient methods for mutable Tuples.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/TupleFactory.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1117
 * @author ClusterBR
 * 
 */
public class TupleFactory {

    /**
     * 
     * Factory method for Tuple1
     * 
     * @param <T1> - data-type 1
     * @param v1   - value 1
     * @return a mutable Tuple containing 1 value
     */
    public static <T1> Tuple1<T1> of(T1 v1) {
        return new Tuple1<>(v1);
    }  

    /**
     * 
     * Factory method for Tuple2
     * 
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param v1   - value 1
     * @param v2   - value 2
     * @return a mutable Tuple containing 2 values
     */
    public static <T1, T2> 
        Tuple2<T1, T2> of(T1 v1, T2 v2) {
        return new Tuple2<>(v1, v2);
    }


    /**
     * Factory method for Tuple3
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @return a mutable Tuple containing 3 values
     */
    public static <T1, T2, T3> 
        Tuple3<T1, T2, T3> 
        of(T1 v1, T2 v2, T3 v3) {
        return new Tuple3<>(v1, v2, v3);
    }

    /**
     * Factory method for Tuple4
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @return a mutable Tuple containing 4 values
     */
    public static <T1, T2, T3, T4> 
        Tuple4<T1, T2, T3, T4> 
        of(T1 v1, T2 v2, T3 v3, T4 v4) {
        return new Tuple4<>(v1, v2, v3, v4);
    }

    /**
     * Factory method for Tuple5
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @return a mutable Tuple containing 5 values
     */
    public static <T1, T2, T3, T4, T5> 
        Tuple5<T1, T2, T3, T4, T5> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5) {
        return new Tuple5<>(v1, v2, v3, v4, v5);
    }

    /**
     * Factory method for Tuple6
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param <T6> - data-type 6
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @param v6   - value 6
     * @return a mutable Tuple containing 6 values
     */
    public static <T1, T2, T3, T4, T5, T6> 
        Tuple6<T1, T2, T3, T4, T5, T6> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6) {
        return new Tuple6<>(v1, v2, v3, v4, v5, v6);
    }

    /**
     * Factory method for Tuple7
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param <T6> - data-type 6
     * @param <T7> - data-type 7
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @param v6   - value 6
     * @param v7   - value 7
     * @return a mutable Tuple containing 7 values
     */
    public static <T1, T2, T3, T4, T5, T6, T7> 
        Tuple7<T1, T2, T3, T4, T5, T6, T7> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5,T6 v6, T7 v7) {
        return new Tuple7<>(v1, v2, v3, v4, v5, v6, v7);
    }

    /**
     * Factory method for Tuple8
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param <T6> - data-type 6
     * @param <T7> - data-type 7
     * @param <T8> - data-type 8
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @param v6   - value 6
     * @param v7   - value 7
     * @param v8   - value 8
     * @return a mutable Tuple containing 8 values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8> 
        Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8) {
        return new Tuple8<>(v1, v2, v3, v4, v5, v6, v7, v8);
    }

    /**
     * Factory method for Tuple9
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param <T6> - data-type 6
     * @param <T7> - data-type 7
     * @param <T8> - data-type 8
     * @param <T9> - data-type 9
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @param v6   - value 6
     * @param v7   - value 7
     * @param v8   - value 8
     * @param v9   - value 9
     * @return a mutable Tuple containing 9 values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> 
        Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9) {
        return new Tuple9<>(v1, v2, v3, v4, v5, v6, v7, v8, v9);
    }    

    /**
     * Factory method for Tuple10
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param <T6> - data-type 6
     * @param <T7> - data-type 7
     * @param <T8> - data-type 8
     * @param <T9> - data-type 9
     * @param <T10> - data-type 10
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @param v6   - value 6
     * @param v7   - value 7
     * @param v8   - value 8
     * @param v9   - value 9
     * @param v10  - value 10
     * @return a mutable Tuple containing 10 values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> 
        Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10) {
        return new Tuple10<>(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10);
    }

    /**
     * Factory method for Tuple11
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param <T6> - data-type 6
     * @param <T7> - data-type 7
     * @param <T8> - data-type 8
     * @param <T9> - data-type 9
     * @param <T10> - data-type 10
     * @param <T11> - data-type 11
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @param v6   - value 6
     * @param v7   - value 7
     * @param v8   - value 8
     * @param v9   - value 9
     * @param v10  - value 10
     * @param v11  - value 11
     * @return a mutable Tuple containing 11 values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> 
        Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11) {
        return new Tuple11<>(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);
    }

    /**
     * Factory method for Tuple12
     *
     * @param <T1> - data-type 1
     * @param <T2> - data-type 2
     * @param <T3> - data-type 3
     * @param <T4> - data-type 4
     * @param <T5> - data-type 5
     * @param <T6> - data-type 6
     * @param <T7> - data-type 7
     * @param <T8> - data-type 8
     * @param <T9> - data-type 9
     * @param <T10> - data-type 10
     * @param <T11> - data-type 11
     * @param <T12> - data-type 12
     * @param v1   - value 1
     * @param v2   - value 2
     * @param v3   - value 3
     * @param v4   - value 4
     * @param v5   - value 5
     * @param v6   - value 6
     * @param v7   - value 7
     * @param v8   - value 8
     * @param v9   - value 9
     * @param v10  - value 10
     * @param v11  - value 11
     * @param v12  - value 12
     * @return a mutable Tuple containing 12 values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11, T12 v12) {
        return new Tuple12<>(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
    }

}