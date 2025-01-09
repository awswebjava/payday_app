package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenuitemsconvenio extends GXProcedure
{
   public inimenuitemsconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenuitemsconvenio.class ), "" );
   }

   public inimenuitemsconvenio( int remoteHandle ,
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
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Principal", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Liberación de actualizaciones", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenios disponibles", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Conceptos", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Fórmula", ""), "", false, httpContext.getMessage( "Conceptos", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Datos de convenio", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Importes de convenio", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Adicionales", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Opciones de adicional", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Importes de adicional", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Categorías", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Escalas salariales", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Actualizar tarifas categorías", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Vacaciones por antigüedad", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Fondo de cese laboral", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Licencias que cancelan adicionales", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Variables", ""), httpContext.getMessage( "Variables", ""), false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Valores", ""), "", false, httpContext.getMessage( "Variables", ""), true) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Cálculos", ""), httpContext.getMessage( "Cálculos", ""), false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Actualizaciones", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Reinicializar datos", ""), "", false, httpContext.getMessage( "Principal", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Bases de cálculo", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio licencias jornal", ""), httpContext.getMessage( "Configuración para cálculos de licencias en clase jornal", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio licencias mensual", ""), httpContext.getMessage( "Configuración para cálculos de licencias en clase mensual", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio feriados jornal", ""), httpContext.getMessage( "Configuración para cálculos de feriados en clase jornal", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio feriados mensual", ""), httpContext.getMessage( "Configuración para cálculos de feriados en clase mensual", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio hora normal jornal", ""), httpContext.getMessage( "Configuración para cálculos de hora normal en clase jornal", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio hora normal mensual", ""), httpContext.getMessage( "Configuración para cálculos de hora normal en clase mensual", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio Horas extras", ""), httpContext.getMessage( "Horas extras", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(3), httpContext.getMessage( "Convenio Horas extras extraordinarias", ""), httpContext.getMessage( "Horas extras extraordinarias", ""), false, httpContext.getMessage( "Bases de cálculo", ""), false) ;
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
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
}

