//
//  DTOJsonProtocol.scala
//  akkaaaaaaaaaaaaaaaaaaaa
//
//  Created by d-exclaimation on 9:00 PM.
//


package dto

import spray.json.{DefaultJsonProtocol, DeserializationException, JsNull, JsValue, JsonFormat, NullOptions, RootJsonFormat}

/**
 * DTO Json Formatter Protocol with NullOptions
 *
 * {{{
 * {
 *   "data": ...,
 *   "errors": null
 * },
 * {
 *   "data": null,
 *   "errors": [...]
 * }
 * }}}
 */
trait DTOJsonProtocol extends DefaultJsonProtocol with NullOptions {
  /**
   * Null JSON Formatter
   */
  implicit object NullJson extends RootJsonFormat[Null] {
    override def write(obj: Null): JsValue = JsNull

    override def read(json: JsValue): Null = json match {
      case JsNull => null
      case _ => throw DeserializationException("Null is only null")
    }
  }

  implicit def dtoJson[TData: JsonFormat, TError: JsonFormat]: RootJsonFormat[DTO[TData, TError]] =
    jsonFormat2(DTO.apply[TData, TError])

}
