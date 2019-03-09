/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.dao;

import gob.peam.administracion.beans.Persona;
import gob.peam.administracion.beans.Usuario;
import gob.peam.config.AdministracionConnectionFactory;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jpgprog84
 */
public class PersonaDao {

    private SqlSessionFactory sqlSessionFactory;

    public PersonaDao() {
        sqlSessionFactory = AdministracionConnectionFactory.getSqlSessionFactory();
    }

    public List<Persona> listarPersonas(HashMap hm) {
        List<Persona> personas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            personas = session.selectList("Persona.listarPersonas", hm);
            return personas;
        } finally {
            session.close();
        }
    }

    public Integer listarTotalPersonas(HashMap hm) {
        List<Persona> personas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            personas = session.selectList("Persona.listarTotalPersonas", hm);
            return personas.size();
        } finally {
            session.close();
        }
    }

    public HashMap insertarPersona(Persona p, Usuario u, boolean user) {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        try {
            //buscamos a la persona por dni
            Persona persona = session.selectOne("Persona.buscarPersonaPorDni", p.getDni());
            if (persona != null) {
                hm.put("success", false);
                hm.put("msg", "Ya existe la persona");
                return hm;
            } else {
                if (user) {
                    //aqui buscamos el usuario
                    Usuario usuario = session.selectOne("Usuario.buscarUsuarioPorLogin", u.getLogin());
                    if (usuario != null) {
                        hm.put("success", false);
                        hm.put("msg", "Ya existe el usuario");
                        return hm;
                    } else {//insertamos el usuario
                        session.insert("Persona.insertPersona", p);
                        u.setPersona(p);
                        session.insert("Usuario.insertUsuario", u);
                        hm.put("success", true);
                        hm.put("msg", "La Persona se Ingreso correctamente");
                        session.commit();
                        return hm;
                    }
                } else {
                    session.insert("Persona.insertPersona", p);
                    hm.put("success", true);
                    hm.put("msg", "La Persona se Ingreso correctamente");
                    session.commit();
                    return hm;
                }
            }
        } finally {
            session.close();
        }
    }

    public Persona buscarPersona(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Persona persona = session.selectOne("Persona.buscarPersona", id);
            return persona;
        } finally {
            session.close();
        }
    }

    public Persona buscarPersonaPorDni(String dni) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Persona persona = session.selectOne("Persona.buscarPersonaPorDni", dni);
            return persona;
        } finally {
            session.close();
        }
    }

    public boolean actualizarPersona(Persona persona) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Persona.updatePersona", persona);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public HashMap actualizarComplexPersona(Persona p, Usuario u, boolean user) {
        SqlSession session = sqlSessionFactory.openSession();
        HashMap hm = new HashMap();
        try {
            Persona personaT = session.selectOne("Persona.buscarPersonaPorDni", p.getDni());
            if (personaT == null) {
                if (user) {
                    Usuario usuarioT = session.selectOne("Usuario.buscarUsuarioPorLogin", u.getLogin());
                    if (usuarioT != null) {
                        if (usuarioT.getIdUsuario() == u.getIdUsuario()) {
                            session.update("Persona.updatePersona", p);
                            session.update("Usuario.updateUsuario", u);
                            session.commit();
                            hm.put("success", true);
                            hm.put("msg", "La Persona Se Actualizó Correctamente");
                            return hm;
                        } else {
                            hm.put("success", false);
                            hm.put("msg", "No se Puede Actualizar El Usuario Ya Existe en Otro Registro");
                            return hm;
                        }
                    } else {
                        session.update("Persona.updatePersona", p);
                        session.insert("Usuario.insertUsuario", u);
                        session.commit();
                        hm.put("success", true);
                        hm.put("msg", "La Persona Se Actulizó Correctamente");
                        return hm;
                    }
                } else {
                    session.update("Persona.updatePersona", p);
                    session.commit();
                    hm.put("success", true);
                    hm.put("msg", "La Persona Se Actulizó Correctamente");
                    return hm;
                }
            } else {
                if (personaT.getIdPersona() == p.getIdPersona()) {
                    if (user) {
                        Usuario usuarioT = session.selectOne("Usuario.buscarUsuarioPorLogin", u.getLogin());
                        if (usuarioT != null) {
                            if (usuarioT.getIdUsuario() == u.getIdUsuario()) {
                                session.update("Persona.updatePersona", p);
                                session.update("Usuario.updateUsuario", u);
                                session.commit();
                                hm.put("success", true);
                                hm.put("msg", "La Persona Se Actulizó Correctamente");
                                return hm;
                            } else {
                                hm.put("success", false);
                                hm.put("msg", "No se Puede Actualizar El Usuario Ya Existe en Otro Registro");
                                return hm;
                            }
                        } else {
                            session.update("Persona.updatePersona", p);
                            session.update("Usuario.insertUsuario", u);
                            session.commit();
                            hm.put("success", true);
                            hm.put("msg", "La Persona Se Actualizó Correctamente");
                            return hm;
                        }
                    } else {
                        session.update("Persona.updatePersona", p);
                        session.commit();
                        hm.put("success", true);
                        hm.put("msg", "La Persona Se Actulizó Correctamente");
                        return hm;
                    }
                } else {
                    hm.put("success", false);
                    hm.put("msg", "No se Puede Actualizar La Persona Ya Existe en Otro Registro");
                    return hm;
                }
            }
        } finally {
            session.close();
        }
    }

    public boolean eliminarPersona(Integer pers_id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("Persona.delPersona", pers_id);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public boolean existePersonaParaEliminar(Integer idPersona) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Persona p = session.selectOne("Persona.existePersonaParaEliminar", idPersona);
            if (p == null) {
                return false;
            } else {
                return true;
            }
        } finally {
            session.close();
        }
    }

    public List<Persona> listarPersonasForDependencia(HashMap hm) {
        List<Persona> personas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personas = sqlSession.selectList("Persona.listarPersonasPorDependencia", hm);
            return personas;
        } finally {
            sqlSession.close();
        }
    }

    public Integer listarTotalPersonaForDependencia(HashMap hm) {
        List<Persona> personas;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            personas = sqlSession.selectList("Persona.listarTotalPersonasPorDependencia", hm);
            return personas.size();
        } finally {
            sqlSession.close();
        }
    }

    public List<Persona> listarEmpleados(HashMap hm) {
        List<Persona> personas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            personas = session.selectList("Persona.listarEmpleados", hm);
            return personas;
        } finally {
            session.close();
        }
    }

    public Integer listarTotalEmpleados(HashMap hm) {
        List<Persona> personas;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            personas = session.selectList("Persona.listarTotalEmpleados", hm);
            return personas.size();
        } finally {
            session.close();
        }
    }
}
