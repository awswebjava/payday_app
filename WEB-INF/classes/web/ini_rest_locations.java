package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_rest_locations extends GXProcedure
{
   public ini_rest_locations( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_rest_locations.class ), "" );
   }

   public ini_rest_locations( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      ini_rest_locations.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11baseTexto = "" ;
      new web.newrest_location(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "GuardaLiquidacion_rest", ""), false, "/"+GXutil.trim( AV11baseTexto)+httpContext.getMessage( "com.paga.ahttp_guardaliquidacion", ""), (byte)(0), httpContext.getMessage( "localhost", ""), new web.puertotomcat(remoteHandle, context).executeUdp( ), (short)(0), (byte)(0)) ;
      new web.newrest_location(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "chequearLiquidacionFin", ""), false, "/"+GXutil.trim( AV11baseTexto)+httpContext.getMessage( "com.paga.ahttp_chequearliquidacionfin", ""), (byte)(0), httpContext.getMessage( "localhost", ""), new web.puertotomcat(remoteHandle, context).executeUdp( ), (short)(0), (byte)(0)) ;
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
      AV11baseTexto = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV11baseTexto ;
}

