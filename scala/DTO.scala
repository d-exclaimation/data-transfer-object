//
//  DTO.scala
//  data-transfer-object
//
//  Created by d-exclaimation on 5:17 PM.
//


package schema.response

import spray.json.JsonFormat

/**
 * Data Transfer Object
 *
 * Allowing better JSON Responses that can be easily parsed
 *
 * @param data   Successful data response or None if unsuccessful.
 * @param errors Errors array if unsuccessful oor otherwise None.
 * @tparam TData  Data response type that conforms to JSON format.
 * @tparam TError Error response type that conforms to JSON Format.
 */
case class DTO[TData: JsonFormat, TError: JsonFormat](
  data: Option[TData],
  errors: Option[Seq[TError]]
)

object DTO extends DTOJsonProtocol {

  /**
   * Successful / Ok DTO
   *
   * @param data Successful data.
   * @tparam T Successful data type.
   * @return Successful DTO.
   */
  def ok[T: JsonFormat](data: T): DTO[T, Null] = DTO(
    data = Some(data),
    errors = None
  )

  /**
   * Unsuccessful / Error DTO
   *
   * @param error Unsuccessful error data.
   * @tparam T Error data type.
   * @return Unsuccessful DTO.
   */
  def error[T: JsonFormat](errors: T*): DTO[Null, T] = DTO(
    data = None,
    errors = Some(Seq(errors:_*))
  )
}
