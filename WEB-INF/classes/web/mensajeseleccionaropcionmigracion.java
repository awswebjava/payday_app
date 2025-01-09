package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajeseleccionaropcionmigracion extends GXProcedure
{
   public mensajeseleccionaropcionmigracion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajeseleccionaropcionmigracion.class ), "" );
   }

   public mensajeseleccionaropcionmigracion( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      mensajeseleccionaropcionmigracion.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      mensajeseleccionaropcionmigracion.this.AV10CliCod = aP0;
      mensajeseleccionaropcionmigracion.this.AV8palabra = aP1;
      mensajeseleccionaropcionmigracion.this.AV11propia = aP2;
      mensajeseleccionaropcionmigracion.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9mensaje = httpContext.getMessage( "Si selecciona \"", "") + GXutil.trim( AV11propia) + httpContext.getMessage( "\" se creará registro de ", "") + GXutil.trim( AV8palabra) + httpContext.getMessage( " en el sistema al confirmar la importación", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = mensajeseleccionaropcionmigracion.this.AV9mensaje;
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
   private String AV9mensaje ;
   private String[] aP3 ;
}

