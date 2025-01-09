package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenuitemsnucleo extends GXProcedure
{
   public inimenuitemsnucleo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenuitemsnucleo.class ), "" );
   }

   public inimenuitemsnucleo( int remoteHandle ,
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
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "General", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Clientes", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Religiones", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Origenes", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Tipos de concepto", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Clasificaciones", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Tipos de feriado", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Tipos de trabajo", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Países", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Roles", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Perfiles", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "SVGs", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Items de menú", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Menúes", ""), "", false, httpContext.getMessage( "General", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "AFIP", ""), "", true, "", false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Actividades", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Tipos de empleador", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Zonas", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Situaciones de revista", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Siniestrados", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Condiciones", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "Modalidades de contratación", ""), "", false, httpContext.getMessage( "AFIP", ""), false) ;
      new web.newmenuitem(remoteHandle, context).execute( (byte)(1), httpContext.getMessage( "AFIPConcepto", ""), httpContext.getMessage( "Conceptos", ""), false, httpContext.getMessage( "AFIP", ""), false) ;
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

