package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajeseleccionaropcionmigr extends GXProcedure
{
   public mensajeseleccionaropcionmigr( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajeseleccionaropcionmigr.class ), "" );
   }

   public mensajeseleccionaropcionmigr( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 )
   {
      mensajeseleccionaropcionmigr.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             String[] aP4 )
   {
      mensajeseleccionaropcionmigr.this.AV10CliCod = aP0;
      mensajeseleccionaropcionmigr.this.AV8palabra = aP1;
      mensajeseleccionaropcionmigr.this.AV11propia = aP2;
      mensajeseleccionaropcionmigr.this.AV12puedeCrear = aP3;
      mensajeseleccionaropcionmigr.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV12puedeCrear )
      {
         AV9mensaje = httpContext.getMessage( "Si selecciona \"", "") + GXutil.trim( AV11propia) + httpContext.getMessage( "\" se creará registro de ", "") + GXutil.trim( AV8palabra) + httpContext.getMessage( " en el sistema al confirmar la importación.", "") ;
      }
      else
      {
         AV9mensaje = httpContext.getMessage( "No existe \"", "") + GXutil.trim( AV11propia) + httpContext.getMessage( "\". Debe seleccionar una opción válida.", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = mensajeseleccionaropcionmigr.this.AV9mensaje;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9mensaje = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8palabra ;
   private String AV11propia ;
   private boolean AV12puedeCrear ;
   private String AV9mensaje ;
   private String[] aP4 ;
}

