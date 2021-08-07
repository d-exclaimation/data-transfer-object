#
#  dto.ex
#  data-transfer-object
#
#  Created by d-exclaimation on 08:45.
#

defmodule DTO do
  @moduledoc """
  Data transfer Object JSON
  """
  @type t(d) :: %{data: d, errors: [term]} 

  @doc """
  Render User information as JSON
  """
  @spec render(String.t(), map()) :: map()
  def render("ok", %{data: data}) do
    %{data: data, errors: nil}
  end
  
  def render("error", %{errors: errors}) do
    %{data: nil, errors: errors}
  end
end
