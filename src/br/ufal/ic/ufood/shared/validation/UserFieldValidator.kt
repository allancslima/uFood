package br.ufal.ic.ufood.shared.validation

object UserFieldValidator {

    fun validateEmail(email: String): Boolean {
        val pattern = "^[a-zA-Z0-9_!#\$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\$"
        return email.matches(Regex(pattern))
    }

    fun validatePassword(password: String): Boolean = password.length > 5

    fun validateName(name: String): Boolean {
        val pattern = "^[a-zA-z\\s]+$"
        return name.matches(Regex(pattern))
    }

    fun validatePhoneNumber(phoneNumber: String): Boolean {
        val pattern = "^[(]\\d{2}[)]\\d{5}[-]\\d{4}$"
        return phoneNumber.matches(Regex(pattern))
    }

}
