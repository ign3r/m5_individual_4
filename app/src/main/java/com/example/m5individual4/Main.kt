package com.example.m5individual4

fun main(){

    val gestionLista = GestionLista()

    // Crear usuarios
    val usuario1 = Usuario("Juan Perez",44)
    val usuario2 = Usuario("Pedro",56,"Arquitecto", usuario1)
    val usuario3 = Usuario("Diego",23,"Operario", usuario2)
    val usuario4 = Usuario("Andrea", 28)
    val usuario5 = Usuario("Carla", 33, "Diseñadora", usuario3)



    // Agregar usuarios a la lista
    gestionLista.agregarUsuario(usuario1)
    gestionLista.agregarUsuario(usuario2)
    gestionLista.agregarUsuario(usuario3)
    gestionLista.agregarUsuario(usuario4)
    gestionLista.agregarUsuario(usuario5)

    // Mostrar lista de usuarios
    println("*******************************")
    println("Lista inicial de usuarios:")
    println("*******************************")
    gestionLista.mostrarLista()
    println("*******************************")
    println("")

    // Eliminar un usuario
    println("*******************************")
    println("ELIMINANDO A DIEGO")
    println("*******************************")
    gestionLista.eliminarUsuario("Diego")
    println("")

    // Mostrar lista actualizada de usuarios
    println("*******************************")
    println("Lista despues de eliminar a Diego:")
    println("*******************************")
    gestionLista.mostrarLista()
}

//CONSTRUCTOR PRIMARIO
class Usuario (
    val nombre:String,
    val edad :Int,
    val trabajo: String? = null,
    val referencia: Usuario? = null
){
    fun mostrarDatos() {
        print("${this.nombre} ")
        print("- ${this.edad} años ")
        if (this.trabajo != null) {
            print("- ${this.trabajo} ")
        } else {
            print("")
        }
        if (this.referencia != null) {
            print("- Fue referenciado por: ${this.referencia?.nombre} de ${this.referencia?.edad} años")
        } else {
            print("")
        }
        println("")
    }
}
class GestionLista {
    // Lista mutable para almacenar los usuarios
    val listaUsuarios = mutableListOf<Usuario>()

    // Función para agregar un usuario a la lista
    fun agregarUsuario(usuario: Usuario) {
        listaUsuarios.add(usuario)
        println("Usuario agregado: ${usuario.nombre}")
    }

    // Función para eliminar un usuario de la lista
    fun eliminarUsuario(nombre: String) {
        val usuarioAEliminar = listaUsuarios.find { it.nombre == nombre }
        if (usuarioAEliminar != null) {
            listaUsuarios.remove(usuarioAEliminar)
            println("Usuario eliminado: $nombre")
        } else {
            println("Usuario no encontrado: $nombre")
        }
    }

    // Función para mostrar la lista completa de usuarios
    fun mostrarLista() {
        if (listaUsuarios.isEmpty()) {
            println("La lista está vacía.")
        } else {
            println("Lista de Usuarios:")
            listaUsuarios.forEach { it.mostrarDatos() }
        }
    }
}