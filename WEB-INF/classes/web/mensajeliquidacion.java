package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajeliquidacion extends GXProcedure
{
   public mensajeliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajeliquidacion.class ), "" );
   }

   public mensajeliquidacion( int remoteHandle ,
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
      AV9errores = AV8websession.getValue(httpContext.getMessage( "&erroresLiq", "")) ;
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV9errores)), httpContext.getMessage( "OK", "")) == 0 ) || ( GXutil.strSearch( GXutil.trim( AV9errores), httpContext.getMessage( "histórica", ""), 1) != 0 ) )
      {
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV9errores)), httpContext.getMessage( "OK", "")) == 0 )
         {
            new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "La Liquidación se generó correctamente. En unos segundos se calcularán todos los conceptos de la misma.", "")) ;
         }
         else
         {
            new web.alert(remoteHandle, context).execute( "success", GXutil.trim( AV9errores)) ;
         }
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV9errores)==0) )
         {
            if ( GXutil.strSearch( AV9errores, httpContext.getMessage( "Error al eliminar el archivo", ""), 1) != 0 )
            {
               new web.alert(remoteHandle, context).execute( "error", GXutil.trim( AV9errores)) ;
            }
            else
            {
               new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "La Liquidación se generó con errores.", "")) ;
            }
         }
      }
      AV8websession.remove(httpContext.getMessage( "&erroresLiq", ""));
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
      AV9errores = "" ;
      AV8websession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9errores ;
   private com.genexus.webpanels.WebSession AV8websession ;
}

