package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajeeligenosac extends GXProcedure
{
   public mensajeeligenosac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajeeligenosac.class ), "" );
   }

   public mensajeeligenosac( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      mensajeeligenosac.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      mensajeeligenosac.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8mensaje = httpContext.getMessage( "No se liquida SAC en el mismo recibo mensual por elección del usuario", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = mensajeeligenosac.this.AV8mensaje;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8mensaje = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8mensaje ;
   private String[] aP0 ;
}

