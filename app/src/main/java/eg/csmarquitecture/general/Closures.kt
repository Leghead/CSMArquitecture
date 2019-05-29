package eg.csmarquitecture.general

import eg.csmarquitecture.be.Country.CountryBE

typealias Success       = () -> Unit
typealias ErrorMessage  = (message: String) -> Unit
typealias Countries     = (response: ArrayList<CountryBE>) -> Unit