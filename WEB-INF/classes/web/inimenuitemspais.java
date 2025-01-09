package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenuitemspais extends GXProcedure
{
   public inimenuitemspais( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenuitemspais.class ), "" );
   }

   public inimenuitemspais( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Configuración", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Conceptos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Fórmula", ""), "", false, httpContext.getMessage( "Conceptos", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Condiciones concepto", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Bancos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Obras sociales", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Areas", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Puestos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Motivos de egreso", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Estados", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Parámetros", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Parámetros todos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Parámetros backend", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Variables", ""), httpContext.getMessage( "Variables", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Valores", ""), "", false, httpContext.getMessage( "Variables", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Template recibos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Tratamientos de exención IIGG", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Condiciones de exención", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Códigos SIRADIG", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Embargabilidad", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Tipos de obligación", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Tipos de liquidación", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Clientes", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Parentescos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Conceptos exportar", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Liberación de actualizaciones", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Sexos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Estados civiles", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Tipos de feriado", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Feriados", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Agenda de feriados", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Datos de país", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV11Pgmname, httpContext.getMessage( "manda País licencias jornal", "")) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País licencias jornal", ""), httpContext.getMessage( "Cálculo licencias jornal", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País licencias mensual", ""), httpContext.getMessage( "Cálculo licencias mensual", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País feriados jornal", ""), httpContext.getMessage( "Cálculo feriados jornal", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País feriados mensual", ""), httpContext.getMessage( "Cálculo feriados mensual", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País hora normal jornal", ""), httpContext.getMessage( "Cálculo hora normal jornal", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País hora normal mensual", ""), httpContext.getMessage( "Cálculo hora normal mensual", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País Horas extras", ""), httpContext.getMessage( "Horas extra", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "País Horas extras extraordinarias", ""), httpContext.getMessage( "Horas extras extraordinarias", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Adicionales reservados", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Provincias", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Localidades", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "A.R.T.", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Sindicatos", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "PaisConvenios", ""), httpContext.getMessage( "Convenios", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Vacaciones", ""), "", false, httpContext.getMessage( "Configuración", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(2), httpContext.getMessage( "Cálculos", ""), httpContext.getMessage( "Cálculos", ""), false, httpContext.getMessage( "Configuración", ""), false) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Pgmname = "" ;
      AV11Pgmname = "iniMenuItemsPais" ;
      /* GeneXus formulas. */
      AV11Pgmname = "iniMenuItemsPais" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV11Pgmname ;
}

