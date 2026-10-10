public class ValidadorCEP {

    public void validarCep (String cep){
        if (cep.length() != 8 ) {
            throw new CepInvalidoException();
        }
        boolean cepValido = true;

        for (int i = 0; i < cep.length(); i++) {
            boolean testeCaractereNumero = Character.isDigit(cep.charAt(i));
            if (testeCaractereNumero == false){
                cepValido = false;
            }
        }
        if (cepValido == false){
            throw new CepInvalidoException();
        }
    }

}
