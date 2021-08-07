//
//  DTO.kt
//  data-transfer-object
//
//  Created by d-exclaimation on 8:50 PM.
//
package json

/**
 * ### Data Transfer Object
 *
 * For return JSON in form of
 * ```json
 * {
 *   "data": ...
 *   "errors": [
 *      "..."
 *   ]
 * }
 * ```
 */
data class DTO<TData, TError>(
    val data: TData?,
    val errors: Collection<TError>? = null
) {
    companion object {

        /** Create a new successful data response */
        fun <T> ok(data: T): DTO<T, String> = DTO(
            data = data,
            errors = null
        )

        /** Create a new unsuccessful data response with 1 error */
        fun <T> error(msg: T): DTO<Any, T> = DTO(
            data = null,
            errors = listOf(msg)
        )

        /** Create a new unsuccessful data response with many errors */
        fun <T> errors(errors: Collection<T>): DTO<Any, T> = DTO(
            data = null,
            errors = errors
        )
    }
}
