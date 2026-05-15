package org.example

fun main() {

    val N = readln().toInt()

    tipoNum(N)
    println(tipoNum(N))

}
fun tipoNum(numero: Int): String {
    return if (numero % 2 == 0) "Par"
    else "Impar"
}
fun nota(nota: Int): String {
    return when (nota) {
        in 90..100 -> "Excelente"
        in 70 .. 89 -> "Aprovado"
        in 50 .. 69 -> "Recuperação"
        in 0 .. 49 -> "Nota inválida"
        else -> "Nota inválida"
    }
}
fun validar(nome: String, horario: String): String {
    if (nome.isBlank()) {
        return "Nome obrigatorio"
    }
    val carga = horario.toIntOrNull()
        ?: return "Carga horaria deve ser numerica"
    if (carga <= 0) {
        return "Carga horaria deve ser maior que zero"
    }
    if (carga > 400) {
        return "Carga horaria não pode passar de 400"
    }
    return "Curso valido"
}
data class Curso(
    val id: Int,
    val nome: String,
    val categoria: String,
    val cargaHoraria: Int,
    val nota: Double,
    val ativo: Boolean
)
fun busca(cursos: List<Curso>, id: Int): Curso? {
    return cursos.firstOrNull {it.id == id}
}
fun filtrar(cursos: List<Curso>): List<Curso> {
    return cursos.filter {it.ativo}
}
fun ranking(cursos: List<Curso>): List<Curso> {
    return cursos.sortedByDescending { it.nota }
}
fun agrupar(cursos: List<Curso>): Map<String, List<Curso>> {
    return cursos.groupBy {it.categoria}
}
fun calcular(cursos: List<Curso>): Int {
    return cursos
        .filter {it.ativo}
        .sumOf {it.cargaHoraria}
}
fun listar(cursos: List<Curso>): List<String> {
    return cursos
        .map {it.categoria}
        .toSet()
        .toList()
}
